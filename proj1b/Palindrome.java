public class Palindrome {

    public Deque<Character> wordToDeque(String word) {

        Deque<Character> a = new LinkedListDeque<>(); //Deque is a super class (interface)

        // Google charAt()
        for (int i = 0; i < word.length(); i++) {
            char b =  word.charAt(i);
            a.addLast(b);
        }
        return a;
    }
    
}
