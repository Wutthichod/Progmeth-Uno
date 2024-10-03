package logic.card;

import application.GameIO;
import Enum.CardColor;

public class NumberCard extends BaseCard {
    private int number;

    public NumberCard(CardColor color, int cardNumber) {
        super(color);
        this.number = cardNumber;
    }

    @Override
    public void play() {
        GameIO.printCard(this);
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