import edu.princeton.cs.algs4.*;
// edu.princeton.cs.algs4.WeightedQuickUnionUF

public class Percolation {

  public int [][] grid;
  private int top_root;
  private int bottom_root;
  public WeightedQuickUnionUF wquf;

  public Percolation(int n) {
    grid = new int[n][n];
    wquf = new WeightedQuickUnionUF(1 + n * n + 1);
    top_root = 0;
    bottom_root = n * n +1;


    int pos = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          grid[i][j] = pos++;
        }
    }
    for (int i = 0; i < n; i ++) {
      wquf.union(i, top_root);
      wquf.union( n*n - i -1, bottom_root);
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
//    StdOut.println(this.top_root);
//    for (int i = 0; i < grid.length; i++) {
//      for (int j = 0; j < grid.length; j++) {
//        StdOut.print(grid[i][j] + " ");
//      }
//      StdOut.println();
//    }
//    StdOut.println(this.bottom_root);
    boolean connected = false;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid.length; j++) {
        connected = wquf.connected(bottom_root, grid[i][j]);
        if ( connected == false ) {
          connected =  wquf.connected(top_root, grid[i][j]);
        }
        StdOut.print(connected + " ");
      }
      StdOut.println();
    }


  }

  public static void main(String[] args) {
    Percolation perc = new Percolation(5);
    perc.dumpIt();
  }

}
