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
    }
}
