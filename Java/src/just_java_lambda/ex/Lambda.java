package just_java_lambda.ex;

public class Lambda {
    public static void main(String[] args) {
//        MyFunction2 f = new MyFunction2() {
//            @Override
//            public int max(int a, int b) {
//                return a > b ? a : b;
//            }
//        };

        // 람다식을 다루기 위한 참조변수의 타입은 함수형 인터페이스
        MyFunction2 f = (a, b) -> a > b ? a : b;
        MyFunction2 d = (a, b) -> a+b;

        int value = f.max(3, 5);
        System.out.println("value=" + value);

        int value2 = d.max(3, 5);
        System.out.println("value=" + value2);
    }
}

@FunctionalInterface // 함수형 인터페이스 명시
interface MyFunction2 {
//    public abstract int max(int a, int b);
    int max(int a, int b);
}
