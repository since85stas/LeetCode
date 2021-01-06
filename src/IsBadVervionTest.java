import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsBadVervionTest {

//    @Test
//    void firstBadVersion() {
//        IsBadVervion vers = new IsBadVervion(new boolean[] {false,false,true,true,true,true});
//        assertEquals(vers.firstBadVersion(6),3);
//    }
//
//    @Test
//    void firstBadVersion2() {
//        IsBadVervion vers = new IsBadVervion(new boolean[] {true});
//        assertEquals(vers.firstBadVersion(1),1);
//    }

//    @Test
//    void firstBadVersion3() {
//        IsBadVervion vers = new IsBadVervion(new boolean[] {false,true});
//        assertEquals(vers.firstBadVersion(2),2);
//    }

    @Test
    void firstBadVersion4() {
        IsBadVervion vers = new IsBadVervion();
        vers.generateQuality(2126753390,1702766719);
        assertEquals(vers.firstBadVersion(1702766719),1702766719);
    }
}