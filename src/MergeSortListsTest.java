import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeSortListsTest {

    int[] arr1;
    int[] arr2;
    ListNode list1;
    ListNode list2;

    @Before
    public void init() {
        arr1 = new int[]{4,3,1};
        arr2 = new int[]{4,2,1};
        list1 = new Creator(arr1).create();
        list2 = new Creator(arr2).create();
    }

    @Test
    public void test1() {
        Solution solution = new Solution();
        assertEquals(solution.mergeTwoLists(list1, list2),new Creator(new int[] {4,3,2,1}).create());
    }
}