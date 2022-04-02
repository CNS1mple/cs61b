public class SLList {
    public static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int x, IntNode n) {
            item = x;
            next = n;
        }
    }
    private IntNode sentinel = new IntNode(123, null);;
    private int size;

    public SLList() {
        size = 0;
    }

    public SLList(int v) {
        sentinel.next = new IntNode(v, null);
        size = 1;
    }

    public void addFirst(int v) {
        sentinel.next = new IntNode(v, null);
        size++;
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    public void addLast(int v) {
        IntNode p = sentinel;

        while(p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(v, null);
        size++;
    }

    public int size() {
        return size;
    }
}
