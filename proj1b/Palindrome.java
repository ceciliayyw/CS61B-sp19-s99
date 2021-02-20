import java.lang.*;

public class Palindrome {

    public Deque<Character> wordToDeque(String word) {

        Deque<Character> a = new LinkedListDeque<>(); //Deque is a super class (interface)

        // Google charAt()
        for (int i = 0; i < word.length(); i++) {
            char b = word.charAt(i);
            a.addLast(b);
        }
        return a;
    }


    /* recursive */
    public boolean isPalindrome(String word) {
        if (word.isEmpty() || word.length() == 1) {
            return true;
        } else {
            return isPalindromeHelper(word, 0, word.length() - 1);
        }
    }


    public boolean isPalindromeHelper(String word, int cur, int rearCur) {
        char curChar = word.charAt(cur);
        char rearCurChar = word.charAt(rearCur);

        if (word.isEmpty() || word.length() == 1 || cur >= rearCur) {
            return true;
        } else if (curChar!=rearCurChar) {
            return false;
        } else {
            return isPalindromeHelper(word, cur + 1, rearCur - 1);
        }
    }
    /** Overloading */
    /* why it can use CharacterComparator without implements? */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.isEmpty() || word.length() == 1) {
            return true;
        } else {
            return isPalindromeHelper(word, 0, word.length() - 1, new OffByOne());
        }
    }

    public boolean isPalindromeHelper (String word, int cur, int rearCur, CharacterComparator cc){
        char curChar = word.charAt(cur);
        char rearCurChar = word.charAt(rearCur);

        if ( cur >= rearCur) {
            System.out.println(word.length());
            return true;
        } else if (!cc.equalChars(curChar, rearCurChar)) {
            return false;
        } else {
            return isPalindromeHelper(word, cur + 1, rearCur - 1, cc);
        }
    }
}