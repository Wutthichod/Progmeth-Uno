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
    public boolean isPlayable(BaseCard prevCard) {
        if (prevCard instanceof NumberCard) {
            return this.getNumber() == ((NumberCard) prevCard).getNumber() || this.getColor() == prevCard.getColor();
        }
        return this.getColor() == prevCard.getColor();
    }

    @Override
    public String toString() {
        return this.getColor() + " " + this.getNumber();
    }

    public int getNumber() {
        return number;
    }
}