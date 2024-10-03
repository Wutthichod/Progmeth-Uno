package logic.card;
import Enum.CardEffect;
import Enum.CardColor;

public abstract class BaseWildCard extends EffectCard {

    public BaseWildCard(CardEffect cardEffect) {
        super(CardColor.NO_COLOR, cardEffect);
    }

    @Override
    public void play() {
        super.play();
        System.out.println("Color Changed to " + this.getColor());
    }
}