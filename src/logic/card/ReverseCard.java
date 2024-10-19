package logic.card;

import application.GameLoop;
import Enum.CardColor;
import Enum.CardEffect;

public class ReverseCard extends EffectCard {

    public ReverseCard(CardColor color) {
        super(color, CardEffect.REVERSE);
    }

    @Override
    public void useEffect() {
        int newDirection = -1 * GameLoop.getGameInstance().getDirection();
        GameLoop.getGameInstance().setDirection(newDirection);
    }
}