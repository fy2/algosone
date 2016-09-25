import edu.princeton.cs.algs4.*;
// edu.princeton.cs.algs4.WeightedQuickUnionUF

public class Percolation {

  public boolean [][] grid;
  private int top;
  private int bot;
  public WeightedQuickUnionUF wquf;

  public Percolation(int n) {
    grid = new boolean[n][n];
    wquf = new WeightedQuickUnionUF(1 + n * n + 1);
    top = 0;
    bot = n * n +1;


    int pos = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          grid[i][j] = true;
        }
    }
    for (int i = 1; i <= n; i++) {
      wquf.union(i, top);
      wquf.union( (n * n + 1 ) - i, bot);
    }
  }

  public void open(int i, int j) {
    return;
  }

  public boolean isOpen(int i, int j) {
    return true;
  }

  public boolean isFull(int i, int j) {
    return true;
  }

  public boolean percolates() {
    return true;
//    return this.wquf.connected(this.top_root, this.bottom_root);
  }
}
