package inflearn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/** 3-3 매출액의 종류 */
public class l4_3_otherWay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> al = new ArrayList<Integer>();
        HashMap<Integer, Integer> mp = new HashMap<>();
        // 20 12 20 10 23 17 10
        // 20 12 20 10
        // n = 7, k = 4
        for(int i=0; i<k; i++){
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }
        al.add(mp.size());
        int lt = 0;
        for(int rt=k; rt<n; rt++) {
            int rtValue = arr[rt];
            mp.put(rtValue, mp.getOrDefault(rtValue, 0) + 1);
            int ltValue = arr[lt];
            mp.put(ltValue, mp.get(ltValue)-1);
            if(mp.get(ltValue) == 0) mp.remove(ltValue);
            al.add(mp.size());
            lt++;
        }
        for(int i : al) {
            System.out.print(i + " ");
        }
    }
}
