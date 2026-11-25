package counter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Step 2: WordProcessor Implementation Tests")
public class Step2WordProcessorTest {

    private WordProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new WordProcessor();
    }

    @Test
    @DisplayName("WordProcessor implements the Counter interface")
    void testImplementsCounter() {
        assertTrue(Counter.class.isAssignableFrom(WordProcessor.class),
                "WordProcessor must implement the Counter interface ('public class WordProcessor implements Counter')");
    }

    @Test
    @DisplayName("WordProcessor can be assigned to a Counter reference (Polymorphism)")
    void testPolymorphicAssignment() {
        Counter counter = new WordProcessor();
        assertNotNull(counter, "A WordProcessor instance must be assignable to a Counter reference variable");
    }

    @Test
    @DisplayName("countWords correctly counts words split by spaces")
    void testCountWords() {
        assertEquals(4, processor.countWords("The British College Kathmandu"),
                "Should return 4 words for 'The British College Kathmandu'");
        assertEquals(1, processor.countWords("Java"),
                "Should return 1 word for 'Java'");
        assertEquals(5, processor.countWords("Software Systems Development Level 5"),
                "Should return 5 words for 'Software Systems Development Level 5'");
    }

    @Test
    @DisplayName("countLetters counts alphabetic letters only, ignoring spaces, numbers, and symbols")
    void testCountLetters() {
        // "Hello World" -> H, e, l, l, o, W, o, r, l, d = 10 letters
        assertEquals(10, processor.countLetters("Hello World"),
                "Should return 10 letters for 'Hello World' (excluding space)");

        // "Year 2026! SSD..." -> Y, e, a, r, S, S, D = 7 letters (digits and punctuation ignored)
        assertEquals(7, processor.countLetters("Year 2026! SSD..."),
                "Should return 7 letters for 'Year 2026! SSD...' (digits and punctuation must be ignored using Character.isLetter)");

        // "12345!@#$%" -> 0 letters
        assertEquals(0, processor.countLetters("12345!@#$%"),
                "Should return 0 letters for purely numeric and symbolic strings");
    }

    @Test
    @DisplayName("getLength returns the total character count including spaces")
    void testGetLength() {
        assertEquals(11, processor.getLength("Hello World"),
                "Length of 'Hello World' must be 11 (including space)");
        assertEquals(0, processor.getLength(""),
                "Length of empty string must be 0");
        assertEquals(15, processor.getLength("Interfaces rule"),
                "Length of 'Interfaces rule' must be 15");
    }
}
