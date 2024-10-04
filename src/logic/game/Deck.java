package logic.game;

import Enum.CardColor;
import logic.card.*;

import static Enum.CardColor.*;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<BaseCard> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
        shuffle();
    }

    private void initializeDeck() {
        CardColor[] colors = {RED, BLUE, GREEN, YELLOW};

        for (CardColor color : colors) {
            for (int i = 0; i <= 9; i++) {
                cards.add(new NumberCard(color, i));
                if(i != 0){
                    cards.add(new NumberCard(color, i));
                }
            }
            for (int i = 0; i < 2; i++) {
                cards.add(new SkipCard(color));
                cards.add(new ReverseCard(color));
                cards.add(new DrawTwoCard(color));
            }
        }
        for (int i = 0; i < 4; i++) {
            cards.add(new WildCardDrawFourCard());
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public BaseCard drawCard() {
        if (cards.isEmpty()) {
            initializeDeck();
            shuffle();
        }
        BaseCard rt = cards.get(0);
        cards.remove(0);
        return rt;
    }

    public BaseCard drawFirstCard(){
        while(!(cards.get(0) instanceof NumberCard)){
            shuffle();
        }
        BaseCard rt = cards.get(0);
        cards.remove(0);
        return rt;
    }
}
