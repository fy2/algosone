import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import org.junit.Test;
import edu.princeton.cs.algs4.*;
public class PercolationTest {
  @Test
  public void topRootIsConnectedToFirstRow() {
    int n = 5;
    int top = 0;
    Percolation perc = new Percolation(n);
    for (int j = 1; j <= 5 ; j++) {
      assertTrue(perc.wquf.connected(top, j));
    }
    assertFalse(perc.wquf.connected(top, 6 ));
    assertFalse(perc.wquf.connected(top, 15));
    assertFalse(perc.wquf.connected(top, 25));
    assertFalse(perc.wquf.connected(top, 26));

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
  }
}
