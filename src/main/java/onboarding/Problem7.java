package onboarding;

import java.util.*;

public class Problem7 {
    private static final int MAX_NUMBER_OF_PEOPLE_CAN_RECOMMEND = 5;
    private static Map<String, Set<String>> friendList = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        makeFriendList(friends);
        return answer;
    }

    public static void makeFriendList(List<List<String>> friends) {
        for (List<String> friend : friends) {
            addFriendList(friend.get(0),friend.get(1));
            addFriendList(friend.get(1),friend.get(0));
        }
    }

    public static boolean checkFriendListKey(String user) {
        return friendList.containsKey(user);
    }

    public static void addFriendList(String key,String value) {
        if (checkFriendListKey(key)) {
            friendList.get(key).add(value);
            return;
        }
        Set<String> eachFriend = new HashSet<>();
        eachFriend.add(value);
        friendList.put(key, eachFriend);
    }

}
