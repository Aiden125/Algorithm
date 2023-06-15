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
        StringBuilder sb = new StringBuilder();
        int[] a = new int[10];
        int[] b = new int[10];

        for(String x : X.split("")){
            a[Integer.parseInt(x)]++;
        }

        for(String y : Y.split("")){
            b[Integer.parseInt(y)]++;
        }

        for(int i=9; i>=0; i--) {
            int numberCount = Math.min(a[i], b[i]);
            if (numberCount != 0) {
                if (sb.toString().length() == 0 && i==0) {
                    return "0";
                }
                for(int j=0; j<numberCount; j++) {
                    sb.append(i);
                }
            }
        }

        return sb.toString().length() == 0 ? "-1" : sb.toString();
    }
}
