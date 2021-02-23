import org.junit.Test;

import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.

    static CharacterComparator offByOne = new OffByOne();


    @Test
    public void testEqualChars() {
        //static context?
        boolean result1 = offByOne.equalChars('A', 'B');
        assertTrue(result1);

        boolean result2 = offByOne.equalChars('A', '%');
        assertFalse(result2);

        boolean result3 = offByOne.equalChars('A', 'a');
        assertFalse(result3);

        assertTrue(offByOne.equalChars('&', '%'));
        assertTrue(offByOne.equalChars('B', 'a'));
        assertTrue(offByOne.equalChars('c', 'd'));
        assertTrue(offByOne.equalChars('C', 'D'));


    }
}
