package just_java_lambda.ex;

public class Lambda2 {
    public static void main(String[] args) {
        Myfunction f1 = () -> System.out.println("f1.run()");

        Myfunction f2 = new Myfunction() {
            public void run() { // 반드시 public으로 불러야함
                System.out.println("f2.run()");
            }
        };

        Myfunction f3 = getMyFunction();

        f1.run();
        f2.run();
        f3.run();

        execute(f1);
        execute(() -> System.out.println("run()"));
    }

    static void execute(Myfunction f) {
        f.run();
    }

    // 람다식을 호출하는 메서드
    static Myfunction getMyFunction() {
        return () -> System.out.println("f3.run()");
    }
}

@FunctionalInterface
interface Myfunction {
    void run();
}