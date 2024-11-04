package logic.card;

import application.GameIO;
import application.GameLoop;
import Enum.CardColor;
import Enum.CardEffect;
import logic.game.Deck;
import logic.game.Player;

public class WildCardDrawFourCard extends EffectCard {

    public WildCardDrawFourCard() {
        super(CardColor.NO_COLOR, CardEffect.WILD_DRAW_FOUR);
    }

    @Override
    public String toString() {
        return "WILD DRAW FOUR";
    }

    @Override
    public void useEffect() {
        this.setColor(GameIO.chooseColor());
        Player nextPlayer = GameLoop.getGameInstance().getNextPlayer();
        Deck deck = GameLoop.getGameInstance().getDeck();
        for (int i = 0; i < 4; i++) {
            BaseCard drawnCard = deck.drawCard();
            nextPlayer.drawCard(drawnCard);
        }
    }
}