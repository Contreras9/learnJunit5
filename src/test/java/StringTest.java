import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.*;

public class StringTest {

    @BeforeEach
    void beforeEach(TestInfo info) {
        System.out.println("Initialize Test Data for " + info.getDisplayName());
    }

    @AfterEach
    void afterEach(TestInfo info) {
        System.out.println("Clean up Test Data for " + info.getDisplayName());
    }

    @Test
    void lengthBasic() {
        //Write test code to create an instance of a class in here
        //Invoke the method - square(4) => Code Under Test
        //Checks in place to verify that the output is correct - (16) => Assertions

        int actualLength = "ABCD".length();
        int expectedLength = 4;
        assertEquals(expectedLength,actualLength);
    }

    @Test
    void toUpperCaseBasic() {
        String str = "abcd";
        String results = str.toUpperCase();
        assertNotNull(results);
        assertEquals("ABCD", results);
    }

    @Test
    void containsBasic() {
//        String str = "abcdefgh";
//        boolean result = str.contains("ijk");
//        assertFalse(result, "true");
//        assertEquals(false, result);
//        assertFalse(str.contains("ijk"));
        assertFalse("abcdefg".contains("ijk"));
    }

    @Test
    void splitBasic() {
        String str = "abc def ghi";
        String[] actualResult = str.split(" ");
        String[] expectedResult = new String[] {"abc", "def", "ghi"};
        assertArrayEquals(expectedResult, actualResult);
    }
}
