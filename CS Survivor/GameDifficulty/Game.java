package GameDifficulty;

public abstract class Game {
    private int currentDay;
    private int health;
    private int hunger;

    public Game(int currentDay, int health, int hunger) {
        this.currentDay = currentDay;
        this.health = health;
        this.hunger = hunger;
    }

    public void addDay() {
        currentDay += 1;
    }

    public int getDay() {
        return currentDay;
    }
    public void addHealth(int num) {
        if((health + num) > 100) {
            health = 100;
        } else {
            health += num;
        }
    }

    public void decreaseHealth(int num) {
        if((health - num) < 0) {
            health = 0;
        } else {
            health -= num;
        }
    }

    public int getHealth() {
        return health;
    }

    public void addHunger(int num) {
        if((hunger + num) > 100) {
            hunger = 100;
        } else {
            hunger += num;
        }
    }

    public void decreaseHunger(int num) {
        if((hunger - num) < 0) {
            hunger = 0;
        } else {
            hunger -= num;
        }
    }

    public int getHunger() {
        return hunger;
    }

    public String toString()
    {
        String str = "Current Day: " + currentDay + ", Health: " + health + ", Hunger: " + hunger;
        return str;
    }
}
