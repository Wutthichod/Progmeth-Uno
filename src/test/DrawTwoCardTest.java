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
    void testisPlayable() {
        assertTrue(c2.isPlayable(c1));
        assertTrue(c3.isPlayable(c1));
        assertTrue(c4.isPlayable(c1));
        assertFalse(c5.isPlayable(c1));
    }
    @Test
    void testPerformEffect() {
        GameLoop object = GameLoop.getGameInstance(2);
        assertEquals(0,object.getNextPlayer().getHand().size());
        c1.useEffect();
        assertEquals(2, object.getNextPlayer().getHand().size());
    }
}
