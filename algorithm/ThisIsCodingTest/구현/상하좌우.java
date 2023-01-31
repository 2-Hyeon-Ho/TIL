import java.util.Scanner;

public class 상하좌우 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int x = 1;
        int y = 1;

        scanner.nextLine();
        String[] routes = scanner.nextLine().split(" ");

        for (String route : routes) {
            switch (route) {
                case "L":
                    if (y == 1) {
                        break;
                    }
                    y--;
                    break;
                case "R":
                    if (y == N) {
                        break;
                    }
                    y++;
                    break;
                case "U":
                    if (x == 1) {
                        break;
                    }
                    x--;
                    break;
                case "D":
                    if (x == N) {
                        break;
                    }
                    x++;
                    break;
            }
        }
        //모범답안이지만 시간복잡도 차이가 크지 않음
        /*
        // L, R, U, D에 따른 이동 방향
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        char[] moveTypes = {'L', 'R', 'U', 'D'};

        // 이동 계획을 하나씩 확인
        for (int i = 0; i < routes.length; i++) {
            char plan = routes[i].charAt(0);
            // 이동 후 좌표 구하기
            int nx = -1, ny = -1;
            for (int j = 0; j < 4; j++) {
                if (plan == moveTypes[j]) {
                    nx = x + dx[j];
                    ny = y + dy[j];
                }
            }
            // 공간을 벗어나는 경우 무시
            if (nx < 1 || ny < 1 || nx > N || ny > N) continue;
            // 이동 수행
            x = nx;
            y = ny;
        }
         */
        System.out.println(x + " " + y);
    }
}
