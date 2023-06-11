package programmers;

public class L1_FoodFighting {
    public static void main(String[] args) {
        int[] food = {1, 3, 4, 6};
        System.out.println(solution(food));
    }

    public static String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<food.length; i++) {
            int count = food[i]/2;

            for(int j=0; j<count; j++) {
                sb.append(i);
            }
        }

        String part1 = sb.toString();
        String part2 = sb.reverse().toString();
        answer = part1 + "0" + part2;
        return answer;
    }
}
