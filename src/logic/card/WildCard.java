package logic.card;

import Enum.CardEffect;

public class WildCard extends BaseWildCard{

    public WildCard() {
        super(CardEffect.WILD);
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