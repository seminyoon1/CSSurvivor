package Mood;
public class GoodMood implements Mood{
    private final int quality = 8;
    private String feeling = "good";

    public String getMood() {
        return feeling;
    }

    public int moodQuality() {
        return quality;
    }

    public Mood increaseMood()
    {
        return new ExcellentMood();
    }

    public Mood decreaseMood()
    {
        return new NormalMood();
    }
}
