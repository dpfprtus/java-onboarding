package onboarding;

import java.util.*;

public class Problem7 {
    private static final int MAX_NUMBER_OF_PEOPLE_CAN_RECOMMEND = 5;
    private static Map<String, Set<String>> friendList = new HashMap<>();
    private static Map<String, Integer> recommendScore = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        makeFriendList(friends);
        makeAllRecommendScore(user);
        addVisitorsScore(visitors);
        removeFriendWithUser(user);
        return answer;
    }

    private static void removeFriendWithUser(String user) {
        recommendScore.keySet().removeIf(key -> key.equals(user) || friendList.get(user).contains(key));
    }

    private static void addVisitorsScore(List<String> visitors) {
        for (String visitor : visitors) {
            findVisitorsCount(visitor);
        }
    }

    private static void findVisitorsCount(String visitor) {
        if (recommendScore.containsKey(visitor)) {
            recommendScore.put(visitor, recommendScore.get(visitor) + 1);
            return;
        }
        recommendScore.put(visitor, 1);
    }



    private static void makeAllRecommendScore(String user) {
        for (String targetUser : friendList.keySet()) {
            initRecommendScore(user,targetUser);
        }
    }

    private static void initRecommendScore(String user, String targetUser) {
        Set<String> userFriends = friendList.get(user);
        Set<String> targetUserFriends = friendList.get(targetUser);
        recommendScore.put(targetUser, countFriendUserKnowTogether(userFriends, targetUserFriends) * 10);
    }

    private static int countFriendUserKnowTogether(Set<String> userFriends, Set<String> targetUserFriends) {
        return (int)(targetUserFriends.stream()
                .filter(userFriends::contains)
                .count());
    }



    private static void makeFriendList(List<List<String>> friends) {
        for (List<String> friend : friends) {
            addFriendList(friend.get(0),friend.get(1));
            addFriendList(friend.get(1),friend.get(0));
        }
    }

    private static boolean checkFriendListKey(String user) {
        return friendList.containsKey(user);
    }

    private static void addFriendList(String key,String value) {
        if (checkFriendListKey(key)) {
            friendList.get(key).add(value);
            return;
        }
        Set<String> eachFriend = new HashSet<>();
        eachFriend.add(value);
        friendList.put(key, eachFriend);
    }

}
