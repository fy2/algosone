import static org.junit.Assert.*;
import org.junit.Test;
import edu.princeton.cs.algs4.*;
public class PercolationTest {
  @Test
  public void topRootIsConnectedToFirstRow() {
    int n = 5;
    int top = 0;
    int bot = n * n  + 1; // 26
    Percolation perc = new Percolation(n);
    for (int j = 1; j <= 5 ; j++) {
      assertTrue(perc.wquf.connected(top, j));
    }
    assertFalse(perc.wquf.connected(top, 6 ));
    assertFalse(perc.wquf.connected(top, 15));
    assertFalse(perc.wquf.connected(top, 25));
    assertFalse(perc.wquf.connected(top, bot));

  }

  @Test
  public void bottomRootIsConnectedToLastRow() {
    int n = 5;
    int top = 0;
    int bot = n * n  + 1; // 26
    Percolation perc = new Percolation(n);
    for (int j = 25; j >= 21; j--) {
      assertTrue(perc.wquf.connected(bot, j));
    }
    assertFalse(perc.wquf.connected(bot, 20));
    assertFalse(perc.wquf.connected(bot, 15));
    assertFalse(perc.wquf.connected(bot, 1));
    assertFalse(perc.wquf.connected(bot, top));
  }

  @Test
  public void testOpen() {
    Percolation perc = new Percolation(5);
    assertFalse(perc.isOpen(2, 1));
    perc.open(2,1);
    assertTrue(perc.isOpen(2, 1));
  }

  @Test
  public void testIsFull() {

/*
       1       2      3     4     5
    +-------+------+-----+-----+------+
    |   O   |      |     |     |      | 1
    |       |      |     |     |      |
    +---------------------------------+
    |   O   |      |     |     |      | 2
    |       |      |     |     |      |
    +---------------------------------+
    |       |      |     |     |      | 3
    |       |      |     | O   |      |
    +---------------------------------+
    |       |      |     |  O  |      | 4
    |       |      |     |     |  O   |
    +---------------------------------+
    |       |      |     |     |      | 5
    |       |      |     |     |   O  |
    +-------+------+-----+-----+------+
*/

    Percolation perc = new Percolation(5);
    assertFalse(perc.isFull(2, 1));
    perc.open(1,1);
    assertFalse(perc.isFull(2, 1));
    perc.open(2,1);
    assertTrue(perc.isFull(1, 1));
    assertTrue(perc.isFull(2, 1));

/* These tests are wrong, because filling can only happen top to bottom apparently..
    assertFalse(perc.isFull(3, 4));
    assertFalse(perc.isFull(4, 4));
    assertFalse(perc.isFull(4, 5));
    assertFalse(perc.isFull(5, 5));
    perc.open(3,4);
    perc.open(4,4);
    perc.open(4,5);
    assertFalse(perc.isFull(3, 4));
    assertFalse(perc.isFull(4, 4));
    assertFalse(perc.isFull(4, 5));
    assertFalse(perc.isFull(5, 5));

    perc.open(5,5);
    assertTrue(perc.isFull(3, 4));
    assertTrue(perc.isFull(4, 4));
    assertTrue(perc.isFull(4, 5));
    assertTrue(perc.isFull(5, 5));

    assertFalse(perc.percolates());
    perc.open(2,4);
    assertFalse(perc.percolates());
    perc.open(1,4);
    assertTrue(perc.percolates());
 */
  }

  @Test(expected=IllegalArgumentException.class)
  public void testIllegalArgumentException() {
    Percolation perc = new Percolation(-1);
  }

  @Test(expected=IndexOutOfBoundsException.class)
  public void testIndexOutOfBoundsException() {
    Percolation perc = new Percolation(5);
    perc.open(0,1);
  }

  @Test(expected=IndexOutOfBoundsException.class)
  public void testIndexOutOfBoundsException2() {
    Percolation perc = new Percolation(5);
    perc.open(1,6);
  }

  @Test(expected=IndexOutOfBoundsException.class)
  public void testIndexOutOfBoundsException3() {
    Percolation perc = new Percolation(5);
    perc.isOpen(1,6);
  }

  @Test(expected=IndexOutOfBoundsException.class)
  public void testIndexOutOfBoundsException4() {
    Percolation perc = new Percolation(5);
    perc.isFull(0,1);
  }

}
