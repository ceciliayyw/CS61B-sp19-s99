import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testPalindrome(){
        /** test palindrome */
        String input1 = "racecar";
        boolean actualResult1 = palindrome.isPalindrome(input1);
        assertTrue(actualResult1 );

        String input2 = "noon";
        boolean actualResult2 = palindrome.isPalindrome(input2);
        assertTrue(actualResult2 );

        String input3 = "";
        boolean actualResult3 = palindrome.isPalindrome(input2);
        assertTrue(actualResult3 );

        String input4 = "a";
        boolean actualResult4 = palindrome.isPalindrome(input2);
        assertTrue(actualResult4 );

        String input5 = "willow";
        boolean actualResult5 = palindrome.isPalindrome(input5);
        assertFalse(actualResult5 );

        /** Test OffByOne */
        assertFalse(palindrome.isPalindrome("racecar", new OffByOne()));
        assertFalse(palindrome.isPalindrome("noon", new OffByOne()));
        assertTrue(palindrome.isPalindrome("", new OffByOne()));
        assertTrue(palindrome.isPalindrome("a", new OffByOne()));
        assertFalse(palindrome.isPalindrome("willow", new OffByOne()));
        assertTrue(palindrome.isPalindrome("acb", new OffByOne()));

    }
}
