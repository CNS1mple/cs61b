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
            if (numberBetweenZeroAndOne < 0.3) {
                sad.addLast(i);
                ads.addLast(i);
                assertEquals(message += "addLast(" + i + ")\n", ads.get(ads.size() - 1), sad.get(sad.size() - 1));
            } else if(numberBetweenZeroAndOne < 0.5) {
                assertEquals(message += "removeLast()\n", ads.removeLast(), sad.removeLast());
            } else if(numberBetweenZeroAndOne < 0.7) {
                assertEquals(message += "removeFirst()\n", ads.removeFirst(), sad.removeFirst());
            } else {
                sad.addFirst(i);
                ads.addFirst(i);
                assertEquals(message += "addFirst(" + i +")\n", ads.get(ads.size() - 1), sad.get(sad.size() - 1));
            }
        }
    }

}
