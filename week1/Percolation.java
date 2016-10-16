import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

  private boolean [][] grid;
  private int top;
  private int bot;
  private WeightedQuickUnionUF wquf;
  private WeightedQuickUnionUF wqufFullness;
  private int size;

  public Percolation(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException();
    }
    grid = new boolean[n][n];
    wquf = new WeightedQuickUnionUF(1 + n * n + 1);
    wqufFullness = new WeightedQuickUnionUF(1 + n * n + 1);
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
      wqufFullness.union(i, top);
      wquf.union((n * n + 1) - i, bot);
    }
  }

  public void open(int i, int j) {
    checkRange(i, j);

    grid[i-1][j-1] = true;
    int curPos = gridCoordToInt(i, j);
    int above = i - 1;
    int below = i + 1;
    int left  = j - 1;
    int right = j + 1;


    if (i > 1) {
      if (isOpen(above, j)) { // upper neighbour 'open'
        wquf.union(curPos, gridCoordToInt(above, j));
        wqufFullness.union(curPos, gridCoordToInt(above, j));
      }
    }
    if (i < size) {
      if (isOpen(below, j)) { // below neighbour 'open'
        wquf.union(curPos, gridCoordToInt(below, j));
        wqufFullness.union(curPos, gridCoordToInt(below, j));
      }
    }
    if (j > 1) {
      if (isOpen(i, left)) {
        wquf.union(curPos, gridCoordToInt(i, left));
        wqufFullness.union(curPos, gridCoordToInt(i, left));
      }
    }
    if (j < size) {
      if (isOpen(i, right)) {
        wquf.union(curPos, gridCoordToInt(i, right));
        wqufFullness.union(curPos, gridCoordToInt(i, right));
      }
    }

  }

  public boolean isOpen(int i, int j) {
    checkRange(i, j);
    return grid[i-1][j-1];
  }

  public boolean isFull(int i, int j) {
    checkRange(i, j);
    int coord = gridCoordToInt(i, j);
    return isOpen(i, j) && wqufFullness.connected(top, coord);
  }

  public boolean percolates() {

    // corner case only one block
    if (this.size == 1) {
      if (!grid[0][0]) {
        return false;
      }
    }

    return wquf.connected(top, bot);
  }

  private int gridCoordToInt(int i, int j) {
    int res = ((i - 1) * size + j);
    return res;
  }

  private void checkRange(int i, int j) {
    if (i < 1 || i > size || j < 1 || j > size) {
      throw new IndexOutOfBoundsException();
    }
  }
}
