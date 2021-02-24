import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void testTwoDeque() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        String message = new String();
        for (int i = 0; i < 100; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if (numberBetweenZeroAndOne < 0.5) {
                sad.addLast(i);
                ads.addLast(i);
                assertEquals(message += "addLast(" + i + ")\n", sad.get(i), ads.get(i));
            } else {
                sad.addFirst(i);
                ads.addFirst(i);
                assertEquals(message += "addFirst(" + i +")\n", sad.get(0), ads.get(0));
            }
        }

        for(int i = 0; i < 100; i++) {
            assertEquals(message += "removeLast()\n", ads.removeLast(), sad.removeLast());
            assertEquals(message += "remobeFirst()\n", ads.removeFirst(), sad.removeFirst());
        }


    }

}
