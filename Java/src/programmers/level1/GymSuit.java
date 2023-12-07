package programmers.level1;

public class GymSuit {
    public static void main(String[] args) {

        GymSuit a = new GymSuit();
        int n = 2; // 학생 수
        int[] lost = {2,4}; // 잃어버린 학생
        int[] reserve = {1,3,5}; // 여분 있는 학생
        a.solution(n, lost, reserve);
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n+1]; // 0 0 0 0 0 0
        for (int i=1; i<students.length+1; i++) { // 0은 제외
            students[i] = 1;
        }
        for (int i=0; i<reserve.length; i++) {
            int reserveIndex = reserve[i];
            students[reserveIndex]++;
        }
        for (int i=0; i<lost.length; i++) {
            int lostIndex = lost[i];
            students[lostIndex]--;
            if (lostIndex-1 > 0 && students[lostIndex-1] > 1) {
                students[lostIndex-1]--;
                students[lostIndex]++;
            } else if (lostIndex+1 < students.length && students[lostIndex+1] > 1) {
                students[lostIndex+1]--;
                students[lostIndex]++;
            }
        }

        for (int i=0; i<reserve.length; i++) {
            if (reserve[i] >= 1) {
                answer++;
            }
        }
        return answer;
    }
}
