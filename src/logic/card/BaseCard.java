package logic.card;

import Enum.CardColor;

public abstract class BaseCard {
    private CardColor color;

    public BaseCard() {
        this.color = CardColor.NO_COLOR;
    }

    public BaseCard(CardColor color) {
        this.color = color;
    }

    public abstract void play();

    public abstract boolean isPlayable(BaseCard currentCard);

    public abstract String toString();

    public CardColor getColor() {
        return color;
    }

    public void setColor(CardColor color) {
        this.color = color;
    }
}

