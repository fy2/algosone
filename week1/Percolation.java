import edu.princeton.cs.algs4.*;

public class Percolation {

  private int [][] grid;
  public Percolation(int n) {
    grid = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        grid[i][j] = -1;
      }
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
  }

  public void dumpIt() {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid.length; j++) {
        // StdOut.print(i + "," + j + " =" + grid[i][j]);
        StdOut.print(grid[i][j] + " ");
      }
      StdOut.println();
    }
  }



  public static void main(String[] args) {
    Percolation perc = new Percolation(10);
    perc.dumpIt();
  }

}
