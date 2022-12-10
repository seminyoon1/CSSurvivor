package SubGames;
import java.util.Scanner;
import GameDifficulty.*;
import Mood.*;
import Interaction.*;

public class GameDiff1 {
    public static void main(String name, int health, int hunger) {    
        Mood currentMood = new NormalMood();
        Easy currentGame = new Easy(1, health, hunger);
        System.out.println(currentGame + "\nCurrent Mood: " + currentMood.getMood());
        System.out.println("Remember to go each class ever day! Type X to see your status. \n");
        Scanner intro = new Scanner(System.in);
        String timeM = "AM";
        int[] study = {0,0,0,0,0,0,0};
        while(currentGame.getDay() <= 29) {
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
                        if(currentGame.getHunger() < 20) {
                            currentMood = currentMood.decreaseMood();
                        }
                    }
                } else {
                    System.out.println("Current Hour: " + (i % 12 + timeM)+"\n");
                }
                System.out.println("What will you do? Study/Eat/Sleep/Class/Play/X ");
                String response = intro.nextLine();
                if(response.equals("Study")) {
                    System.out.println("Which class will you study for? Pick 1-7 ");
                    String numValue = intro.nextLine();
                    try {
                        int num = Integer.parseInt(numValue);
                        if(num >= 1 && num <= 7) {
                            System.out.println("You have chosen to study for class "+ num +".");
                            study[num - 1] += currentMood.moodQuality() * 60;
                            currentMood = currentMood.decreaseMood();
                            System.out.println("Your mood has gone down.\n");
                        } else {
                            System.out.println("You choose not to study.\n");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("You choose not to study.\n");
                    }
                    currentMood = currentMood.decreaseMood();
                    currentGame.decreaseHealth(5);
                    currentGame.decreaseHunger(5);
                } else if(response.equals("Play")) {
                    System.out.println("You have decided to play. Mood has increased.\n");
                    currentMood = currentMood.increaseMood();
                    currentGame.decreaseHealth(5);
                    currentGame.decreaseHunger(5);
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
                    currentMood = currentMood.decreaseMood();
                    currentGame.decreaseHealth(5);
                    currentGame.decreaseHunger(5);
                } else if(response.equals("Sleep")) {
                    System.out.println("You choose to sleep for an hour.\n");
                    currentGame.addHealth(15);
                    currentGame.decreaseHunger(5);
                } else if(response.equals("Eat")) {
                    System.out.println("You choose to have a nice meal.\n");
                    currentGame.addHunger(30);
                } else if(response.equals("X")) {
                    System.out.println("Current Day: " + currentGame.getDay());
                    System.out.println(currentGame + "\nCurrent Mood: " + currentMood.getMood() + "\n");
                    i -= 1;
                } else {
                    System.out.println("Not a valid choice. You did nothing this hour.\n");
                    currentGame.decreaseHealth(5);
                    currentGame.decreaseHunger(5);
                }
            }
            currentGame.addDay();
        }
        System.out.println("Current Day: 30. Welcome to finals!");
        for(int i = 0; i < 7; i++) {
            if(study[i] > 220) {
                System.out.print("Congratulations. You have passed class " + (i+1) + " with ");
                if(study[i] > 290) {
                    System.out.print("a C grade.\n");
                } else if(study[i] > 360) {
                    System.out.print("a B grade.\n");
                } else if(study[i] > 435) {
                    System.out.print("an A grade!\n");
                } else {
                    System.out.print("a D grade...\n");
                }
            } else {
                System.out.println("You have failed class " + (i+1) + ".");
            }
        }
        intro.close();
    }
}