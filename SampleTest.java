package assignment1;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.Timeout;

public class SampleTest {
 //   @Rule
 //   public Timeout globalTimeout = Timeout.seconds(2);

    @Test
    public void sampleTest() {
        int[] x = new int[]{-5,-4,-3,-2,-1,0};
        int[] original = x.clone();
        int n = x.length;

        assertEquals(2, SortTools.find(x, n,-3));
        assertArrayEquals(original, x);
    }

    @Test
    public void sampleTest1() {
        int[] x = new int[]{-5, -4, -3, -2, -1, 0};
        int[] original = x.clone();
        int n = 1;

        assertEquals(-1, SortTools.find(x, n, -3));
        assertArrayEquals(original, x);
    }
    
    @Test
    public void sampleTest2() {
        int[] x = new int[]{4};
        int[] y = new int[]{4, 13};
        int n = 1;

        assertArrayEquals(SortTools.copyAndInsert(x, n, 13), y);
    }
    
    @Test
    public void sampleTest3() {
        int[] x = new int[]{1,3,5,7};
        int[] y = new int[]{1,3,4,5};
        int n = 3;

        assertEquals(SortTools.insertInPlace(x, n, 4), 4);
        assertArrayEquals(x,y);
    }
    
    @Test
    public void sampleTest4() {
        int[] x = new int[]{1,7,3,5};
        int[] y = new int[]{1,3,7,5};
        int n = 3;
        SortTools.insertSort(x, n);
        assertArrayEquals(x,y);
    }
}
