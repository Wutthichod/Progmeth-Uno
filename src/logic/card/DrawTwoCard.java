package logic.card;

import application.GameIO;
import application.GameLoop;
import logic.game.CardColor;
import logic.game.CardEffect;
import logic.game.Deck;
import logic.game.Player;

public class DrawTwoCard extends BaseEffectCard {

    private final CardEffect effect = CardEffect.DRAW_TWO;

    public DrawTwoCard(CardColor color) {
        super(color);
    }

    @Override
    public String toString() {
        return this.getColor() + " Draw Two";
    }

    @Override
    public void useEffect() {
        Player nextPlayer = GameLoop.getGameInstance().getNextPlayer();
        Deck deck = GameLoop.getGameInstance().getDeck();
        for (int i = 0; i < 2; i++) {
            BaseCard drawnCard = deck.drawCard();
            nextPlayer.drawCard(drawnCard);
        }
    }
}
