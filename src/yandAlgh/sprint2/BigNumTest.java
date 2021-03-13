package yandAlgh.sprint2;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BigNumTest {

    @Test
    void main() {
        Integer[] mass = new Integer[] {1, 2, 5, 7};
        try {
            String res = BigNum.compare(true, mass);
            assertEquals(res, "7521");
        } catch (IOException e) {
            e.printStackTrace();
        }
//
        mass = new Integer[] {15, 56, 2};
        try {
            String res = BigNum.compare(true, mass);
            assertEquals(res, "56215");
        } catch (IOException e) {
            e.printStackTrace();
        }

        mass = new Integer[] {1, 783, 2};
        try {
            String res = BigNum.compare(true, mass);
            assertEquals(res, "78321");
        } catch (IOException e) {
            e.printStackTrace();
        }

        mass = new Integer[] {2, 4, 5, 2, 10};
        try {
            String res = BigNum.compare(true, mass);
            assertEquals(res, "542210");
        } catch (IOException e) {
            e.printStackTrace();
        }

        mass = new Integer[] {12, 122};
        try {
            String res = BigNum.compare(true, mass);
            assertEquals(res, "12212");
        } catch (IOException e) {
            e.printStackTrace();
        }

        mass = new Integer[] {122, 12};
        try {
            String res = BigNum.compare(true, mass);
            assertEquals(res, "12212");
        } catch (IOException e) {
            e.printStackTrace();
        }

        mass = new Integer[] {922, 9222};
        try {
            String res = BigNum.compare(true, mass);
            assertEquals(res, "9229222");
        } catch (IOException e) {
            e.printStackTrace();
        }

        mass = new Integer[] { 9222, 922};
        try {
            String res = BigNum.compare(true, mass);
            assertEquals(res, "9229222");
        } catch (IOException e) {
            e.printStackTrace();
        }

        mass = new Integer[] {12, 112};
        try {
            String res = BigNum.compare(true, mass);
            assertEquals(res, "12112");
        } catch (IOException e) {
            e.printStackTrace();
        }

        mass = new Integer[] {999, 10000};
        try {
            String res = BigNum.compare(true, mass);
            assertEquals(res, "99910000");
        } catch (IOException e) {
            e.printStackTrace();
        }

        mass = new Integer[] { 10, 10000 };
        try {
            String res = BigNum.compare(true, mass);
            assertEquals(res, "1010000");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}