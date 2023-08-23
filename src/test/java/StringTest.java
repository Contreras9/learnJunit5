import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringTest {

    @Test
    void test() {
        //Write test code to create an instance of a class in here
        //Invoke the method - square(4) => Code Under Test
        //Checks in place to verify that the output is correct - (16) => Assertions

        int actualLength = "ABCD".length();
        int expectedLength = 4;
        assertEquals(expectedLength,actualLength);
    }
}
