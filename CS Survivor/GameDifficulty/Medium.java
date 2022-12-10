package GameDifficulty;

public class Medium extends Game {
    private int currentDay;
    private int health;
    private int hunger;
    private String sleep; //very tired, tired, rested, well rested
    private int exercise;

    public Medium(int currentDay, int health, int hunger, String sleep, int exercise) {
        super(currentDay, health, hunger);
        this.sleep = sleep;
        this.exercise = exercise;
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

    public String toString()
    {
        String str = "Current Day: " + super.getDay() + ", Health: " + super.getHealth() + ", Hunger: " + super.getHunger() + ", Sleep: " + sleep + ", " +
        "\nExercise: " + exercise;
        return str;
    }
}
