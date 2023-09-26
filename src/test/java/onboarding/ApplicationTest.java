package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest {
    @Nested
    class Problem1Test {

        @Test
        @DisplayName("리스트 or 배열의 길이가 2인지 검증")
        void testValidateListSize(){
            List<Integer> pobi = List.of(97, 98);
            List<Integer> crong = List.of(1, 2);

            assertThat(pobi).hasSize(2);
            assertThat(crong).hasSize(2);
        }

        @Test
        @DisplayName("리스트 or 배열의 요소가 연속된 자연수인지 검증: 성공")
        void testValidateConsecutivePage1(){
            List<Integer> pobi = List.of(97, 98);
            List<Integer> crong = List.of(197,198);
            int result = 0;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);

        }

        @Test
        @DisplayName("리스트 or 배열의 요소가 연속된 자연수인지 검증: -1")
        void testValidateConsecutivePage2(){
            List<Integer> pobi = List.of(97, 98);
            List<Integer> crong = List.of(2, 4);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("첫 번째 요소가 홀수 인지 검증: -1")
        void testValidateConsecutivePage3(){
            List<Integer> pobi = List.of(3, 4);
            List<Integer> crong = List.of(46, 7);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("1을 포함하는지 검증: -1")
        void testValidateContain1(){
            List<Integer> pobi = List.of(1, 2);
            List<Integer> crong = List.of(46, 47);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
        @Test
        @DisplayName("400을 포함하는지 검증: -1")
        void testValidateContain400(){
            List<Integer> pobi = List.of(3,4);
            List<Integer> crong = List.of(399, 400);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void case1() {
            List<Integer> pobi = List.of(97, 98);
            List<Integer> crong = List.of(197, 198);
            int result = 0;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void case2() {
            List<Integer> pobi = List.of(131, 132);
            List<Integer> crong = List.of(211, 212);
            int result = 1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void case3() {
            List<Integer> pobi = List.of(99, 102);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
    }

    @Nested
    class Problem2Test {

        //assertThatThrownBy : Exception이 발생하는 케이스를 테스트할 때 사용합니다.

        @Test
        @DisplayName("문자열의 길이가 1이상 1000이하 인지 검증")
        void validateStringLength() {
            String cryptogram = "";
            assertThatThrownBy(() -> Problem2.validateLength(cryptogram))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("허용되지 않은 길이의 문자열입니다.");
        }

        @Test
        @DisplayName("문자열에 소문자가 포함되어 있는지 검증")
        void validateIsLower() {
            String cryptogram = "Aa";
            assertThatThrownBy(() -> Problem2.validateIsLower(cryptogram))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("소문자가 아닌 다른 값이 포함되어 있습니다.");
        }
        @Test
        void case1() {

            String cryptogram = "browoanoommnaon";
            String result = "brown";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void case2() {
            String cryptogram = "zyelleyz";
            String result = "";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }
    }

    @Nested
    class Problem3Test {

        @ParameterizedTest
        @ValueSource(ints = {-1, 0, 10001})
        @DisplayName("number가 1이상 10,000이하 자연수 인지 검증")
        void testValidateRange(int number) {
            assertThatThrownBy(() -> Problem3.validateRange(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("유효하지 않은 범위 내의 숫자입니다.");
        }

        @Test
        void case1() {
            int number = 13;
            int result = 4;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }

        @Test
        void case2() {
            int number = 33;
            int result = 14;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }
    }

    @Nested
    class Problem4Test {
        @Test
        @DisplayName("문자열 길이 검증")
        void validateRange() {
            assertThatThrownBy(() -> Problem4.validateRange(""))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("허용되지 않은 길이의 문자열입니다.");
        }

        @Test
        void case1() {
            String word = "I love you";
            String result = "R olev blf";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }
    }

    @Nested
    class Problem5Test {

        @ParameterizedTest
        @ValueSource(ints = {-1,0,1000001})
        @DisplayName("1이상 1,000,000이하 자연수인지 검증")
        void validateInputSize(int number) {
            assertThatThrownBy(() -> Problem5.validateInputSize(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("유효하지 않은 범위의 숫자입니다.");
        }

        @Test
        void case1() {

            int money = 50_237;
            List<Integer> result = List.of(1, 0, 0, 0, 0, 2, 0, 3, 7);
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }

        @Test
        void case2() {
            int money = 15_000;
            List<Integer> result = List.of(0, 1, 1, 0, 0, 0, 0, 0, 0);
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }
    }

    @Nested
    class Problem6Test {
        @Test
        void case1() {
            List<List<String>> forms = List.of(
                    List.of("jm@email.com", "제이엠"),
                    List.of("jason@email.com", "제이슨"),
                    List.of("woniee@email.com", "워니"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("nowm@email.com", "이제엠")
            );
            List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }
    }

    @Nested
    class Problem7Test {
        @Test
        void case1() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("donut", "andole"),
                    List.of("donut", "jun"),
                    List.of("donut", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
            );
            List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
            List<String> result = List.of("andole", "jun", "bedi");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }
    }
}
