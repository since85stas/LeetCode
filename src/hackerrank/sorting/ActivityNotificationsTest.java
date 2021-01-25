package hackerrank.sorting;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ActivityNotificationsTest {

    @Test
    void activityNotifications() {
        int[] arr = new int[] {2, 3, 4, 2, 3, 6, 8, 4, 5};
        assertEquals(2, ActivityNotificationCount.activityNotifications(arr,5));
////
//        arr = new int[] {2, 3, 4, 2, 3, 6, 8, 4, 5};
//        assertEquals(1, ActivityNotifications.activityNotifications(arr,1));

//        arr = new int[] {2, 3, 4};
//        assertEquals(0, ActivityNotifications.activityNotifications(arr,5));
//
//        String file ="loadNotif2.txt";
////
//        int[] newArr;
//        try {
//            Scanner scanner = new Scanner(new File(file));
//            int size = scanner.nextInt();
//            int d = scanner.nextInt();
//            newArr = new int[size];
//            int count = 0;
//            while (scanner.hasNext()) {
//                int val = scanner.nextInt();
//                newArr[count] = val;
//                count++;
//            }
//            assertEquals(633, ActivityNotifications.activityNotifications(newArr,d));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
    }
}