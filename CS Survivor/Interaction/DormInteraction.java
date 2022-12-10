package Interaction;

public class DormInteraction extends InteractionDecorator
{
    public DormInteraction(Interaction dorm)
    {
        super(dorm);
    }
    public void haveInteraction()
    {
        super.haveInteraction();
        System.out.println("You arrive to your dorm.");
    }
}
