package bakjun.bruteforce;

import java.util.Scanner;

public class Fatigue22864 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cost = sc.nextInt();
        int money = sc.nextInt();
        int relax = sc.nextInt();
        int limit = sc.nextInt();

        int fatigue = 0;
        int totalMoney = 0;
        for (int i=0; i<24; i++) {
            if (fatigue + cost <= limit) {
                fatigue += cost;
                totalMoney += money;
            } else {
                fatigue -= relax;
                if (fatigue < 0) fatigue = 0;
            }
        }
        System.out.println(totalMoney);
    }
}
