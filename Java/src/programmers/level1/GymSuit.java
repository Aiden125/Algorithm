package programmers.level1;

public class GymSuit {
    public static void main(String[] args) {

        GymSuit a = new GymSuit();
        int n = 5; // 학생 수
        int[] lost = {2,4}; // 잃어버린 학생
        int[] reserve = {1,3,5}; // 여분 있는 학생
        System.out.println(a.solution(n, lost, reserve));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n]; // 0 0 0 0 0 0
        for (int i=0; i<students.length; i++) {
            students[i] = 1;
        }
        for (int i=0; i<reserve.length; i++) {
            int reserveIndex = reserve[i] - 1;
            students[reserveIndex]++;
        }
        for (int i=0; i<lost.length; i++) {
            int lostIndex = lost[i] - 1;
            int left = lostIndex-1;
            int right = lostIndex+1;
            students[lostIndex]--;
            if (left > 0 && students[left] > 1) {
                students[left]--;
                students[lostIndex]++;
            } else if (right < students.length && students[right] > 1) {
                students[right]--;
                students[lostIndex]++;
            }
        }

        for (int i=0; i<students.length; i++) {
            if (students[i] >= 1) {
                answer++;
            }
        }
        return answer;
    }
}
