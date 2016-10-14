import edu.princeton.cs.algs4.*;

public class Percolation {

  private boolean [][] grid;
  private int top;
  private int bot;
  private WeightedQuickUnionUF wquf;
  private int size;

  public Percolation(int n) {
    if ( n <= 0) {
      throw new IllegalArgumentException();
    }
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
    checkRange(i, j);

    grid[i-1][j-1] = true;
    int curPos = grid_coord_to_int(i, j);
    int above = i - 1;
    int below = i + 1;
    int left  = j - 1;
    int right = j + 1;


    if (i > 1) {
      if (isOpen(above, j)) { // upper neighbour 'open'
        wquf.union(curPos, grid_coord_to_int(above, j));
      }
    }
    if (i < size) {
      if (isOpen(below, j)) { // below neighbour 'open'
        wquf.union(curPos, grid_coord_to_int(below, j));
      }
    }
    if (j > 1) {
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
    checkRange(i, j);
    return grid[i-1][j-1];
  }

  public boolean isFull(int i, int j) {
    checkRange(i, j);
    int coord = grid_coord_to_int(i, j);
    return isOpen(i, j) && (wquf.connected(top, coord) || wquf.connected(bot, coord));
  }

  public boolean percolates() {
    return wquf.connected(top, bot);
  }

  private int grid_coord_to_int (int i, int j) {
    int res = ( (i - 1) * size + j );
    return res;
  }

  private void checkRange (int i, int j) {
    if (i < 1 || i > size || j < 1 || j > size) {
      throw new IndexOutOfBoundsException();
    }
  }
}
