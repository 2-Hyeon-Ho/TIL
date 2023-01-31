import java.util.Scanner;

public class 게임개발 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();  //높이
        int M = scanner.nextInt();  //너비

        int A = scanner.nextInt();  //캐릭터의 X좌표
        int B = scanner.nextInt();  //캐릭터의 Y좌표
        int d = scanner.nextInt();  //캐릭터가 바라보고 있는 방향 0(북),1(동),2(남),3(서)

        int[][] map = new int[N][M];    //0(육지), 1(바다)

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        int[] dx = {-1, 0, 1, 0};   //북, 동, 남, 서
        int[] dy = {0, 1, 0, -1};   //북, 동, 남, 서

        int result = 1;
        int turnCount = 0;
        while (true) {
            d--;
            if(d < 0) d = 3;
            turnCount++;

            int nx = A + dx[d];
            int ny = B + dy[d];
            if (map[nx][ny] == 0) {
                map[A][B] = 2;
                A = nx;
                B = ny;
                result++;
                turnCount = 0;
            }
            if(turnCount == 4) {
                nx = A - dx[d];
                ny = B - dy[d];
                if(map[nx][ny] == 2) {
                    map[A][B] = 2;
                    A = nx;
                    B = ny;
                    turnCount = 0;
                }
                else {
                    break;
                }
            }
        }
        System.out.println(result);
    }
}



