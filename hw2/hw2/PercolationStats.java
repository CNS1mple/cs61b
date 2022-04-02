package hw2;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private static final double CONFIDENCE_95 = 1.96;
    private final int trials;
    private final double[] prob;
    // double[] std_array;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials, PercolationFactory pf)  {
        if (n <= 0 || trials <= 0) { throw new IllegalArgumentException(""); }
        this.trials = trials;
        prob = new double[trials];
        // std_array = new double[trials];
        while (trials > 0) {
            Percolation p = pf.make(n);
            while (!p.percolates()) {
                int row, col;
                do {
                    row = StdRandom.uniform(n) + 1;
                    col = StdRandom.uniform(n) + 1;
                } while (p.isOpen(row, col));
                p.open(row, col);
            }
            prob[--trials] = ((double) p.numberOfOpenSites()) / (n * n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(prob);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(prob);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLow() {
        return this.mean() - CONFIDENCE_95 * this.stddev() / Math.sqrt(this.trials);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHigh() {
        return this.mean() + CONFIDENCE_95 * this.stddev() / Math.sqrt(this.trials);
    }

    // test client (see below)
//    public static void main(String[] args) {
////        PercolationStats ps = new PercolationStats(Integer.parseInt(args[0]),
////                Integer.parseInt(args[1]));
////        System.out.println("mean                    = " + ps.mean());
////        System.out.println("stddev                  = " + ps.stddev());
////        System.out.println(
////                "95% confidence interval = [" +
//          ps.confidenceLo() + ", " + ps.confidenceHi() + "]");
////
////
//    }

}
