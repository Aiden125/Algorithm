package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class L1_ReportResult {
    public static void main(String[] args) {

        String[] idList = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        System.out.println(Arrays.toString(solution(idList, report, k)));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String>[] al = new ArrayList[id_list.length];

        for(int i=0; i< report.length; i++) {
            String reporter = report[i].substring(0, report[i].indexOf(" "));
            String reported = report[i].substring(report[i].indexOf(" ")).trim();
            String duplicateCheck = map.getOrDefault(reported, "");

            if (duplicateCheck.contains(reporter)) {
                continue;
            }

            String forPut = duplicateCheck + reporter;
            map.put(reported, forPut);
        }
        return answer;
    }
}
