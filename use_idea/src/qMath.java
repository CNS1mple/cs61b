

public class qMath {
    public static void mby2(int[] A) {
       for(int i = 0; i < A.length; i++) {
           A[i] *= 2;
       }
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2,3};
        qMath.mby2(A);
        for(int x: A) {
            System.out.println(x);
        }
    }
}