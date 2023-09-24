package onboarding;

import java.util.List;

class Problem1 {

    private static final int DRAW = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int EXCEPTIONS_OCCURED = -1;
    private static int pobiScore;
    private static int crongScore;
    private static Pages pobiPages;
    private static Pages crongPages;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        try {
            pobiPages = Pages.of(pobi);
            crongPages = Pages.of(crong);
        } catch (IllegalArgumentException e) {
            return EXCEPTIONS_OCCURED;
        }
        return answer;
    }
    static class Pages {
        private static final int SIZE_OF_PAGE = 2;
        private static final int FIRST_PAGE = 1;
        private static final int LAST_PAGE = 400;
        private final List<Integer> pages;
        public Pages(List<Integer> pages) {
            this.pages = pages;
        }
        private static void validate(List<Integer> pages) {
            validatePageLength(pages);
            validateConsecutivePages(pages);
            validateFirstOrLastPage(pages);
        }
        private static void validatePageLength(List<Integer> pages) {
            if (pages.size() != SIZE_OF_PAGE){
                throw new IllegalArgumentException();
            }
        }

        private static void validateConsecutivePages(List<Integer> pages) {
            if (pages.get(0) % 2 == 0 || pages.get(1)-pages.get(0) != 1){
                throw new IllegalArgumentException();
            }
        }

        private static void validateFirstOrLastPage(List<Integer> pages) {
            if (pages.get(0) == FIRST_PAGE || pages.get(1) == LAST_PAGE){
                throw new IllegalArgumentException();
            }
        }

        public static Pages of(List<Integer> pages) {
            validate(pages);
            return new Pages(pages);
        }

        public static int makeFinalScore(Pages pages) {
            return Math.max(makeScoreByAddition(pages.pages), makeScoreByMultiplication(pages.pages));
        }

        public static int makeScoreByAddition(List<Integer> pages) {
            return Math.max(calculateScoreByAddition(pages.get(0)), calculateScoreByAddition(pages.get(1)));
        }
        public static int makeScoreByMultiplication(List<Integer> pages) {
            return Math.max(calculateScoreByMultiplication(pages.get(0)), calculateScoreByMultiplication(pages.get(1)));
        }

        public static int calculateScoreByAddition(int page) {

            int total = 0;
            while (page != 0) {
                total += (page % 10);
                page /= 10;
            }
            return total;
        }

        public static int calculateScoreByMultiplication(int page) {
            int total = 1;
            while (page != 0) {
                total *= (page * 10);
                page /= 10;
            }
            return total;
        }

    }
}