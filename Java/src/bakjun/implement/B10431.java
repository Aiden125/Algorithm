package bakjun.implement;

import java.util.ArrayList;
import java.util.Scanner;

public class B10431 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i=0; i<T; i++) {
            int testCase = sc.nextInt();
            int[] students = new int[20];
            for (int j=0; j<20; j++) {
                students[j] = sc.nextInt();
            }

            solution(testCase, students);
        }
    }

    public static void  solution(int testCase, int[] students) {
        int walkCount = 0;

        ArrayList<Integer> studentLine = new ArrayList<>();

        for (int i=0; i<students.length; i++) {
            int student = students[i];
            for (int j=0; j<studentLine.size(); j++) {
                if (student < studentLine.get(j)) {
                    walkCount++;
                }
            }
            studentLine.add(student);
        }

        System.out.println(testCase + " " + walkCount);
    }

}
