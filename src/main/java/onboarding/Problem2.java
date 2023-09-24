package onboarding;

import java.util.Stack;

public class Problem2 {
    private static final int MAX_LENGTH = 1000;
    private static final int MIN_LENGTH = 1;
    private static final char FIRST_LETTER = 'a';
    private static final char LAST_LETTER = 'z';

    private static Stack<Character> charStack;

    public static String solution(String cryptogram) {
        String answer = "answer";
        try {
            validate(cryptogram);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return answer;
        }

        return answer;
    }

    public static void deleteContinuousLetters(String cryptogram) {
        char[] letters = convertToArray(cryptogram);
        for (char letter : letters) {
            deleteContinuousLetter(letter);
        }
    }

    public static void deleteContinuousLetter(char letter) {
        if (checkContinuousInStack(letter)) {
            charStack.pop();
            return;
        }
        charStack.push(letter);
    }

    public static boolean checkContinuousInStack(char letter) {
        return (!charStack.isEmpty() && charStack.peek() == letter);
    }

    public static char[] convertToArray(String cryptogram) {
        return cryptogram.toCharArray();
    }

    public static void validate(String cryptogram) {
        validateLength(cryptogram);
        validateIsLower(cryptogram);
    }
    public static void validateLength(String cryptogram) {
        if (cryptogram.length() < MIN_LENGTH || cryptogram.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("허용되지 않은 길이의 문자열입니다.");
        }
    }
    public static void validateIsLower(String cryptogram) {
        for (int i = 0; i < cryptogram.length(); i++) {
            char letter = cryptogram.charAt(i);
            checkIsLower(letter);
        }
    }

    public static void checkIsLower(char letter) {
        if (letter < FIRST_LETTER || letter > LAST_LETTER) {
            throw new IllegalArgumentException("소문자가 아닌 다른 값이 포함되어 있습니다.");
        }
    }
}
