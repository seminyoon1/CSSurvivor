public class User //Singleton Pattern
{
    private final String name;
    private int health;
    private int hunger;
    private String sleep; //very tired, tired, rested, well rested
    private int exercise;
    private int money;
    private String[] schedule;
    private String interaction; //none, little, average, very
    private String clothing; //

    public User(String name, int health, int hunger, String sleep, int exercise, int money, String[] schedule, String interaction, String clothing)
    {
        this.name = name;
        this.health = health;
        this.hunger = hunger;
        this.sleep = sleep;
        this.exercise = exercise;
        this.money = money;
        this.schedule = schedule;
        this.interaction = interaction;
        this.clothing = clothing;
    }

    public String getName()
    {
        return this.name;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public int getHealth()
    {
        return this.health;
    }

    public void setHunger(int hunger)
    {
        this.hunger = hunger;
    }

    public int getHunger()
    {
        return this.hunger;
    }

    public void setSleep(String sleep)
    {
        this.sleep = sleep;
    }

    public String getSleep()
    {
        return this.sleep;
    }

    public void setExercise(int exercise)
    {
        this.exercise = exercise;
    }

    public int getExercise()
    {
        return this.exercise;
    }

    public void setMoney(int money)
    {
        this.money = money;
    }

    public int getMoney()
    {
        return this.money;
    }

    public void setSchedule(String[] schedule)
    {
        this.schedule = schedule;
    }

    public String[] getSchedule()
    {
        return this.schedule;
    }

    public void setInteraction(String interaction)
    {
        this.interaction = interaction;
    }

    public String getInteraction()
    {
        return this.interaction;
    }

    public void setClothing(String clothing)
    {
        this.clothing = clothing;
    }

    public String getClothing()
    {
        return this.clothing;
    }
        
    public String toString()
    {
        String str = "Name: " + name + ", Health: " + health + ", Hunger: " + hunger;
        if(sleep != null) 
        {
            str += ", Sleep: " + sleep;
        }
        if(exercise != 0)
        {
            str += " " + exercise;
        }

        return str;
    }
}

