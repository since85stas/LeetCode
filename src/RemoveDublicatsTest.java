import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RemoveDublicatsTest {

    int[] array;
    RemoveDublicats remover = new RemoveDublicats();

    @Before
    public void init() {
        remover = new RemoveDublicats();
    }

    @Test
    public void test1() {
        array = new int[] {1,1,2};
        assertEquals(2, remover.removeDuplicates(array));
    }
}