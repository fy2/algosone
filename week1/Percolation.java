import edu.princeton.cs.algs4.*;
// edu.princeton.cs.algs4.WeightedQuickUnionUF

public class Percolation {

  public boolean [][] grid;
  private int top;
  private int bot;
  public WeightedQuickUnionUF wquf;
  private int size;

  public Percolation(int n) {
    grid = new boolean[n][n];
    wquf = new WeightedQuickUnionUF(1 + n * n + 1);
    top = 0;
    bot = n * n +1;
    size = n;


    int pos = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          grid[i][j] = false;
        }
    }
    for (int i = 1; i <= n; i++) {
      wquf.union(i, top);
      wquf.union( (n * n + 1 ) - i, bot);
    }
  }

  public void open(int i, int j) {

    grid[i-1][j-1] = true;

    int curPos = grid_coord_to_int(i, j);

    int above = i - 1;
    int below = i + 1;
    int left  = j - 1;
    int right = j + 1;

    if (i > 1) { // only if we are not on the very first row
      if (isOpen(above, j)) { // upper neighbour 'open'
        wquf.union(curPos, grid_coord_to_int(above, j));
      }

    }
    if (i < size) { // only if we are not on the very last row
      if (isOpen(below, j)) { // below neighbour 'open'
        wquf.union(curPos, grid_coord_to_int(below, j));
      }
    }

    if (j > 1) { // only if we are not on the left edge of row
      if (isOpen(i, left)) {
        wquf.union(curPos, grid_coord_to_int(i, left));
      }
    }
    if (j < size) {
      if (isOpen(i, right)) {
        wquf.union(curPos, grid_coord_to_int(i, right));
      }
    }
  }

  public boolean isOpen(int i, int j) {
    return grid[i-1][j-1];
  }

  public boolean isFull(int i, int j) {
    int coord = grid_coord_to_int(i, j);
    return isOpen(i, j) && (wquf.connected(top, coord) || wquf.connected(bot, coord));
  }

  private int grid_coord_to_int (int i, int j) {
    int res = ( (i - 1) * size + j );
    return res;
  }

  public boolean percolates() {
    return wquf.connected(top, bot);
  }

}
