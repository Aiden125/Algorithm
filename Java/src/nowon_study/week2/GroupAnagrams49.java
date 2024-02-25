package nowon_study.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams49 {
    public static void main(String[] args) {
        String[] str1 = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(str1));

        String[] str2 = {"ate","eat","tea"};
        System.out.println(groupAnagrams(str2));

    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortStr = new String(chars);

            int index = map.getOrDefault(sortStr, -1);
            if (map.getOrDefault(sortStr, -1) == -1) { // 그룹이 없는 경우
                answer.add(new ArrayList<>());
                answer.get(answer.size() - 1).add(str);
                map.put(sortStr, answer.size() - 1);
            } else {
                answer.get(index).add(str);
            }

        }

        return answer;
    }
}
