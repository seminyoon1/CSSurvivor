package SubGames;
import java.util.Scanner;

import GameDifficulty.*;
import Interaction.*;
import Mood.*;

public class GameDiff2 {
    public static void main(String name, int health, int hunger, String sleep, int exercise) {    
        Mood currentMood = new NormalMood();
        Medium currentGame = new Medium(1, health, hunger, sleep, exercise);
        System.out.println(currentGame + "\nCurrent Mood: " + currentMood.getMood());
        System.out.println("Remember to go each class ever day! Type X to see your status. \n");
        Sleep currSleep = new Sleep(99);
        Scanner intro = new Scanner(System.in);
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
                    if(currentGame.getHealth() < 40) {
                        currentMood = currentMood.decreaseMood();
                    }
                    if(currentGame.getHunger() < 40) {
                        currentMood = currentMood.decreaseMood();
                        if(currentGame.getHunger() < 15) {
                            currentMood = currentMood.decreaseMood();
                        }
                    }
                    if(currentGame.getSleep().equals("Very Tired")) {
                        currentMood = currentMood.decreaseMood();
                    }
                } else {
                    System.out.println("Current Hour: " + (i % 12 + timeM)+"\n");
                }
                System.out.println("What will you do? Study/Eat/Sleep/Class/Play/Exercise/X ");
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
                    currSleep.decreaseSleep(5);
                    currentGame.setSleep(currSleep.checkString());
                } else if(response.equals("Play")) {
                    System.out.println("You have decided to play. Mood has increased.\n");
                    currentMood = currentMood.increaseMood();
                    currentGame.decreaseHealth(6);
                    currentGame.decreaseHunger(6);
                    currSleep.decreaseSleep(5);
                    currentGame.setSleep(currSleep.checkString());
                } else if(response.equals("Class")) {
                    CampusInteraction toClass = new CampusInteraction(new MainInteraction());
                    toClass.haveInteraction();
                    System.out.println("Which class will you go to? Pick 1-7 ");
                    String numValue = intro.nextLine();
                    try {
                        int num = Integer.parseInt(numValue);
                        if(num >= 1 && num <= 7) {
                            System.out.println("You have chosen to go to class "+ num +".\n");
                            classes[num - 1] = true;
                        } else {
                            System.out.println("You arrived to the wrong class.\n");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("The class doesn't exist.\n");
                    }
                    currSleep.decreaseSleep(5);
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
                    System.out.println("You choose to have a nice meal.\n");
                    currentGame.addHunger(30);
                    currSleep.decreaseSleep(5);
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
                }else {
                    System.out.println("Not a valid choice. You did nothing this hour.\n");
                    currentGame.decreaseHealth(6);
                    currSleep.decreaseSleep(5);
                    currentGame.setSleep(currSleep.checkString());
                    currentGame.decreaseHunger(6);
                }
            }
            for(boolean a : classes) {
                if(a == false) {
                    System.out.println("You did not attend all your classes today!");
                    currentMood.decreaseMood();
                    break;
                }
            }
            currentGame.addDay();
        }
        boolean passedAll = true;
        System.out.println("Current Day: 30. Welcome to finals!");
        for(int i = 0; i < 7; i++) {
            if(study[i] > 390) {
                System.out.print("Congratulations. You have passed class " + (i+1) + " with ");
                if(study[i] > 460) {
                    System.out.print("a C grade.\n");
                } else if(study[i] > 530) {
                    System.out.print("a B grade.\n");
                } else if(study[i] > 600) {
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
            System.out.println("\nYou have survived this semester, thank you for playing!");
        }
        intro.close();
    }
}