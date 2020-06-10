package com.kroyce;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class IntegerDivisionTests {

    @Test
    void divisionByZero(){
        IntegerDivision integerDivision = new IntegerDivision();
        assertThrows(IllegalArgumentException.class, () ->{
            integerDivision.makeDivision(1,0);
        });
    }

    @Test
    void example(){
        IntegerDivision integerDivision = new IntegerDivision();
        String actual = integerDivision.makeDivision(78945,4);
        String expected =   "_78945|4\n" +
                            " 4    |-----\n" +
                            " -    |19736\n" +
                            "_38\n" +
                            " 36\n" +
                            " --\n" +
                            " _29\n" +
                            "  28\n" +
                            "  --\n" +
                            "  _14\n" +
                            "   12\n" +
                            "   --\n" +
                            "   _25\n" +
                            "    24\n" +
                            "    --\n" +
                            "     1\n";

        assertEquals(actual,expected);
    }

    @Test
    void negativeNumbers(){
        IntegerDivision integerDivision = new IntegerDivision();
        String actual = integerDivision.makeDivision(-10, -2);
        String expected =   "_10|2\n" +
                            " 10|-\n" +
                            " --|5\n" +
                            "  0\n";

        assertEquals(actual,expected);
    }

    @Test
    void dividendIsZero(){
        IntegerDivision integerDivision = new IntegerDivision();
        String actual = integerDivision.makeDivision(0, 124);
        String expected = "0 / 124 = 0";

        assertEquals(actual,expected);

    }
     @Test
    void anotherExample(){
        IntegerDivision integerDivision = new IntegerDivision();
        String actual = integerDivision.makeDivision(10005, 2);
        String expected =   "_10005|2\n" +
                            " 10   |----\n" +
                            " --   |5002\n" +
                            "    _5\n" +
                            "     4\n" +
                            "     -\n" +
                            "     1\n";

        assertEquals(actual,expected);
     }

     @Test
    void bigNumbers(){
        IntegerDivision integerDivision = new IntegerDivision();
        String actual = integerDivision.makeDivision(87941615,454);
        String expected =   "_87941615|454\n" +
                            " 454     |------\n" +
                            " ---     |193703\n" +
                            "_4254\n" +
                            " 4086\n" +
                            " ----\n" +
                            " _1681\n" +
                            "  1362\n" +
                            "  ----\n" +
                            "  _3196\n" +
                            "   3178\n" +
                            "   ----\n" +
                            "    _1815\n" +
                            "     1362\n" +
                            "     ----\n" +
                            "      453\n";

        assertEquals(actual,expected);
     }
}
