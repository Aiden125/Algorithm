package programmers.kit.stack;

import java.util.*;

public class Process {
    public static void main(String[] args) {
        int[] priorities = {2, 3, 1, 2};
        int location = 3;
        System.out.println(Process.solution(priorities, location)); // 2
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        // 내림차순으로 정렬한 배열, 정답 배열 만들기
        int[] answerArray = new int[priorities.length];
        Integer[] sortPriorities = new Integer[priorities.length];
        for (int i=0; i<priorities.length; i++) {
            sortPriorities[i] = priorities[i];
        }
        Arrays.sort(sortPriorities, Collections.reverseOrder());

        // 내림차순 배열과 일치하면 0순위부터 끝순위까지 할당, answer는 몇번째냐를 묻기에 +1해서 할당
        boolean found = false;
        int rankIndex = 0;
        while(!found) {
            for (int i=0; i<priorities.length; i++) {
                if (priorities[i] == sortPriorities[rankIndex]) {
                    answerArray[i] = rankIndex;
                    if (i == location) {
                        answer = rankIndex + 1;
                        found = true;
                        break;
                    }
                    rankIndex++;
                }
            }
        }

        return answer;
    }
}
