package GameDifficulty;

public class Easy extends Game {
    private int currentDay;
    private int health;
    private int hunger;

    public Easy(int currentDay, int health, int hunger) {
        super(currentDay, health, hunger);
    }
}
