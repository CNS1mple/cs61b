
public class ArrayDequeTest {
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        addIsEmptySizeTest();
        addRemoveTest();
    }

    public static void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");
//System.out.println("Make sure to uncomment
// the lines below (and delete this print statement).");

        ArrayDeque<String> ad1 = new ArrayDeque<>();

        boolean passed = checkEmpty(true, ad1.isEmpty());

        ad1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        passed = checkSize(1, ad1.size()) && passed;
        passed = checkEmpty(false, ad1.isEmpty()) && passed;

        ad1.addLast("middle");
        passed = checkSize(2, ad1.size()) && passed;

        ad1.addLast("back");
        passed = checkSize(3, ad1.size()) && passed;

        System.out.println("Printing out deque: ");
        ad1.printDeque();


        printTestStatus(passed);

    }

    public static void addRemoveTest() {

        System.out.println("Running add/remove test.");

//System.out.println("Make sure to uncomment
//the lines below (and delete this print statement).");

        ArrayDeque<Integer> ad2 = new ArrayDeque<>();
        // should be empty
        boolean passed = checkEmpty(true, ad2.isEmpty());

        ad2.addFirst(10);
        // should not be empty
        passed = checkEmpty(false, ad2.isEmpty()) && passed;

        ad2.removeFirst();
        // should be empty
        passed = checkEmpty(true, ad2.isEmpty()) && passed;


        for(int i = 0; i < 100; i++) {
            ad2.addLast(4);
        }
        for(int i = 0; i < 150; i++) {
            ad2.removeFirst();
        }
        for(int i = 0; i < 200; i++) {
            ad2.addFirst(1);
        }
        for(int i = 0; i < 250; i++) {
            ad2.removeFirst();
        }
        for(int i = 0; i < 300; i++) {
            ad2.addFirst(1);
        }

        ad2.removeFirst();
//        ad2.removeLast();


        ad2.printDeque();
        System.out.println(ad2.size());
        printTestStatus(passed);

    }
}
