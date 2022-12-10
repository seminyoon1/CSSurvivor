package Interaction;

public abstract class InteractionDecorator implements Interaction {
    private Interaction interaction;

    public InteractionDecorator(Interaction interact) {
        interaction = interact;
    }

    public void haveInteraction() {
        interaction.haveInteraction();
    }
}