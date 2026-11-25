package counter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Step 3: Encapsulation & Fallback State Tests")
public class Step3FallbackTest {

    private WordProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new WordProcessor();
    }

    @Test
    @DisplayName("WordProcessor has a private 'text' attribute (Encapsulation)")
    void testTextAttributeIsPrivate() throws NoSuchFieldException {
        Field textField = WordProcessor.class.getDeclaredField("text");
        assertTrue(Modifier.isPrivate(textField.getModifiers()),
                "Attribute 'text' must be private to enforce encapsulation");
        assertEquals(String.class, textField.getType(),
                "Attribute 'text' must be of type String");
    }

    @Test
    @DisplayName("WordProcessor provides getters and setters for 'text'")
    void testGettersAndSetters() {
        processor.setText("Initial fallback text");
        assertEquals("Initial fallback text", processor.getText(),
                "getText() must return the string set by setText()");

        processor.setText("Updated text");
        assertEquals("Updated text", processor.getText(),
                "getText() must return updated string after setText()");
    }

    @Test
    @DisplayName("countWords uses fallback text when passed null")
    void testCountWordsFallbackOnNull() {
        processor.setText("Fallback sentence with five words");
        assertEquals(5, processor.countWords(null),
                "countWords(null) should evaluate the fallback text stored in 'text'");
    }

    @Test
    @DisplayName("countLetters uses fallback text when passed null")
    void testCountLettersFallbackOnNull() {
        // "Java 21" -> J, a, v, a = 4 letters
        processor.setText("Java 21");
        assertEquals(4, processor.countLetters(null),
                "countLetters(null) should evaluate letters in fallback text");
    }

    @Test
    @DisplayName("getLength uses fallback text when passed null")
    void testGetLengthFallbackOnNull() {
        processor.setText("Fallback sample");
        assertEquals(15, processor.getLength(null),
                "getLength(null) should return length of fallback text");
    }

    @Test
    @DisplayName("Explicit non-null arguments override the fallback text")
    void testNonNullOverridesFallback() {
        processor.setText("Fallback default text that should be ignored");
        
        // Pass a specific non-null string
        assertEquals(2, processor.countWords("Active Sentence"),
                "When non-null string is passed, countWords should evaluate that string, not fallback text");
        assertEquals(14, processor.countLetters("Active Sentence"),
                "When non-null string is passed, countLetters should evaluate that string, not fallback text");
        assertEquals(15, processor.getLength("Active Sentence"),
                "When non-null string is passed, getLength should evaluate that string, not fallback text");
    }
}
