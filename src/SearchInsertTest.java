import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SearchInsertTest {

    SearchInsert searh = new SearchInsert();

    @Test
    public void searchInsert() {
       int[] array = new int[] {1,3,5,6};
       int targ = 5;

       assertEquals(searh.searchInsert(array,targ), 2);
    }

    @Test
    public void searchInsert2() {
        int[] array = new int[] {1,3,5,6};
        int targ = 2;

        assertEquals(searh.searchInsert(array,targ), 1);
    }

    @Test
    public void searchInsert3() {
        int[] array = new int[] {1,3,5,6};
        int targ = 7;

        assertEquals(searh.searchInsert(array,targ), 4);
    }

    @Test
    public void searchInsert4() {
        int[] array = new int[] {1,3,5,6};
        int targ = 0;

        assertEquals(searh.searchInsert(array,targ), 0);
    }

    @Test
    public void searchInsert5() {
        int[] array = new int[] {1};
        int targ = 2;

        assertEquals(searh.searchInsert(array,targ), 1);
    }
}