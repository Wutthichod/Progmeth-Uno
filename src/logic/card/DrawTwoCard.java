package logic.card;

import application.GameLoop;
import Enum.CardColor;
import Enum.CardEffect;
import logic.game.Deck;
import logic.game.Player;

public class DrawTwoCard extends EffectCard {

    public DrawTwoCard(CardColor color) {
        super(color, CardEffect.DRAW_TWO);
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