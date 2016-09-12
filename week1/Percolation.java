import edu.princeton.cs.algs4.*;
// edu.princeton.cs.algs4.WeightedQuickUnionUF

public class Percolation {

  private boolean [][] grid;
  private WeightedQuickUnionUF wquf;

  public Percolation(int n) {
    grid = new boolean[n][n];
    wquf = new WeightedQuickUnionUF(1 + n * n + 1);

    int top_root = 0;
    int bot_root = n+1;

    for (int i = 0; i < n; i++) {
      wquf.union(top_root, i);
//      grid[0][i] = true;
    }
    for (int i = 0; i < n; i++) {
//      grid[n-1][i] = true;
      wquf.union(bot_root, i);
    }

/*    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        grid[i][j] = false;
      }
    }
*/
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
  }

  public void dumpIt() {
    StdOut.println(true);
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid.length; j++) {
        // StdOut.print(i + "," + j + " =" + grid[i][j]);
        StdOut.print(grid[i][j] + " ");
      }
      StdOut.println();
    }
    StdOut.println(true);
  }

  public static void main(String[] args) {
    Percolation perc = new Percolation(5);
    perc.dumpIt();
  }

}
