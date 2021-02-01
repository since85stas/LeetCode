package yandAlgh.sprint1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FunctionValueTest {

    @Test
    void functionValue() {
        FunctionValue value = new FunctionValue();

        assertEquals(-183,FunctionValue.functionValue(-8, -5, -2, 7));
    }
}