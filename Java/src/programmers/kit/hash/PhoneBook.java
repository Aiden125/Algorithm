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
        Arrays.sort(phone_book);
        for (int i=0; i<phone_book.length-1; i++) {
            String left = phone_book[i];
            String right = phone_book[i+1];

            if (right.startsWith(left)) {
                answer = false;
            }
        }
        return answer;
    }
}
