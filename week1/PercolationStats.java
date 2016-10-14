import edu.princeton.cs.algs4.*;

public class PercolationStats {

  private Percolation perc;
  private double[] fractions;
  private int trials;
  public PercolationStats(int n, int trials) {    // perform trials independent experiments on an n-by-n grid
    int total_sites = n * n;
    this.trials = trials;
    fractions = new double[trials];

    for (int i = 0; i < trials; i++) {

      perc = new Percolation(n);

      int sites_opened =0;
      while(!perc.percolates()) {
        int randRow = StdRandom.uniform(1, n+1);
        int randCol = StdRandom.uniform(1, n+1);
        if (perc.isOpen(randRow, randCol)) {
          continue;
        }
        perc.open(randRow, randCol);
        sites_opened++;
      }
      fractions[i]  =  (double) sites_opened / total_sites;
    }
  }
  public double mean() {                         // sample mean of percolation threshold
    return StdStats.mean(this.fractions);
  }
  public double stddev() {                        // sample standard deviation of percolation threshold
    return StdStats.stddev(this.fractions);
  }
  public double confidenceLo() {                  // low  endpoint of 95% confidence interval
    return this.mean() - ( 1.96 * this.stddev() ) / Math.sqrt(this.trials);
  }
  public double confidenceHi() {                  // high endpoint of 95% confidence interval
    return this.mean() + ( 1.96 * this.stddev() ) / Math.sqrt(this.trials);
  }

  public static void main(String[] args) {    // test client (described below)
    int n = Integer.parseInt(args[0]);
    int trials = Integer.parseInt(args[1]);
    PercolationStats stat = new PercolationStats(n, trials);
    StdOut.println("mean                    = " + stat.mean());
    StdOut.println("stddev                  = " + stat.stddev());
    StdOut.println("95% confidence interval = " + stat.confidenceLo() + ", " + stat.confidenceHi());
  }
}
