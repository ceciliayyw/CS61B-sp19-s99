import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    static CharacterComparator offByN = new OffByN(5);

    @Test
    public void testEqualChars() {
        //static context?
        boolean result1 = offByN.equalChars('a', 'f');
        assertTrue(result1);

        boolean result2 = offByN.equalChars('f', 'a');
        assertTrue(result2);

        boolean result3 = offByN.equalChars('a', 'a');
        assertFalse(result3);

        assertFalse(offByN.equalChars('f', 'h'));


    }
}
