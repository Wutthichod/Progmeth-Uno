package logic.card;

import application.GameLoop;
import Enum.CardColor;
import Enum.CardEffect;

public class SkipCard extends EffectCard {

    public SkipCard(CardColor color) {
        super(color, CardEffect.SKIP);
    }

    @Override
    public void useEffect() {
        int skippedTurn = GameLoop.getGameInstance().getDirection();
        int currentPlayer = GameLoop.getGameInstance().getCurrentPlayerIndex();
        GameLoop.getGameInstance().setCurrentPlayerIndex(currentPlayer + skippedTurn);
    }
}