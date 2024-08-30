package logic.card;

import application.GameIO;
import logic.game.CardColor;

public class NumberCard extends BaseCard {
    private int number;

    public NumberCard(CardColor color, int number) {
        super(color);
        this.number = number;
    }

    @Override
    public void play() {
        GameIO.printCurrentCard(this);
    }

    @Override
    public boolean isPlayable(BaseCard currentCard) {
        if (currentCard instanceof NumberCard) {
            return this.getNumber() == ((NumberCard) currentCard).getNumber() || this.getColor() == currentCard.getColor();
        }
        return this.getColor() == currentCard.getColor() || currentCard instanceof BaseWildCard;
    }

    @Override
    public String toString() {
        return this.getColor() + " " + this.getNumber();
    }

    public int getNumber() {
        return number;
    }
}