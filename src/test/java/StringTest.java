import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class StringTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Initialize connection to database");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("close connection to database");
    }

    @BeforeEach   //@Before
    void beforeEach(TestInfo info) {
        System.out.println("Initialize Test Data for " + info.getDisplayName());
    }

    @AfterEach   //@After
    void afterEach(TestInfo info) {
        System.out.println("Clean up Test Data for " + info.getDisplayName());
    }

    @Test
    //@Disabled //@Ignored
    void lengthBasic() {
        //Write test code to create an instance of a class in here
        //Invoke the method - square(4) => Code Under Test
        //Checks in place to verify that the output is correct - (16) => Assertions

        int actualLength = "ABCD".length();
        int expectedLength = 4;
        assertEquals(expectedLength,actualLength);
    }

    @Test
    void lengthGreaterThanZero() {
        assertTrue("ABCD".length() > 0);
        assertTrue("ABC".length() > 0);
        assertTrue("A".length() > 0);
        assertTrue("DEF".length() > 0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"ABCD", "ABC", "A", "DEF"})
    void lengthGreaterThanZeroUsingParameterizedTest(String str) {
        assertTrue(str.length() > 0);
    }

    @ParameterizedTest(name = "{0} toUpperCase is {1}")
    @CsvSource(value = {"abcd, ABCD", "abc, ABC", "'', ''", "abcdefg, ABCDEFG"})
    void upperCaseTest(String word, String capitalizedWord) {
        assertEquals(capitalizedWord, word.toUpperCase());
    }

    @ParameterizedTest(name = "{0} length is {1}")
    @CsvSource(value = {"abcd, 4", "abc, 3", "'', 0", "abcdefg, 7"})
    void length(String word, int expectedLength) {
        assertEquals(expectedLength, word.length());
    }

    @Test
    @DisplayName("When string is null, throw an exception")
    void lengthException() {
        String str = null;
        assertThrows(NullPointerException.class, () -> { str.length(); });
    }

    @Test
    void performance() {
        assertTimeout(Duration.ofSeconds(5), () -> {
            for (int i = 0; i <= 1000000; i++) {
                int j = i;
                System.out.println(j);
            }
        });
    }

    @Test
    void toUpperCaseBasic() {
        String str = "abcd";
        String results = str.toUpperCase();
        assertNotNull(results);
        assertEquals("ABCD", results);
    }

    @Test
    @RepeatedTest(10)
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
