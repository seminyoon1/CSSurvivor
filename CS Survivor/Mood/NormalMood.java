package Mood;
public class NormalMood implements Mood{
    private final int quality = 6;
    private String feeling = "normal";

    public String getMood() {
        return feeling;
    }

    public int moodQuality() {
        return quality;
    }

    public Mood increaseMood()
    {
        return new GoodMood();
    }

    public Mood decreaseMood()
    {
        return new BadMood();
    }
}
