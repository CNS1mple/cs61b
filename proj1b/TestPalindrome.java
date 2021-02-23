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
    public void testIsP(){
        assertEquals(true, palindrome.isPalindrome("abcdcba"));
        assertEquals(false, palindrome.isPalindrome("abcddcbA"));
        assertEquals(true, palindrome.isPalindrome("a"));
    }

    @Test
    public void testIsPOffByOne(){
        CharacterComparator cc = new OffByOne();

        assertEquals(false, palindrome.isPalindrome("aba", cc));
        assertEquals(true, palindrome.isPalindrome("abb", cc));
        assertEquals(false, palindrome.isPalindrome("abc", cc));
        assertEquals(true, palindrome.isPalindrome("ab", cc));
        assertEquals(false, palindrome.isPalindrome("ad", cc));
        assertEquals(true, palindrome.isPalindrome("a", cc));
        assertEquals(true, palindrome.isPalindrome("flake", cc));

    }

}
