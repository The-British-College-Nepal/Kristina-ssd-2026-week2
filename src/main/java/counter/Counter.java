package counter;

/**
 * Step 1: Define the Counter interface.
 * 
 * Provides sentence counting operations according to the official specification.
 * 
 * In this step:
 * 1. Declare the method to count words:
 *    int countWords(String sentence);
 * 2. Declare the method to count letters:
 *    int countLetters(String sentence);
 * 3. Declare the method to get total length:
 *    int getLength(String sentence);
 * 
 * Note: In an interface, method declarations do not have method bodies ({}),
 * and they are implicitly public and abstract.
 */
public interface Counter {

    /**
     * Returns the number of words in the sentence.
     *
     * @param sentence the sentence from which to count the words.
     * @return the number of words in the sentence.
     */
    int countWords(String sentence);

    /**
     * Returns the number of letters in the sentence.
     *
     * @param sentence the sentence from which to count the letters.
     * @return the number of letters in the sentence.
     */
    int countLetters(String sentence);

    /**
     * Gets the total length of a sentence (including spaces).
     *
     * @param sentence the sentence for which the length is required.
     * @return the length of a sentence.
     */
    int getLength(String sentence);

}
