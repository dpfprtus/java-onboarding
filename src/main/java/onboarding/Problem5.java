package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        try {
            validateInputSize(money);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return answer;
    }

    private static

    public static void validateInputSize(int money) {
        if (money < 1 || money > 1000000) {
            throw new IllegalArgumentException("유효하지 않은 범위의 숫자입니다.");
        }
    }
}
