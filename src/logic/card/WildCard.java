package logic.card;

import logic.game.CardEffect;

public class WildCard extends BaseWildCard{

    private final CardEffect effect = CardEffect.WILD;

    public WildCard() {
        super();
    }

    @Override
    public String toString() {
        return "WILD";
    }

    @Override
    public void useEffect() {
        this.setColor(application.GameIO.chooseColor(this));
    }
}
