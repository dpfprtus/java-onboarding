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
        String answer = "";
        try {
            validateRange(word);
        } catch (IllegalArgumentException e) {
            return "";
        }
        initLetter();

        return answer;
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
