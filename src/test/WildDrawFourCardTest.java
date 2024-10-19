package test;

import application.GameLoop;
import logic.card.*;
import Enum.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static Enum.CardColor.RED;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WildDrawFourCardTest {
    WildCardDrawFourCard c1;
    NumberCard c2;
    DrawTwoCard c3;
    WildCardDrawFourCard c4;
    WildCardDrawFourCard c5;
    NumberCard c6;
    WildCardDrawFourCard c7;
    private final InputStream systemIn = System.in;
    private ByteArrayInputStream testIn;

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

    @Test
    void testisPlayable() {
        assertTrue(c2.isPlayable(c1));
        assertTrue(c3.isPlayable(c1));
        assertTrue(c4.isPlayable(c1));
        assertTrue(c5.isPlayable(c1));
        c1.setColor(RED);
        assertFalse(c1.isPlayable(c2));
        c1.setColor(CardColor.YELLOW);
        assertTrue(c1.isPlayable(c2));
    }

    @Test
    void testPerformEffect() {
        String input = "1";
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        GameLoop object = GameLoop.getGameInstance(2);
        assertEquals(0,object.getNextPlayer().getHand().size());
        c1.useEffect();
        assertEquals(4, object.getNextPlayer().getHand().size());
        assertEquals(RED, c1.getColor());
    }


}
