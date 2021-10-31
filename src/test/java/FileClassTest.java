import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FileClassTest {
    private FileClass fileClass;

    @Before
    public void init() {
        fileClass = new FileClass();
    }

    @Test
    public void testThreeOrFive() {
        int[] array = new int[]{15, 30, 45};

        for (int number : array) {
            String actual = fileClass.parseValue(number);
            String expected = "FizzBuzz";
            assertEquals(expected, actual, "not a multiple of 3 and 5");
        }

    }

    @Test
    public void testThree() {
        int[] array = new int[]{3, 9, 6};
        for (int number : array) {
            String actual = fileClass.parseValue(number);
            String expected = "Fizz";
            assertEquals(expected, actual, "not a multiple of 3");
        }
    }

    @Test
    public void testFive() {
        int[] array = new int[]{5, 10, 25};
        for (int number : array) {
            String actual = fileClass.parseValue(number);
            String expected = "Buzz";
            assertEquals(expected, actual, "not a multiple of 5 " + String.valueOf(number));
        }
    }

    @Test
    public void testReadFile() {
        List<String> numbers = List.of("1", "10", "Ten", "5", "25", "30");
        Stream<String> stringStream = numbers.stream();
        List<String> actual = fileClass.readFile(stringStream);
        List<String> expected = List.of("1", "10", "5", "25", "30");
        assertEquals(expected, actual);
    }


}
