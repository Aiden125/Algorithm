package define;

import java.util.HashMap;
import java.util.LinkedList;


class HashTable {
    // key, value를 가진 Node 클래스 정의
    class Node {
        String key;
        String value;

        // 노드 생성시 키와 밸류 지정해서 생성
        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        // value를 가져오고 저장 get, set
        public String getValue() {
            return value;
        }
        public void setValue(String value) {
            this.value = value;
        }
    }

    // Node로 이루어진 데이터
    LinkedList<Node>[] data;
    // 해시 테이블 생성시 사이즈 지정
    HashTable(int size) {
        this.data = new LinkedList[size];
    }

    // 해시 코드 반환해주는 함수
    int getHashCode(String key) {
        int hashcode = 0;
        for (char c : key.toCharArray()) {
            hashcode += c;
        }
        return hashcode;
    }

    // 해시 코드 받아서 배열방 인덱스로 저장
    int convertToIndex(int hashcode) {
        return hashcode % data.length;
    }

    // LinkedList를 돌면서 주어진 데이터와 key가 같은게 있는지
    // 있으면 node반환, 없으면 null 반환
    Node searchKey(LinkedList<Node> list, String key) {
        if (list == null) return null;
        for (Node node : list) {
            if (node.key.equals(key)) {
                return node;
            }
        }
        return null;
    }

    // 데이터를 받아서 저장
    void put(String key, String value) {
        int hashCode = getHashCode(key); // key를 가지고 hashCode 생성
        int index = convertToIndex(hashCode); // hashCode를 가지고 index 생성
        System.out.println(key + ", hashcode(" + hashCode + "), index(" + index + ")");
        LinkedList<Node> list = data[index]; // index를 가지고 list 가져옴
        if (list == null) { // 리스트가 null이면 즉, 비어있으면 linkedList를 하나 만들고 첫번쨰 인덱스에 넣기
            list = new LinkedList<Node>();
            data[index] = list;
//            data[index] = new LinkedList<Node>();
        }
        Node node = searchKey(list, key);
        if (node == null) { // node가 없으면 마지막에 저장
            list.addLast(new Node(key, value));
        } else { // 비어있지 않으면 값 새로 set
            node.setValue(value);
        }
    }

    String get(String key) {
        int hashcode = getHashCode(key);
        int index = convertToIndex(hashcode);
        LinkedList<Node> list = data[index];
        Node node = searchKey(list, key);
        return node == null ? "Not found" : node.getValue();
    }
}

public class HashTableTest {
    public static void main(String[] args) {
        HashTable h = new HashTable(3);
        h.put("moon", "He is a good");
        h.put("hee", "He is a nice");
        h.put("seok", "He is a man");
        h.put("moon", "He is a gooooooood man");
        System.out.println(h.get("moon"));
        System.out.println(h.get("hee"));
        System.out.println(h.get("seok"));

        HashMap<String, String> ha = new HashMap<>();
    }
}