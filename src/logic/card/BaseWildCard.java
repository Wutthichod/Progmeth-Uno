package logic.card;

import application.GameIO;

public abstract class BaseWildCard extends BaseEffectCard {

    public BaseWildCard() {
        super();
    }

    @Override
    public void play() {
        super.play();
        System.out.println("Color Changed to " + this.getColor());
    }
}