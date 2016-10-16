import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

  private Percolation perc;
  private double[] fractions;
  private int trials;
  public PercolationStats(int n, int trials) {
    int total_sites = n * n;
    this.trials = trials;
    fractions = new double[trials];

    for (int i = 0; i < trials; i++) {

      perc = new Percolation(n);

      int sites_opened = 0;
      while (!perc.percolates()) {
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
  public double mean() {
    return StdStats.mean(this.fractions);
  }
  public double stddev() {
    return StdStats.stddev(this.fractions);
  }
  public double confidenceLo() {
    return this.mean() - (1.96 * this.stddev()) / Math.sqrt(this.trials);
  }
  public double confidenceHi() {
    return this.mean() + (1.96 * this.stddev()) / Math.sqrt(this.trials);
  }

  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    int trials = Integer.parseInt(args[1]);
    if (n <= 0 || trials <= 0) {
      throw new IllegalArgumentException();
    }


    PercolationStats stat = new PercolationStats(n, trials);
    StdOut.println("mean                    = " + stat.mean());
    StdOut.println("stddev                  = " + stat.stddev());
    StdOut.print("95% confidence interval = ");
    StdOut.println(stat.confidenceLo() + ", " + stat.confidenceHi());
  }
}
