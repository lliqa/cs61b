package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE

    @Test
    public void testThreeAddThreeRemove() {
        BuggyAList<Integer> list = new BuggyAList<>();
        AListNoResizing<Integer> std = new AListNoResizing<>();

        list.addLast(4);
        list.addLast(5);
        list.addLast(6);

        std.addLast(4);
        std.addLast(5);
        std.addLast(6);

        assertEquals (std.size(), list.size());
        assertEquals(std.removeLast(), list.removeLast());
        assertEquals(std.removeLast(), list.removeLast());
        assertEquals(std.removeLast(), list.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> Lb = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                Lb.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                assertEquals(size, Lb.size());
            } else if (operationNumber == 2 && L.size() > 0) {
                // getLast
                assertEquals(L.getLast(), Lb.getLast());
            } else if (operationNumber == 3 && L.size() > 0) {
                // removeLast
                assertEquals(L.removeLast(), Lb.removeLast());
            }
        }
    }
}
