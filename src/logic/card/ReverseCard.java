package logic.card;

import application.GameLoop;
import logic.game.CardColor;
import logic.game.CardEffect;

public class ReverseCard extends BaseEffectCard {

    private final CardEffect effect = CardEffect.REVERSE;

    public ReverseCard(CardColor color) {
        super(color);
    }

    @Override
    public String toString() {
        return this.getColor() + " REVERSE";
    }

    @Override
    public void useEffect() {
        GameLoop.getGameInstance().setDirection(-GameLoop.getGameInstance().getDirection());
    }
}