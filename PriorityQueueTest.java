import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PriorityQueueTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new int[] { 1, 3, 2 }, new int[] { 1, 2, 3 } },
                { new int[] { 3, 2, 1 }, new int[] { 1, 2, 3 } },
                { new int[] { 1, 2, -1 }, new int[] { 1, 2, 3 } },
                { new int[] { 1, 1, 1 }, new int[] { 1, 1, 1 } },
                { new int[] { 1 }, new int[] { 1 } },
                { new int[] {}, new int[] {} },
        });
    }

    private final int[] actual;
    private final int[] expected;

    public PriorityQueueTest(int[] actual, int[] expected){
        this.actual = actual;
        this.expected = expected;
    }

    @Test
    public void testSort(){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < actual.length; i++) {
            queue.add(actual[i]);
        }
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], queue.poll().intValue());
        }
    }

    @Test(expected = NullPointerException.class)
    public void testnull(){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEINVAL(){
        PriorityQueue<Integer> queue = new PriorityQueue<>(-1);
    }

    @Test(expected = NullPointerException.class)
    public void testnull2(){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(null);
    }
}
