package onboarding;

public class Problem3 {
    private static final int MAX_NUMBER = 10000;
    private static final int MIN_NUMBER = 1;


    public static int solution(int number) {
        int answer = 0;
        try {
            validateRange(number);
        } catch (IllegalArgumentException e) {
            return 0;
        }
        return answer;
    }

    public static void validateRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER){
            throw new IllegalArgumentException("유효하지 않은 범위 내의 숫자입니다.");
        }

    }
}
