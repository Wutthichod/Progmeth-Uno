package logic.game;

import application.GameIO;
import application.GameLoop;
import logic.card.BaseCard;
import logic.card.NumberCard;
import logic.card.ReverseCard;
import logic.card.SkipCard;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<BaseCard> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public void drawCard(BaseCard card) {
        hand.add(card);
    }

    public void playCard(BaseCard card) {
        hand.remove(card);
        card.play();
    }

    public String getName() {
        return name;
    }

    public List<BaseCard> getHand() {
        return hand;
    }
}

