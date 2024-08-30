package logic.game;

import logic.card.*;

import static logic.game.CardColor.*;

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
                cards.add(new NumberCard(color, i)); // Add 19 number cards for each colors
                if(i != 0){
                    cards.add(new NumberCard(color, i)); //Add 2 numbers card if number is not 0
                }
            }
            for (int i = 0; i < 2; i++) { //Add 2 effects cards for each color
                cards.add(new SkipCard(color));
                cards.add(new ReverseCard(color));
                cards.add(new DrawTwoCard(color));
            }
        }
        for (int i = 0; i < 4; i++) { //Add 4 wild card and 4 wild card plus 4
            cards.add(new WildCard());
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
        return cards.removeFirst(); // Draw the top card
    }

    public BaseCard drawFirstCard(){
        while(!(cards.getFirst() instanceof NumberCard)){
            shuffle();
        }
        return cards.removeFirst();
    }

    // Other methods as needed
}
