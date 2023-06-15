package programmers.level1;

public class L1_NumberPartner {
    public static void main(String[] args) {

//        String X = "100";
//        String Y = "2345";
//        System.out.println(solution(X, Y)); // 기대값 -1
//
//        String X2 = "100";
//        String Y2 = "203045";
//        System.out.println(solution(X2, Y2)); // 기대값 0

        String X3 = "5525";
        String Y3 = "1255";
        System.out.println(solution(X3, Y3));
    }
    public static String solution(String X, String Y) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        int[] a = new int[10];
        int[] b = new int[10];

        for(int i=0; i<X.length(); i++) {
            int target = Integer.parseInt(String.valueOf(X.charAt(i)));
            a[target]++;
        }

        for(int i=0; i<Y.length(); i++) {
            int target = Integer.parseInt(String.valueOf(Y.charAt(i)));
            b[target]++;
        }

        for(int i=9; i>=0; i--) {
            int numberCount = Math.min(a[i], b[i]);
            if (numberCount != 0) {
                for(int j=0; j<numberCount; j++) {
                    if (sb.toString().length() == 0 && i==0) {
                        return "0";
                    }
                    sb.append(i);
                }
            }
        }

        answer = sb.toString();
        if (answer.length() == 0) {
            answer = "-1";
        }

        return answer;
    }
}
