import org.junit.jupiter.api.*;

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
    void lengthBasic() {
        //Write test code to create an instance of a class in here
        //Invoke the method - square(4) => Code Under Test
        //Checks in place to verify that the output is correct - (16) => Assertions

        int actualLength = "ABCD".length();
        int expectedLength = 4;
        assertEquals(expectedLength,actualLength);
    }

    @Test
    void lengthException() {
        String str = null;
        assertThrows(NullPointerException.class, () -> { str.length(); });
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
