package test;

import application.GameLoop;
import logic.card.*;
import Enum.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrawTwoCardTest {
    DrawTwoCard c1;
    NumberCard c2;
    DrawTwoCard c3;
    DrawTwoCard c4;
    NumberCard c5;

    @BeforeEach
    void setup() {
        c1 = new DrawTwoCard(CardColor.RED);
        c2 = new NumberCard(CardColor.RED, 9);
        c3 = new DrawTwoCard(CardColor.GREEN);
        c4 = new DrawTwoCard(CardColor.RED);
        c5 = new NumberCard(CardColor.BLUE, 5);
    }

    @AfterEach
    void tearDown() {
        GameLoop.clearInstance();
    }

    @Test
    void testConstructor() {
        assertEquals(CardColor.RED, c1.getColor());
        assertEquals(CardEffect.DRAW_TWO, c1.getEffect());

        assertEquals(CardColor.GREEN, c3.getColor());
        assertEquals(CardEffect.DRAW_TWO, c3.getEffect());

        assertEquals(CardColor.RED, c4.getColor());
        assertEquals(CardEffect.DRAW_TWO, c4.getEffect());
    }

    @Test
    void testToString() {
        assertEquals("RED DRAW_TWO", c1.toString());
        assertEquals("GREEN DRAW_TWO", c3.toString());
        assertEquals("RED DRAW_TWO", c4.toString());
    }

    @Test
    void testCanPlay() {
        assertTrue(c2.isPlayable(c1));
        assertTrue(c3.isPlayable(c1));
        assertTrue(c4.isPlayable(c1));
        assertFalse(c5.isPlayable(c1));
    }

//    @Test
//    void testPerformEffect1() {
//        // Next player hand non empty, has +2
//        GameLogic gameInstance = GameLogic.getInstance(2);
//        for (int i=0; i<4; i++)
//            gameInstance.getDeck().add(new NumberCard(CardColor.randomColor(), CardSymbol.randomSymbol()));
//        gameInstance.getPlayerHand(0).add(c2);
//        gameInstance.getPlayerHand(1).add(c3);
//        gameInstance.getPlayerHand(1).add(c5);
//
//        String message = c1.performEffect();
//
//        assertEquals(0, gameInstance.getDrawAmount());
//        assertEquals("Player 1 played GREEN DRAW TWO. 1 cards remaining.\n" +
//                "Player 0 drew 4 cards. 5 cards remaining.", message);
//    }
//
//    @Test
//    void testPerformEffect2() {
//        // Next player hand empty, skip to the player after, has +2
//        GameLogic gameInstance = GameLogic.getInstance(3);
//        for (int i=0; i<4; i++)
//            gameInstance.getDeck().add(new NumberCard(CardColor.randomColor(), CardSymbol.randomSymbol()));
//        gameInstance.getPlayerHand(0).add(c2);
//        gameInstance.getPlayerHand(2).add(c3);
//        gameInstance.getPlayerHand(2).add(c5);
//
//        String message = c1.performEffect();
//
//        assertEquals(0, gameInstance.getDrawAmount());
//        assertEquals("Player 2 played GREEN DRAW TWO. 1 cards remaining.\n" +
//                "Player 0 drew 4 cards. 5 cards remaining.", message);
//    }
//
//    @Test
//    void testPerformEffect3() {
//        // Next player hand has +4 before +2
//        GameLogic gameInstance = GameLogic.getInstance(3);
//        for (int i=0; i<6; i++)
//            gameInstance.getDeck().add(new NumberCard(CardColor.randomColor(), CardSymbol.randomSymbol()));
//        gameInstance.getPlayerHand(0).add(c2);
//        gameInstance.getPlayerHand(2).add(c6);
//        gameInstance.getPlayerHand(2).add(c3);
//
//        String message = c1.performEffect();
//
//        assertEquals(0, gameInstance.getDrawAmount());
//        assertEquals("Player 2 played DRAW FOUR. 1 cards remaining.\n" +
//                "Set color to GREEN\n" +
//                "Player 0 drew 6 cards. 7 cards remaining.", message);
//    }
//
//    @Test
//    void testPerformEffect4() {
//        // Next player hand doesn't have +2
//        GameLogic gameInstance = GameLogic.getInstance(2);
//        for (int i=0; i<2; i++)
//            gameInstance.getDeck().add(new NumberCard(CardColor.randomColor(), CardSymbol.randomSymbol()));
//        gameInstance.getPlayerHand(1).add(c2);
//
//        String message = c1.performEffect();
//
//        assertEquals(0, gameInstance.getDrawAmount());
//        assertEquals("Player 1 drew 2 cards. 3 cards remaining.", message);
//    }
}
