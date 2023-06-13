package programmers.level1;

public class L1_WalkPark {
    public static void main(String[] args) {
        String[] p = {"OSO","OOO","OXO","OOO"};
        String[] r = {"E 2","S 2","W 1"};
        System.out.println(solution(p, r));
    }

    public static int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        int dy = 0;
        int dx = 0;

        // park: ["OSO","OOO","OXO","OOO"], routes: ["E 2","S 3","W 1"], result: [0,0]
        char[][] map = new char[park.length+1][park[1].length()+1];
        for(int i=0; i<park.length; i++) {
            String a = park[i];
            for(int j=0; j<a.length(); j++) {
                char aChar = a.charAt(j);
                map[i][j] = aChar;
                if (aChar=='S') {
                    dy = i;
                    dx = j;
                }
            }
        }

        for(int i=0; i<routes.length; i++) {
            String a = routes[i];
            char direction = a.charAt(0);
            int count = Integer.parseInt(String.valueOf(a.charAt(2)));

            int ny = dy;
            int nx = dx;

            for(int j=0; j<count; j++) {
                if(direction == 'E') {
                    if(nx<=0 || nx+1>=map[i].length || ny<=0 | ny>=map.length || map[ny][nx+1]=='X') {
                        ny = dy;
                        nx = dx;
                        break;
                    } else {
                        nx += 1;
                    }
                }

                else if(direction == 'S') {
                    if(nx<=0 || nx>=map[i].length || ny+1<=0 | ny>=map.length || map[ny+1][nx]=='X') {
                        ny = dy;
                        nx = dx;
                        break;
                    } else {
                        ny += 1;
                    }
                }

                else if(direction == 'W') {
                    if(nx-1<=0 || nx>=map[i].length || ny<=0 | ny>=map.length || map[ny][nx-1]=='X') {
                        ny = dy;
                        nx = dx;
                        break;
                    } else {
                        nx -= 1;
                    }
                }

                else if(direction == 'N') {
                    if(nx<=0 || nx>=map[i].length || ny-1<=0 | ny>=map.length || map[ny-1][nx]=='X') {
                        ny = dy;
                        nx = dx;
                        break;
                    } else {
                        ny -= 1;
                    }
                }
            }

            if (ny!=dy || nx!=dx) {
                dy = ny;
                dx = nx;
            }

            int[] b = {dy, dx};
            answer = b;
        }
        return answer;
    }
}
