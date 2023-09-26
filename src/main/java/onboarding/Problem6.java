package onboarding;

import java.nio.channels.IllegalChannelGroupException;
import java.util.List;

public class Problem6 {
    private static final int MAX_LENGTH = 20;
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        try {
            validate(forms);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return answer;
    }

    public static void validate(List<List<String>> form) {
        if (!validateFormSize(form)) {
            throw new IllegalArgumentException("입력값이 너무 많거나 적습니다.");
        }
        for (List<String> input: form){
            if (!validateEmail(input.get(0)) || !validateNickname(input.get(1))) {
                throw new IllegalArgumentException("입력값이 잘못되었습니다.");
            }
        }

    }

    public static boolean validateFormSize(List<List<String>> form) {
        return (!form.isEmpty() && form.size() <= 10000);
    }

    public static boolean validateEmail(String email) {
        return (emailRange(email) && isCorrectEmail(email));
    }

    public static boolean validateNickname(String nickname) {
        return (nicknameRange(nickname) && isKoreanNickname(nickname));
    }

    public static boolean isCorrectEmail(String email) {
        return (email.endsWith("@email.com"));
    }

    public static boolean nicknameRange(String nickname) {
        return (!nickname.isEmpty() && nickname.length() < MAX_LENGTH);
    }

    public static boolean isKoreanNickname(String nickname) {
        final String regex = "^[가-힣]*$";
        return (nickname.matches(regex));
    }

    public static boolean emailRange(String email) {
        return (!email.isEmpty() && email.length() < MAX_LENGTH);
    }

}
