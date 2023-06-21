package programmers.level1;

public class L1_CollatzGuess {
    public static void main(String[] args) {

        int n = 626331;
        System.out.println(solution(n));
    }

    static int count = 0;
    public static int solution(int num) {
        return col(num);
    }

    public static int col(int num) {

        if (count >= 500) return -1;

        if (num == 1) {
            return count;
        } else if (num%2 == 0) {
            num = num/2;
        } else if (num%2 == 1){
            num = (num*3) + 1;
        }

        count++;
        return col(num);
    }
}
