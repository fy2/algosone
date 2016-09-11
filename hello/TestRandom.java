import edu.princeton.cs.algs4.*;

public class TestRandom {
    public static void main(String[] args) {
        boolean out;
        for (int i = 0; i < 1000; i++) {
          out = StdRandom.bernoulli(0.001);
          StdOut.print(out);
        }
        StdOut.println();
    }
}
