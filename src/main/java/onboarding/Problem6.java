package onboarding;

import java.nio.channels.IllegalChannelGroupException;
import java.util.*;

public class Problem6 {
    private static final int MAX_LENGTH = 20;
    private static Map<String, String> twoLettersForm = new HashMap<>();
    private static Set<String> duplicatedUserEmails = new TreeSet<>();

    public static List<String> solution(List<List<String>> forms) {

        try {
            validate(forms);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        updateDuplicatedUserEmails(forms);
        return new ArrayList<>(duplicatedUserEmails);
    }

    public static void updateDuplicatedUserEmails(List<List<String>> forms) {

        for (List<String> form : forms) {
            saveTwoLetterNameForm(form);
        }
    }

    private static void saveTwoLetterNameForm(List<String> form) {
        String email = form.get(0);
        String nickname = form.get(1);
        List<String> twoLetterName = parseTwoLetterNames(nickname);
        for (String name : twoLetterName) {
            saveTwoLetterNameForms(email,name);
        }
    }

    public static List<String> parseTwoLetterNames(String nickname) {
        List<String> twoLetterNames = new ArrayList<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            twoLetterNames.add(nickname.substring(i, i + 2));
        }
        return twoLetterNames;
    }

    public static void saveTwoLetterNameForms(String email,String twoLetterName) {
        if (checkDuplicateName(twoLetterName)){
            addDuplicatedUserEmails(email, twoLetterName);
        }
        twoLettersForm.put(twoLetterName, email);
    }

    public static void addDuplicatedUserEmails(String email, String twoLetterName) {
        duplicatedUserEmails.add(email);
        duplicatedUserEmails.add(twoLettersForm.get(twoLetterName));
    }


    private static boolean checkDuplicateName(String twoLetterName) {
        return (twoLettersForm.containsKey(twoLetterName));
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
