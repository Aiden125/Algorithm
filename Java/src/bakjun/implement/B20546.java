package bakjun.implement;

import java.util.Scanner;

public class B20546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int jhMoney = m;
        int jhStock = 0;

        int smMoney = m;
        int smStock = 0;

        int increaseCount = 0;
        int decreaseCount = 0;
        int prePrice = 0;
        for (int i=1; i<=14; i++) {
            int todayPrice = sc.nextInt();

            // 준현이 사는 구간
            if (todayPrice <= jhMoney) {
                jhStock += jhMoney/todayPrice;
                jhMoney = jhMoney%todayPrice;
            }

            // 성민이 사는 구간
            if (i>1 && todayPrice > prePrice) {
                increaseCount++;
                decreaseCount = 0;
            } else if (i>1 && todayPrice < prePrice) {
                decreaseCount++;
                increaseCount = 0;
            }

            if (decreaseCount >= 3 && todayPrice <= smMoney) { // 3일이상 내리면 사기
                smStock += smMoney / todayPrice;
                smMoney = smMoney % todayPrice;
            } else if (increaseCount == 3 && smStock > 0) { // 3일이상 오르면 팔기
                smMoney += smStock * todayPrice;
                smStock = 0;
            }

            if (i==14) {
                jhMoney += jhStock * todayPrice;
                smMoney += smStock * todayPrice;
            }

            prePrice = todayPrice;
        }
        if (jhMoney > smMoney) {
            System.out.println("BNP");
        } else if (jhMoney < smMoney){
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");

        }
    }

}
