package logic.card;

import application.GameLoop;
import logic.game.CardColor;
import logic.game.CardEffect;

public class SkipCard extends BaseEffectCard {

    private final CardEffect effect = CardEffect.SKIP;

    public SkipCard(CardColor color) {
        super(color);
    }

    @Override
    public String toString() {
        return this.getColor() + " SKIP";
    }

    @Override
    public void useEffect() {
        int skippedTurn = GameLoop.getGameInstance().getDirection();
        GameLoop.getGameInstance().setCurrentPlayerIndex(GameLoop.getGameInstance().getCurrentPlayerIndex() + skippedTurn);
    }
}