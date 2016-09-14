import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import edu.princeton.cs.algs4.*;
public class PercolationTest {
  @Test
  public void topRootIsConnectedToFirstRow() {
    int n = 5;
    Percolation perc = new Percolation(n);
    for (int j = 1; j < n; j++) {
      assertTrue(perc.wquf.connected(0, perc.grid[0][j]));
  //    StdOut.println("[0]["+j+"]");
    }
  }
}
