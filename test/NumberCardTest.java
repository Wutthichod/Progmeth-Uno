import Enum.*;
import application.GameLoop;
import logic.card.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumberCardTest {

    NumberCard c1;
    NumberCard c2;
    NumberCard c3;
    NumberCard c4;
    NumberCard c5;

    @BeforeEach
    void setup() {
        c1 = new NumberCard(CardColor.RED, 1);
        c2 = new NumberCard(CardColor.RED, 9);
        c3 = new NumberCard(CardColor.GREEN, 1);
        c4 = new NumberCard(CardColor.RED, 1);
        c5 = new NumberCard(CardColor.BLUE, 5);
    }
    @AfterEach
    void tearDown() {
        GameLoop.clearInstance();
    }

    @Test
    void testConstructor() {
        assertEquals(CardColor.RED, c1.getColor());
        assertEquals(1, c1.getNumber());

        assertEquals(CardColor.RED, c2.getColor());
        assertEquals(9, c2.getNumber());

        assertEquals(CardColor.GREEN, c3.getColor());
        assertEquals(1, c3.getNumber());

        assertEquals(CardColor.RED, c4.getColor());
        assertEquals(1, c4.getNumber());

        assertEquals(CardColor.BLUE, c5.getColor());
        assertEquals(5, c5.getNumber());
    }

    @Test
    void testToString() {
        assertEquals("RED 1", c1.toString());
        assertEquals("RED 9", c2.toString());
        assertEquals("GREEN 1", c3.toString());
        assertEquals("RED 1", c4.toString());
        assertEquals("BLUE 5", c5.toString());
    }

    @Test
    void testIsPlayable() {
        assertTrue(c2.isPlayable(c1));// color
        assertTrue(c3.isPlayable(c1));// symbol
        assertTrue(c4.isPlayable(c1)); // both
        assertFalse(c5.isPlayable(c1));// No match
    }
}
