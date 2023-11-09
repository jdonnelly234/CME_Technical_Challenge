import java.util.*;
import java.io.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TechnicalChallengeTest {

    @Test
    public void testCacheLoaderWithExistingFile() {
        List<String> cache = new ArrayList<>();
        TechnicalChallenge.cacheLoader(cache);
        assertFalse(cache.isEmpty());
    }

    @Test
    public void testCacheLoaderWithNonExistingFile() {
        List<String> cache = new ArrayList<>();
        TechnicalChallenge.cacheLoader(cache);
        assertTrue(cache.isEmpty());
    }

    @Test
    public void testWriteToFile() {
        File file = new File("test-cache.txt");
        TechnicalChallenge.writeToFile("testData");
        assertTrue(file.exists());
    }

    //All things main method
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private final InputStream originalIn = System.in;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
        System.setIn(originalIn);
    }

    @Test
    public void testMainMethodWithValidInputs() {
        // Prepare input
        String input = "John\nlisten\nsilent\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Run the main method
        TechnicalChallenge.main(new String[]{});

        // Capture the program's output
        String output = outContent.toString();

        // Check the output for the expected result
        assertTrue(output.contains("John and listen are anagrams!"));
    }

    @Test
    public void testMainMethodWithInvalidInputs() {
        // Prepare input with numbers in the words
        String input = "John\nlist3n\nsilent\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Run the main method
        TechnicalChallenge.main(new String[]{});

        // Capture the program's output
        String output = outContent.toString();

        // Check the output for the message about words not containing numbers
        assertTrue(output.contains("Words cannot contain numbers"));
    }

    @Test
    public void testMainMethodWithWhitespaceInputs() {
        // Prepare input with whitespace in the words
        String input = "John\nhello world\nworld hello\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Run the main method
        TechnicalChallenge.main(new String[]{});

        // Capture the program's output
        String output = outContent.toString();

        // Check the output for the anagram result
        assertTrue(output.contains("hello world and world hello are anagrams!"));
    }

    @Test
    public void testMainMethodWithSpecialCharacters() {
        // Prepare input with special characters in the words
        String input = "John\n@bc\nbca\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Run the main method
        TechnicalChallenge.main(new String[]{});

        // Capture the program's output
        String output = outContent.toString();

        // Check the output for the expected result
        assertTrue(output.contains("@bc and bca are not anagrams."));
    }

    @Test
    public void testMainMethodWithDifferentCases() {
        // Prepare input with words of different cases
        String input = "John\nJohn\njohn\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Run the main method
        TechnicalChallenge.main(new String[]{});

        // Capture the program's output
        String output = outContent.toString();

        // Check the output for the expected result
        assertTrue(output.contains("John and John are anagrams!"));
    }
}
