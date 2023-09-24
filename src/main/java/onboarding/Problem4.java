package onboarding;

public class Problem4 {
    private static int MAX_STRING = 1000;

    public static String solution(String word) {
        String answer = "";
        try {
            validateRange(word);
        } catch (IllegalArgumentException e) {
            return "";
        }
        return answer;
    }

    public static void validateRange(String word) {
        if (word.isEmpty() || word.length() > MAX_STRING) {
            throw new IllegalArgumentException("허용되지 않은 길이의 문자열입니다.");
        }
    }
}
