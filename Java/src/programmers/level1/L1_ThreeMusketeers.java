package programmers.level1;

public class L1_ThreeMusketeers {
    public static void main(String[] args) {
        int[] number = {-2, 3, 0, 2, -5};
        System.out.println("기대 값 2, 실제 값:" +solution(number));
    }

    public static int solution(int[] number) {
        int answer = 0;

        // 3중 for문으로 반복
        for(int i=0; i<number.length; i++) {
            for(int j=i+1; j< number.length; j++) {
                for(int k=j+1; k<number.length; k++){
                    if (number[i] + number[j] + number[k] == 0) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}
