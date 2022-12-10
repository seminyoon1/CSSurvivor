package SubGames;

import java.util.Scanner;
import GameDifficulty.*;
import Interaction.*;
import Mood.*;

public class GameDiff4 {
    public static void main(String name, int health, int hunger, String sleep, 
                            int exercise, int money, String[] schedule, String interaction, String clothing) throws InterruptedException {    
        Mood currentMood = new NormalMood();
        Scanner intro = new Scanner(System.in);
        Difficult currentGame = new Difficult(0, health, hunger, sleep, exercise, money, schedule, interaction, clothing);
        System.out.println("Please pick your schedule.");
        for(int i = 0; i < 7; i++) {
            System.out.println("Pick your time for class "+ (i+1) +".");
            boolean a = true;
            int num = 0; 
            while(a) {
                System.out.println("AM or PM? AM/PM");
                String aOrP = intro.nextLine();
                if(aOrP.equals("AM")) {
                    a = false;
                } else if(aOrP.equals("PM")) {
                    num += 12;
                    a = false;
                } else {
                    System.out.println("Not a valid choice. Please try again.");
                }
            }
            a = true;
            while(a) {
                System.out.println("What hour? Pick 1-12.");
                String number = intro.nextLine();
                try {
                    int numNum = Integer.parseInt(number);
                    if(numNum >= 0 && numNum <= 12) {
                        num += numNum % 12;
                        if(currentGame.getSchedule()[num] == null) {
                            currentGame.setSchedule(num, "Class " + Integer.toString(i+1));
                            a = false;
                        } else {
                            System.out.println("This time already has a class. Please try again.");
                        }
                    } else {
                        System.out.println("Not a valid choice. Please try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Not a valid choice. Please try again.");
                }
            }
        }
        for(int i = 0; i < 23; i++) {
            if(currentGame.getSchedule()[i] == null) {
                currentGame.setSchedule(i, "-");
            }
        }
        System.out.println(currentGame + "\nCurrent Mood: " + currentMood.getMood());
        System.out.println("Remember to go each class ever day! Type X to see your status. \n");
        Sleep currSleep = new Sleep(99);
        String timeM = "AM";
        int[] study = {0,0,0,0,0,0,0};
        while(currentGame.getDay() <= 29) {
            boolean exercised = false;
            boolean[] classes = {false, false, false, false, false, false, false};
            for(int i = 0; i < 24; i++) {
                if(i == 12) {
                    timeM = "PM";
                } else if(i == 0) {
                    timeM = "AM";
                }
                if(i % 12 == 0) {
                    System.out.println("Current Hour: " + (12 + timeM) + "\n");
                    if(currentGame.getHealth() < 45) {
                        currentMood = currentMood.decreaseMood();
                        if(currentGame.getHealth() == 0) {
                            System.out.println("Due to lack of health you were taken to the hospital.");
                            System.out.println("You did not graduate!");
                            System.exit(0);
                        }
                    }
                    if(currentGame.getHunger() < 45) {
                        currentMood = currentMood.decreaseMood();
                        if(currentGame.getHunger() < 20) {
                            currentMood = currentMood.decreaseMood();
                            if(currentGame.getHunger() == 0) {
                                System.out.println("Due to lack of food you were taken to the hospital.");
                                System.out.println("You did not graduate!");
                                System.exit(0);
                            }
                        }
                    }
                    if(currentGame.getSleep().equals("Very Tired")) {
                        currentMood = currentMood.decreaseMood();
                        if(currSleep.getNum() == 0) {
                            System.out.println("Due to lack of sleep you were taken to the hospital.");
                            System.out.println("You did not graduate!");
                            System.exit(0);
                        }
                    }
                } else {
                    System.out.println("Current Hour: " + (i % 12 + timeM)+"\n");
                }
                System.out.println("What will you do? Study/Eat/Sleep/Class/Play/Exercise/Work/Interaction/X ");
                String response = intro.nextLine();
                if(response.equals("Study")) {
                    System.out.println("Which class will you study for? Pick 1-7 ");
                    String numValue = intro.nextLine();
                    try {
                        int num = Integer.parseInt(numValue);
                        if(num >= 1 && num <= 7) {
                            System.out.println("You have chosen to study for class "+ num +".");
                            study[num - 1] += currentMood.moodQuality() * 60;
                            System.out.println("Your mood has gone down.\n");
                        } else {
                            System.out.println("You choose not to study.\n");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("You choose not to study.\n");
                    }
                    currentMood = currentMood.decreaseMood();
                    currentGame.decreaseHealth(6);
                    currentGame.decreaseHunger(6);
                    currSleep.decreaseSleep(6);
                    currentGame.setSleep(currSleep.checkString());
                } else if(response.equals("Play")) {
                    System.out.println("You have decided to play. Mood has increased.\n");
                    currentMood = currentMood.increaseMood();
                    currentGame.decreaseHealth(6);
                    currentGame.decreaseHunger(6);
                    currSleep.decreaseSleep(6);
                    currentGame.setSleep(currSleep.checkString());
                } else if(response.equals("Interaction")) {
                    ClubInteraction toClub = new ClubInteraction(new CampusInteraction(new MainInteraction()));
                    toClub.haveInteraction();
                    currentMood.increaseMood();
                    System.out.println("");
                } else if(response.equals("Class")) {
                    CampusInteraction toClass = new CampusInteraction(new MainInteraction());
                    toClass.haveInteraction();
                    System.out.println("Which class will you go to? Pick 1-7 ");
                    String numValue = intro.nextLine();
                    try {
                        int num = Integer.parseInt(numValue);
                        if((num >= 1 && num <= 7) && schedule[i].equals("Class " + num)) {
                            System.out.println("You have chosen to go to class "+ num +".\n");
                            classes[num - 1] = true;
                        } else {
                            System.out.println("You don't have this class right now.\n");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("The class doesn't exist.\n");
                    }
                    currSleep.decreaseSleep(6);
                    currentGame.setSleep(currSleep.checkString());
                    currentGame.decreaseHealth(6);
                    currentGame.decreaseHunger(6);
                } else if(response.equals("Sleep")) {
                    currSleep.addSleep(20);
                    currentGame.setSleep(currSleep.checkString());
                    System.out.println("You choose to sleep for an hour.\n");
                    currentGame.addHealth(15);
                    currentGame.decreaseHunger(6);
                } else if(response.equals("Eat")) {
                    boolean canBuy = currentGame.decreaseMoney(15);
                    if(canBuy == true) {
                        System.out.println("You choose to have a nice meal and paid $15.\n");
                        currentGame.addHunger(30);
                    } else {
                        System.out.println("You do not have enough money! Could not buy.");
                    }
                    currSleep.decreaseSleep(6);
                    currentGame.setSleep(currSleep.checkString());
                } else if(response.equals("X")) {
                    System.out.println("Current Day: " + currentGame.getDay());
                    System.out.println(currentGame + "\nCurrent Mood: " + currentMood.getMood() + "\n");
                    i -= 1;
                } else if(response.equals("Exercise")) {
                    exercised = true;
                    currentGame.addExercise(2);
                    if(currentGame.getExercise() % 4 == 0) {
                        currentMood = currentMood.increaseMood();
                    }
                } else if(response.equals("Work")) {
                    System.out.println("You chose to work this hour. Got paid $25.");
                    currentGame.addMoney(25);
                    currentGame.decreaseHealth(6);
                    currSleep.decreaseSleep(6);
                    currentGame.setSleep(currSleep.checkString());
                    currentGame.decreaseHunger(6);
                } else {
                    System.out.println("Not a valid choice. You did nothing this hour.\n");
                    currentGame.decreaseHealth(6);
                    currSleep.decreaseSleep(6);
                    currentGame.setSleep(currSleep.checkString());
                    currentGame.decreaseHunger(6);
                }
            }
            boolean missClass = false;
            for(int i = 0; i < 7; i++) {
                if(classes[i] == false) {
                    missClass = true;
                    study[i] -= 13;
                }
            }
            if(missClass == true) {
                System.out.println("You did not attend all your classes today!");
                    currentMood.decreaseMood();
            }
            if(exercised == false) {
                System.out.println("You did not exercise today. Health with decrease.");
                currentGame.decreaseHealth(8);
            }
            currentGame.addDay();
        }
        boolean passedAll = true;
        System.out.println("Current Day: 30. Welcome to finals!");
        for(int i = 0; i < 7; i++) {
            if(study[i] > 700) {
                System.out.print("Congratulations. You have passed class " + (i+1) + " with ");
                if(study[i] > 800) {
                    System.out.print("a C grade.\n");
                } else if(study[i] > 900) {
                    System.out.print("a B grade.\n");
                } else if(study[i] > 1000) {
                    System.out.print("an A grade!\n");
                } else {
                    System.out.print("a D grade...\n");
                }
            } else {
                System.out.println("You have failed class " + (i+1) + ".");
                passedAll = false;
            }
        }
        if(passedAll == true) {
            Ending.runEnding();
        } else {
            System.out.println("You did not survive and graduate... Try Again?");
        }
        intro.close();
    }
}