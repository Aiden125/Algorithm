package programmers.kit.hash;

import java.util.*;

public class BestAlbum {
    public static void main(String[] args) {
//        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
//        int[] plays = {500, 600, 150, 800, 2500};
//        System.out.println(Arrays.toString(BestAlbum.solution(genres, plays))); // 4,1,3,0
//
//        String[] genres2 = {"classic", "classic", "classic", "classic", "classic"};
//        int[] plays2 = {500, 600, 150, 800, 2500};
//        System.out.println(Arrays.toString(BestAlbum.solution(genres2, plays2))); // 4, 3

        String[] genres3 = {"pop", "pop", "pop", "rap", "rap"};
        int[] plays3 = {45,50,40, 60, 70};
        System.out.println(Arrays.toString(BestAlbum.solution(genres3, plays3))); // 1, 0, 4, 3
    }

    public static int[] solution(String[] genres, int[] plays) {
        // 총 재생횟수 map
        HashMap<String, Integer> genresPlayMap = new HashMap<>();
        for (int i=0; i<genres.length; i++) {
            String  g = genres[i];
            genresPlayMap.put(g, genresPlayMap.getOrDefault(g, 0) + plays[i]);
        }
        List<String> genrs = new ArrayList<>(genresPlayMap.keySet());
        Collections.sort(genrs, (v1, v2) -> (genresPlayMap.get(v2).compareTo(genresPlayMap.get(v1)))); // 내림차순

        // 장르 별로 순회하면서 장르에서 가장 많은 재생횟수 찾기
        List<Integer> list = new ArrayList<>();
        for (String g : genrs) {

            // 첫번째로 재생 수 많은 인덱스 찾기
            int max = -1;
            int firstIndex = -1;
            for (int i=0; i<plays.length; i++) {
                if (genres[i].equals(g) && plays[i] > max) {
                    firstIndex = i;
                    max = plays[i];
                }
            }

            // 두번째로 많은 인덱스 찾기
            max = -1;
            int secondIndex = -1;
            for (int i=0; i<plays.length; i++) {
                if (genres[i].equals(g) && plays[i] > max && i != firstIndex) {
                    secondIndex = i;
                    max = plays[i];
                }
            }

            list.add(firstIndex);
            if (secondIndex > -1) {
                list.add(secondIndex);
            }
        }

        int[] answer = new int[list.size()];
        for (int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
