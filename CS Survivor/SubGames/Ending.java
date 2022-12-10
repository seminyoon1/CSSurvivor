package SubGames;
public class Ending {
    // premise: you are an upcoming CS student excited to learn
    // However, things are not as joyous as it seems. 
    // You are in the midst of the pandemic
    // (easy) user: Health, Hunger, Mood -> state
    // (medium) add Sleep, Exercise
    // (hard) add Money, Schedule
    // (Difficult) add Social Interaction, Clothing
    
    public static void runEnding() throws InterruptedException {
        System.out.println("Congratulations, You have survived and passed all your exams!");
        Thread.sleep(2000);
        System.out.println("Thank you for playing!");
        Thread.sleep(2000);
        System.out.println("Created by Eliot Yoon");
    }
}