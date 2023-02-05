import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 모범답안 {

    private static int n, result;
    private static boolean[] upDown;    //상하 방향
    private static boolean[] diagonal1; // '/'방향 대각선
    private static boolean[] diagonal2; // '\'방향 대각선

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());
        upDown = new boolean[n];
        diagonal1 = new boolean[n*2];
        diagonal2 = new boolean[n*2];
    }

    private static void solution(int column) {
        if(column == n) {
            result++;
            return;
        }
        for(int row = 0; row < n; row++) {
            //같은 행과 두 대각선이 아닌 경우
            //row+column = '/'방향 대각선
            //row-column+n = '\'방향 대각선
            if(!upDown[row] && !diagonal1[row+column] && !diagonal2[row-column+n]) {
                upDown[row] = diagonal1[row+column] = diagonal2[row-column+n] = true;
                solution(column+1);
                upDown[row] = diagonal1[row+column] = diagonal2[row-column+n] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solution(0);
        System.out.println(result);
    }
}
