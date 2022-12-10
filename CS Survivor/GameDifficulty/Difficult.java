package GameDifficulty;
import java.util.Arrays;

public class Difficult extends Game {
    private int currentDay;
    private int health;
    private int hunger;
    private String sleep; //very tired, tired, rested, well rested
    private int exercise;
    private int money;
    private String[] schedule;
    private String interaction;
    private String clothing;


    public Difficult(int currentDay, int health, int hunger, String sleep, int exercise, int money, String[] schedule, String interaction, String clothing) {
        super(currentDay, health, hunger);
        this.sleep = sleep;
        this.exercise = exercise;
        this.money = money;
        this.schedule = schedule;
        this.interaction = interaction;
        this.clothing = clothing;
    }

    public String getSleep() {
        return sleep;
    }

    public void setSleep(String str) {
        sleep = str; 
    }

    public int getExercise() {
        return exercise;
    }

    public void addExercise(int num) {
        if((exercise + num) > 100) {
            exercise = 100;
        } else {
            exercise += num;
        }
    }

    public void decreaseExercise(int num) {
        if((exercise - num) < 0) {
            exercise = 0;
        } else {
            exercise -= num;
        }
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int num) {
        money += num;
    }

    public boolean decreaseMoney(int num) {
        if((money - num) < 0) {
            System.out.println("Unable to buy.");
            return false;
        } else {
            money -= num;
            return true;
        }
    }

    public String[] getSchedule() {
        return schedule;
    }
    
    public boolean setSchedule(int num, String str) {
        if(num >= 0 && num <= 23) {
            schedule[num] = str;
            return true;
        } else {
            System.out.println("Invalid input for schedule.");
            return false;
        }
    }

    public boolean resetSchedule(int num, String str) {
        if(num >= 0 && num <= 23) {
            schedule[num] = "";
            return true;
        } else {
            System.out.println("Invalid input for schedule.");
            return false;
        }
    }

    public String getInteraction() {
        return interaction;
    }

    public void setInteraction(String str) {
        interaction = str;
    }
    public String getClothing() {
        return clothing;
    }

    public void setClothing(String str) {
        clothing = str;
    }

    public String toString()
    {
        String str = "Current Day: " + super.getDay() + ", Health: " + super.getHealth() + ", Hunger: " + super.getHunger() + ", Sleep: " + sleep + 
        "\nExercise: " + exercise + ", Money: " + money + ", Interaction: " + interaction + ", Clothing: " + clothing +
        "\nSchedule: " + Arrays.toString(schedule);
        return str;
    }
}
