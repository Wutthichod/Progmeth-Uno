package test;

import application.GameLoop;
import logic.card.NumberCard;
import logic.card.ReverseCard;
import logic.card.SkipCard;
import Enum.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SkipCardTest {
    SkipCard c1;
    NumberCard c2;
    SkipCard c3;
    SkipCard c4;
    NumberCard c5;
    ReverseCard c6;

    @BeforeEach
    void setup() {
        c1 = new SkipCard(CardColor.RED);
        c2 = new NumberCard(CardColor.RED, 9);
        c3 = new SkipCard(CardColor.GREEN);
        c4 = new SkipCard(CardColor.RED);
        c5 = new NumberCard(CardColor.BLUE, 5);
        c6 = new ReverseCard(CardColor.RED);
    }
    @AfterEach
    void tearDown() {
        GameLoop.clearInstance();
    }

    @Test
    void testConstructor() {
        assertEquals(CardColor.RED,c1.getColor());
        assertEquals(CardEffect.SKIP, c1.getEffect());
        assertEquals(CardColor.GREEN,c3.getColor());
        assertEquals(CardEffect.SKIP, c3.getEffect());
        assertEquals(CardColor.RED,c4.getColor());
        assertEquals(CardEffect.SKIP, c4.getEffect());
    }

    @Test
    void testToString() {
        assertEquals("RED SKIP", c1.toString());
        assertEquals("GREEN SKIP", c3.toString());
        assertEquals("RED SKIP", c4.toString());
    }

    @Test
    void testisPlayable() {
        assertTrue(c2.isPlayable(c1));
        assertTrue(c3.isPlayable(c1));
        assertTrue(c4.isPlayable(c1));
        assertFalse(c5.isPlayable(c1));
    }

    @Test
    void testEffect() {
        GameLoop object = GameLoop.getGameInstance(3);
        c1.useEffect();
        assertEquals(1, object.getCurrentPlayerIndex());
        c6.useEffect();
        c1.useEffect();
        assertEquals(0,object.getCurrentPlayerIndex());
        c3.useEffect();
        assertEquals(2,object.getCurrentPlayerIndex());
        c4.useEffect();
        assertEquals(1,object.getCurrentPlayerIndex());
    }

}
