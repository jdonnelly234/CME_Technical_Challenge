import org.junit.Test;
import static org.junit.Assert.*;

public class AnagramTest {

    @Test
    public void testIsAnagramWithAnagrams() {
        assertTrue(Anagram.isAnagram("friend", "finder"));
    }

    @Test
    public void testIsAnagramWithNonAnagrams() {
        assertFalse(Anagram.isAnagram("john", "doe"));
    }

    @Test
    public void testIsAnagramWithEmptyStrings() {
        assertTrue(Anagram.isAnagram("", ""));
    }

    @Test
    public void testIsAnagramWithOneEmptyString() {
        assertFalse(Anagram.isAnagram("hello", ""));
    }

    @Test
    public void testIsAnagramWithWhitespace() {
        assertTrue(Anagram.isAnagram("listen  ", "silent"));
    }

    @Test
    public void testIsAnagramWithSpecialCharacters() {
        assertTrue(Anagram.isAnagram("a+b+c", "c+b+a"));
    }

    @Test
    public void testIsAnagramWithUppercase() {
        assertTrue(Anagram.isAnagram("TeSt", "tEst"));
    }

    @Test
    public void testIsAnagramWithDifferentLengths() {
        assertFalse(Anagram.isAnagram("abc", "abcd"));
    }

    @Test
    public void testIsAnagramWithLongStrings() {
        assertTrue(Anagram.isAnagram("pneumonoultramicroscopicsilicovolcanoconiosis", "supercalifragilisticexpialidocious"));
    }

    @Test
    public void testIsAnagramWithDifferentEncodings() {
        assertTrue(Anagram.isAnagram("Café", "café"));
    }
}


