package hw2;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] grid;
    private int count;
    private final int n;
    private final WeightedQuickUnionUF uf;
    private final int top, bottom;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException("");
        this.n = n;
        grid = new boolean[n][n];
        count = 0;
        uf = new WeightedQuickUnionUF(n * n + 2);
        top = 0;
        bottom = n * n + 1;
    }

    //  1 2 3 4 5
    //  6 7 8 9 10
    //  ...
    private int getN(int row, int col) {
        return n * row + col + 1;
    }

    private boolean outOfBounds(int row, int col) {
        return row < 0 || row >= n || col < 0 || col >= n;
    }


    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (outOfBounds(row, col)) throw new IllegalArgumentException("");
        if (isOpen(row, col)) return;
        grid[row][col] = true;
        int id = getN(row, col);
        if (row == 0) uf.union(id, top);
        if (row == n - 1) uf.union(id, bottom);
        union4(row, col);
        count++;
    }

    // open but do not union
    private void union4(int row, int col) {
        int[] a1 = { 0, 1, 0, -1 };
        int[] a2 = { 1, 0, -1, 0 };
        for (int i = 0; i < a1.length; i++) {
            int newRow = row + a1[i], newCol = col + a2[i];
            if (outOfBounds(newRow, newCol)) continue;
            int id = getN(row, col), idNew = getN(newRow, newCol);
            if (isOpen(newRow, newCol)) uf.union(id, idNew);
        }

    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (outOfBounds(row, col)) throw new IllegalArgumentException("");
        return grid[row][col];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (outOfBounds(row, col)) throw new IllegalArgumentException("");
        int id = getN(row, col);
        return uf.find(id) == uf.find(top);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return count;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.find(top) == uf.find(bottom);
    }

    // test client (optional)
    public static void main(String[] args) {
        int n = 100;
        Percolation p = new Percolation(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (StdRandom.bernoulli(0.59)) {
                    p.open(i, j);
                }
            }
        }
        if (p.percolates()) {
            System.out.println("yes");
        }
        else {
            System.out.println("no");
        }
    }
}
