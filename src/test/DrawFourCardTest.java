package test;

import application.GameLoop;
import logic.card.*;
import Enum.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrawFourCardTest {
    WildCardDrawFourCard c1;
    NumberCard c2;
    DrawTwoCard c3;
    WildCardDrawFourCard c4;
    WildCardDrawFourCard c5;
    NumberCard c6;
    WildCardDrawFourCard c7;

    @BeforeEach
    void setup() {
        c1 = new WildCardDrawFourCard();
        c2 = new NumberCard(CardColor.YELLOW, 0);
        c3 = new DrawTwoCard(CardColor.GREEN);
        c4 = new WildCardDrawFourCard();
        c5 = new WildCardDrawFourCard();
        c6 = new NumberCard(CardColor.BLUE, 4);
        c7 = new WildCardDrawFourCard();
    }

    @AfterEach
    void tearDown() {
        GameLoop.clearInstance();
    }

    @Test
    void testConstructor() {
        assertEquals(CardColor.NO_COLOR,c1.getColor());
        assertEquals(CardEffect.WILD_DRAW_FOUR,c1.getEffect());
    }

    @Test
    void testToString() {
        assertEquals("WILD DRAW FOUR", c1.toString());
        c1.setColor(CardColor.YELLOW);
        assertEquals(CardColor.YELLOW, c1.getColor());
    }

//    @Test
//    void testCanPlay() {
//        GameLogic gameInstance = GameLogic.getInstance(1);
//
//        gameInstance.setTopCard(c2);
//        assertTrue(c1.canPlay());
//
//        gameInstance.setTopCard(c3);
//        assertTrue(c1.canPlay());
//
//        gameInstance.setTopCard(c4);
//        assertTrue(c1.canPlay());
//    }
//
//    @Test
//    void testPerformEffect1() {
//        // Next player hand non empty, has +4 / player 0 first card is yellow, player 1 first card is green
//        GameLogic gameInstance = GameLogic.getInstance(2);
//        for (int i=0; i<8; i++)
//            gameInstance.getDeck().add(new NumberCard(CardColor.randomColor(), CardSymbol.randomSymbol()));
//        gameInstance.getPlayerHand(0).add(c2);
//        gameInstance.getPlayerHand(1).add(c4);
//        gameInstance.getPlayerHand(1).add(c3);
//
//        String message = c1.performEffect();
//
//        assertEquals(0, gameInstance.getDrawAmount());
//        assertEquals("Set color to YELLOW\n" +
//                "Player 1 played DRAW FOUR. 1 cards remaining.\n" +
//                "Set color to GREEN\n" +
//                "Player 0 drew 8 cards. 9 cards remaining.", message);
//    }
//
//    @Test
//    void testPerformEffect2() {
//        // Next player hand empty, skip to the player after, has +4 / player 0 first card has no color, player 1 has no cards left
//        ChangeColorCard c6 = new ChangeColorCard();
//
//        GameLogic gameInstance = GameLogic.getInstance(3);
//        for (int i=0; i<8; i++)
//            gameInstance.getDeck().add(new NumberCard(CardColor.randomColor(), CardSymbol.randomSymbol()));
//        gameInstance.getPlayerHand(0).add(c6);
//        gameInstance.getPlayerHand(0).add(c2);
//        gameInstance.getPlayerHand(2).add(c4);
//
//        String message = c1.performEffect();
//
//        assertEquals(0, gameInstance.getDrawAmount());
//        assertEquals("Set color to RED\n" +
//                "Player 2 played DRAW FOUR. 0 cards remaining.\n" +
//                "Set color to RED\n" +
//                "Player 0 drew 8 cards. 10 cards remaining.", message);
//    }
//
//    @Test
//    void testPerformEffect3() {
//        // Next player hand doesn't have +4
//        GameLogic gameInstance = GameLogic.getInstance(2);
//        for (int i=0; i<4; i++)
//            gameInstance.getDeck().add(new NumberCard(CardColor.randomColor(), CardSymbol.randomSymbol()));
//        gameInstance.getPlayerHand(0).add(c2);
//        gameInstance.getPlayerHand(1).add(c3);
//
//        String message = c1.performEffect();
//
//        assertEquals(0, gameInstance.getDrawAmount());
//        assertEquals("Set color to YELLOW\nPlayer 1 drew 4 cards. 5 cards remaining.", message);
//    }

}
