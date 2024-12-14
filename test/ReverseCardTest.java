package test;

import Enum.*;
import application.*;
import logic.card.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReverseCardTest {
    ReverseCard c1;
    NumberCard c2;
    ReverseCard c3;
    ReverseCard c4;
    NumberCard c5;

    @BeforeEach
    void setup() {
        c1 = new ReverseCard(CardColor.RED);
        c2 = new NumberCard(CardColor.RED, 9);
        c3 = new ReverseCard(CardColor.GREEN);
        c4 = new ReverseCard(CardColor.RED);
        c5 = new NumberCard(CardColor.BLUE, 5);
    }
    @AfterEach
    void tearDown() {
        GameLoop.clearInstance();
    }
    @Test
    void testConstructor() {
        assertEquals(CardColor.RED,c1.getColor());
        assertEquals(CardEffect.REVERSE, c1.getEffect());
        assertEquals(CardColor.GREEN,c3.getColor());
        assertEquals(CardEffect.REVERSE, c3.getEffect());
        assertEquals(CardColor.RED,c4.getColor());
        assertEquals(CardEffect.REVERSE, c4.getEffect());
    }

    @Test
    void testToString() {
        assertEquals("RED REVERSE", c1.toString());
        assertEquals("GREEN REVERSE", c3.toString());
        assertEquals("RED REVERSE", c4.toString());
    }

    @Test
    void testIsPlayable() {
        assertTrue(c2.isPlayable(c1));
        assertTrue(c3.isPlayable(c1));
        assertTrue(c4.isPlayable(c1));
        assertFalse(c5.isPlayable(c1));
    }

    @Test
    void testUseEffect() {
        GameLoop object = GameLoop.getGameInstance(1);
        c1.useEffect();
        assertEquals(-1, object.getDirection());
        c3.useEffect();
        assertEquals(1, object.getDirection());
    }

}
