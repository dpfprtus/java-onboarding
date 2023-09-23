package onboarding;

import java.util.List;

class Problem1 {

    private static final int DRAW = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int EXCEPTIONS_OCCURED = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        try {
            Pages pobiPages = Pages.of(pobi);
            Pages crongPages = Pages.of(crong);
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
    }
}