package programmers.kit.bruteforce;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * 소수 찾기 문제에서 Iterator를 사용하는데
 * 그 이유 중 하나가 for문 사용하면서 요소 제거시
 * 에러가 발생할 수 있다는 내용 때문에 테스트
 */
public class IterEx {
    public static void main(String[] args) {
        // List에 데이터 추가
        List<String> myList = new ArrayList<>();
        myList.add("Java");
        myList.add("Python");
        myList.add("C++");

        // 향상된 for 루프로 순회하면서 요소 제거 (에러 발생)
//        for (String element : myList) {
//            myList.remove(element);
//        }

        Iterator<String> it = myList.iterator();
        while(it.hasNext()) {
            it.next();
            it.remove();
            System.out.println();
        }
    }
}
