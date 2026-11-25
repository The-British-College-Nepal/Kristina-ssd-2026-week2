package counter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Step 1: Counter Interface Contract Tests")
public class Step1CounterTest {

    @Test
    @DisplayName("Counter is declared as an interface")
    void testCounterIsInterface() {
        assertTrue(Counter.class.isInterface(),
                "Counter must be declared as an 'interface', not a class (e.g. 'public interface Counter { ... }')");
    }

    @Test
    @DisplayName("Counter declares countWords(String) returning int")
    void testCountWordsDeclaration() throws NoSuchMethodException {
        Method method = Counter.class.getMethod("countWords", String.class);
        assertEquals(int.class, method.getReturnType(),
                "countWords(String) must return an int");
        assertTrue(Modifier.isPublic(method.getModifiers()),
                "countWords(String) must be public");
    }

    @Test
    @DisplayName("Counter declares countLetters(String) returning int")
    void testCountLettersDeclaration() throws NoSuchMethodException {
        Method method = Counter.class.getMethod("countLetters", String.class);
        assertEquals(int.class, method.getReturnType(),
                "countLetters(String) must return an int");
        assertTrue(Modifier.isPublic(method.getModifiers()),
                "countLetters(String) must be public");
    }

    @Test
    @DisplayName("Counter declares getLength(String) returning int")
    void testGetLengthDeclaration() throws NoSuchMethodException {
        Method method = Counter.class.getMethod("getLength", String.class);
        assertEquals(int.class, method.getReturnType(),
                "getLength(String) must return an int");
        assertTrue(Modifier.isPublic(method.getModifiers()),
                "getLength(String) must be public");
    }

    @Test
    @DisplayName("Counter can be used as a polymorphic contract type")
    void testPolymorphicContract() {
        // Verify that Counter can be implemented anonymously
        Counter dummy = new Counter() {
            @Override
            public int countWords(String s) { return 3; }
            @Override
            public int countLetters(String s) { return 10; }
            @Override
            public int getLength(String s) { return 15; }
        };

        assertEquals(3, dummy.countWords("test"));
        assertEquals(10, dummy.countLetters("test"));
        assertEquals(15, dummy.getLength("test"));
    }
}
