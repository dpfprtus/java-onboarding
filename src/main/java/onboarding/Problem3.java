package onboarding;

public class Problem3 {
    private static final int MAX_NUMBER = 10000;
    private static final int MIN_NUMBER = 1;

    public static int solution(int number) {
        try {
            validateRange(number);
        } catch (IllegalArgumentException e) {
            return 0;
        }
        return HowMuchHave369(number);
    }

    public static int HowMuchHave369(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            count += divideOndNumber(i);
        }
        return count;
    }

    public static int divideOndNumber(int number) {
        int num = 0;
        while (number != 0) {
            num += showHave369(number % 10);
            number /= 10;
        }
        return num;
    }

    public static int showHave369(int number) {
        if (isMultipleThree(number)) {
            return 1;
        }
        return 0;
    }

    public static boolean isMultipleThree(int number) {
        return (number % 3 == 0);
    }

    public static void validateRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER){
            throw new IllegalArgumentException("유효하지 않은 범위 내의 숫자입니다.");
        }

    }
}
