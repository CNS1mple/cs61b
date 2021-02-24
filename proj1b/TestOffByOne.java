import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TestOffByOne {

    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testEqualChars(){
        assertEquals(true, offByOne.equalChars('f', 'e'));
        assertEquals(false, offByOne.equalChars('o', 'o'));
        assertEquals(true, offByOne.equalChars('l', 'k'));
        assertEquals(false, offByOne.equalChars('A', 'a'));
        assertEquals(true, offByOne.equalChars('A', 'B'));
        assertEquals(true, offByOne.equalChars('B', 'A'));
        assertEquals(false, offByOne.equalChars('B', 'a'));
        assertEquals(true, offByOne.equalChars('a', 'b'));
        assertEquals(true, offByOne.equalChars('&', '%'));
    }
}
