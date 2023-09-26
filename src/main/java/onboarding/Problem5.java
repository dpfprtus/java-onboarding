package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final List<Integer> LIST_OF_MONERY_UNIT = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10,1);

    public static List<Integer> solution(int money) {

        try {
            validateInputSize(money);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        return calculateMoneyCount(money);
    }

    public static List<Integer> calculateMoneyCount(int money) {
        List<Integer> moneyCount = new ArrayList<>();
        for (Integer integer : LIST_OF_MONERY_UNIT) {
            moneyCount.add(divide(money, integer));
            money = restOfTheMoney(money, integer);
        }
        return moneyCount;
    }

    public static int divide(int money,int unit) {
        return (money / unit);
    }

    public static int restOfTheMoney(int money, int unit) {
        return (money % unit);
    }

    public static void validateInputSize(int money) {
        if (money < 1 || money > 1000000) {
            throw new IllegalArgumentException("유효하지 않은 범위의 숫자입니다.");
        }
    }
}
