import java.util.Scanner;

import SubGames.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Welcome to CS Survivor!");
        boolean start = true;
        Scanner intro = new Scanner(System.in); 
        while(start) {
            System.out.println("Is this your first time playing? Y/N");
            String introAnswer = intro.nextLine(); 
            if(introAnswer.equals("Y")) {
                Introduction.runIntroduction();
                start = false;
            } else if(introAnswer.equals("N")) {
                start = false;
            } else {
                System.out.println("Please answer with Y or N.");
            }
        }
        System.out.println("What name do you want your character to be?");
        String name = intro.nextLine();
        if(name.equals("")) {
            while(name.equals("")) {
                intro = new Scanner(System.in);
                System.out.println("Please enter a valid name. What name do you want your character to be?");
                name = intro.nextLine();
            }
        }
        String[] schedule = new String[23];
        User user = new User(name, 100, 100, "Well Rested", 100, 1000, schedule, "average", "normal");
        boolean level = true;
        int gameDifficulty = -1;
        while(level) {
            System.out.println("Select game difficulty: Easy, Medium, Hard, Difficult. E/M/H/D");
            String levelAnswer = intro.nextLine();
            if(levelAnswer.equals("E")) {
                gameDifficulty = 1;
                level = false;
            } else if (levelAnswer.equals("M")) {
                gameDifficulty = 2;
                level = false;
            }else if (levelAnswer.equals("H")) {
                gameDifficulty = 3;
                level = false;
            } else if(levelAnswer.equals("D")) {
                gameDifficulty = 4;
                level = false;
            } else {
                System.out.println("Please answer with E/M/H/D.");
            }
        }
        System.out.println("Welcome " + user.getName() + "!");
        if(gameDifficulty == 1) {
            GameDiff1.main(user.getName(), user.getHealth(), user.getHunger());
        } else if(gameDifficulty == 2) {
            GameDiff2.main(user.getName(), user.getHealth(), user.getHunger(), user.getSleep(), user.getExercise());
        } else if (gameDifficulty == 3) {
            GameDiff3.main(user.getName(), user.getHealth(), user.getHunger(), user.getSleep(), user.getExercise(),
                            user.getMoney(), user.getSchedule());
        } else {
            GameDiff4.main(user.getName(), user.getHealth(), user.getHunger(), user.getSleep(), user.getExercise(),
            user.getMoney(), user.getSchedule(), user.getInteraction(), user.getClothing());
        }
        intro.close();
	}
}