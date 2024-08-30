package logic.card;

import application.GameLoop;
import logic.game.CardEffect;
import logic.game.Deck;
import logic.game.Player;

public class WildCardDrawFourCard extends BaseWildCard {

    private final CardEffect effect = CardEffect.WILD_DRAW_FOUR;

    public WildCardDrawFourCard() {
        super();
    }

    @Override
    public String toString() {
        return "WILD DRAW FOUR";
    }

    @Override
    public void useEffect() {
        this.setColor(application.GameIO.chooseColor(this));
        Player nextPlayer = GameLoop.getGameInstance().getNextPlayer();
        Deck deck = GameLoop.getGameInstance().getDeck();
        for (int i = 0; i < 4; i++) {
            BaseCard drawnCard = deck.drawCard();
            nextPlayer.drawCard(drawnCard);
        }
    }
}
