package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    private static int MAX_STRING = 1000;
    private static final List<Character> UPPERCASE_LETTER = new ArrayList<Character>();
    private static final List<Character> LOWWERCASE_LETTER = new ArrayList<Character>();
    private static final int COUNTS_OF_ALPHABETS = 26;
    private static final int ASCII_CODE_OF_LAST_UPPERCASE_ALPHABET = 90;
    private static final int ASCII_CODE_OF_LAST_LOWWERCASE_ALPHABET = 122;

    public static String solution(String word) {

        try {
            validateRange(word);
        } catch (IllegalArgumentException e) {
            return "";
        }
        initLetter();

        return makeReverseWord(word);
    }

    private static String makeReverseWord(String word) {
        String reverseWord = "";
        char[] letters = word.toCharArray();
        for (char letter : letters) {
            reverseWord += makeReverseLetter(letter);
        }
        return reverseWord;
    }

    private static char makeReverseLetter(char letter) {
        if (isLowerCase(letter)) {
            return convertToUpperCase(letter);
        }
        if (isUpperCase(letter)) {
            return convertToLowwerCase(letter);
        }
        return letter;
    }

    private static char convertToUpperCase(char letter) {
        return LOWWERCASE_LETTER.get(letter - 'a');
    }

    private static char convertToLowwerCase(char letter) {
        return UPPERCASE_LETTER.get(letter - 'A');
    }

    private static boolean isUpperCase(char letter) {
        return (letter > 'A' && letter < 'Z');
    }

    private static boolean isLowerCase(char letter) {
        return (letter > 'a' && letter < 'z');
    }


    public static void validateRange(String word) {
        if (word.isEmpty() || word.length() > MAX_STRING) {
            throw new IllegalArgumentException("허용되지 않은 길이의 문자열입니다.");
        }
    }

    private static void initLetter() {
        initailizeUppercaseAlphabet();
        initailizeLowercaseAlphabet();
    }

    public static void initailizeUppercaseAlphabet() {
        for (int i = 0; i < COUNTS_OF_ALPHABETS; i++) {
            UPPERCASE_LETTER.add((char) (ASCII_CODE_OF_LAST_UPPERCASE_ALPHABET - i));
        }
    }
    public static void initailizeLowercaseAlphabet() {
        for (int i = 0; i < COUNTS_OF_ALPHABETS; i++) {
            LOWWERCASE_LETTER.add((char) (ASCII_CODE_OF_LAST_LOWWERCASE_ALPHABET - i));
        }
    }


}
