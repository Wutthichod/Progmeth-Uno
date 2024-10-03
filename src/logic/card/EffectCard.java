package logic.card;

import application.GameIO;
import Enum.CardColor;
import Enum.CardEffect;

public abstract class EffectCard extends BaseCard{

    private final CardEffect effect;

    public EffectCard(CardColor color, CardEffect cardEffect) {
        super(color);
        this.effect = cardEffect;
    }

    public abstract void useEffect();

    @Override
    public void play() {
        GameIO.printCard(this);
        useEffect();
    }

    @Override
    public boolean isPlayable(BaseCard currentCard) {
        if (currentCard instanceof EffectCard) {
            return this.getEffect() == ((EffectCard) currentCard).getEffect() || currentCard instanceof WildCardDrawFourCard;
        }
        return this.getColor() == currentCard.getColor();
    }

    @Override
    public String toString() {
        return this.getColor() + " " + this.getEffect();
    }

    public CardEffect getEffect() {
        return this.effect;
    }
}