package Mood;
public class BadMood implements Mood {
    private final int quality = 4;
    private String feeling = "bad";

    public String getMood() {
        return feeling;
    }

    public int moodQuality() {
        return quality;
    }

    public Mood increaseMood()
    {
        return new NormalMood();
    }

    public Mood decreaseMood()
    {
        return new HorribleMood();
    }
}
