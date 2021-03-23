import jdk.jfr.Unsigned;

public class testLeftShift {
    int x = 3 << 100;

    public static void main(String[] args) {
        testLeftShift t = new testLeftShift();
        System.out.println(t.x);
    }

}
