package Mood;
public class HorribleMood implements Mood {
    private final int quality = 2;
    private String feeling = "horrible";

    public String getMood() {
        return feeling;
    }

    public int moodQuality() {
        return quality;
    }

    public Mood increaseMood()
    {
        return new BadMood();
    }

    public Mood decreaseMood()
    {
        System.out.println("Mood cannot go any lower!");
        return new HorribleMood();
    }
}
