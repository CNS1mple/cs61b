import edu.princeton.cs.algs4.CC;

public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> deque = new ArrayDeque<>();
        for(int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    public boolean isPalindrome(String word){
        Deque<Character> deque = wordToDeque(word);
        return isPalindrome(deque);
    }

    private boolean isPalindrome(Deque deque) {
        if(deque.size() < 2) return true;
        return deque.removeLast() == deque.removeFirst() ? isPalindrome(deque) : false;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> deque = wordToDeque(word);
        return isPalindrome(deque, cc);
    }

    private boolean isPalindrome(Deque deque, CharacterComparator cc) {
        if(deque.size() < 2) return true;
        char first = (char) deque.removeFirst();
        char last = (char) deque.removeLast();
        return (first == last || cc.equalChars(first, last)) ? isPalindrome(deque, cc) : false;
    }

}
