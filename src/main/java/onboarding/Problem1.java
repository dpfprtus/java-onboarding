package onboarding;

import java.util.List;

class Problem1 {

    private static final int DRAW = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int EXCEPTIONS_OCCURED = -1;

    private static final int SIZE_OF_PAGE = 2;
    private static final int FIRST_PAGE = 1;
    private static final int LAST_PAGE = 400;


    private static boolean validatePobiAndCrong(List<Integer> pobi, List<Integer> crong) {
        return (validateAll(pobi) && validateAll(crong));
    }
    private static boolean validateAll(List<Integer> page) {
        return (validateConsecutivePages(page) && validatePageLength(page) && validateFirstOrLastPage(page));
    }
    private static boolean validatePageLength(List<Integer> pages) {
        return (pages.size() == SIZE_OF_PAGE);
    }

    private static boolean validateConsecutivePages(List<Integer> pages) {
        return (pages.get(0) % 2 == 1 && pages.get(1)-pages.get(0) == 1);
    }

    private static boolean validateFirstOrLastPage(List<Integer> pages) {
        return (pages.get(0) != FIRST_PAGE && pages.get(1) != LAST_PAGE);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (!validatePobiAndCrong(pobi, crong)) {
            return EXCEPTIONS_OCCURED;
        }
        return answer;
    }
}