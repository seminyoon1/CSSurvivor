package Interaction;

public class ClubInteraction extends InteractionDecorator
{
    public ClubInteraction(Interaction club)
    {
        super(club);
    }
    public void haveInteraction()
    {
        super.haveInteraction();
        System.out.println("You make your way to your club.");
    }
}