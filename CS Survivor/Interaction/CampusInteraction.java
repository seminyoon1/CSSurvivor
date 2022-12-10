package Interaction;

public class CampusInteraction extends InteractionDecorator
{
    public CampusInteraction(Interaction campus)
    {
        super(campus);
    }
    public void haveInteraction()
    {
        super.haveInteraction();
        System.out.println("You rush over to the campus.");
    }
}
