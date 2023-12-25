package programmers.kit.hash;

import java.util.Arrays;

public class PhoneBook {
    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        System.out.println(PhoneBook.solution(phone_book));

        String[] phone_book2 = {"123","456","789"};
        System.out.println(PhoneBook.solution(phone_book2));

        String[] phone_book3 = {"12","123","1235","567","88"};
        System.out.println(PhoneBook.solution(phone_book3));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        // 전화번호 목록 정렬
        Arrays.sort(phone_book);

        // 현재꺼랑 뒤에꺼 비교해서 접두사가 같은지 비교
        for (int i=0; i<phone_book.length-1; i++) {
            String left = phone_book[i];
            String right = phone_book[i+1];

            // 접두사만 해당이므로 startWith 활용
            if (right.startsWith(left)) {
                answer = false;
            }
        }
        return answer;
    }
}
