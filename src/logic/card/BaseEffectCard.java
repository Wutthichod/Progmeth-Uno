package logic.card;

import application.GameIO;
import logic.game.CardColor;
import logic.game.CardEffect;

public abstract class BaseEffectCard extends BaseCard{

    private CardEffect effect;

    public BaseEffectCard() {
        super();
    }

    public BaseEffectCard(CardColor color) {
        super(color);
    }

    public abstract void useEffect();

    @Override
    public void play() {
        GameIO.printCurrentCard(this);
        useEffect();
    }

    @Override
    public boolean isPlayable(BaseCard currentCard) {
        if (currentCard instanceof BaseEffectCard) {
            return this.getEffect() == ((BaseEffectCard) currentCard).getEffect();
        }
        return  this.getColor() == currentCard.getColor();

    }

    public CardEffect getEffect() {
        return this.effect;
    }
}