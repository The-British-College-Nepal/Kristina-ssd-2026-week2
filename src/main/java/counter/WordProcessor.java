package counter;

public class WordProcessor implements Counter {

    @Override
    public int countWords(String sentence) {
        if (sentence.isEmpty()) {
            return 0;
        }

        return sentence.split(" ").length;
    }

    @Override
    public int countLetters(String sentence) {
        int count = 0;

        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);

            if (Character.isLetter(ch)) {
                count++;
            }
        }

        return count;
    }

    @Override
    public int getLength(String sentence) {
        return sentence.length();
    }
}