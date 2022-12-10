package Mood;
public class ExcellentMood implements Mood {
    private final int quality = 10;
    private String feeling = "excellent";

    public String getMood() {
        return feeling;
    }

    public int moodQuality() {
        return quality;
    }

    public Mood increaseMood()
    {
        System.out.println("Mood cannot go any higher!");
        return new ExcellentMood();
    }

    public Mood decreaseMood()
    {
        return new GoodMood();
    }
}
