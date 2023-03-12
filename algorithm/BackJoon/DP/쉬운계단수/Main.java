import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final long INT = 1_000_000_000;
    private static int n;
    private static long[][] dp;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());
        dp = new long[n+1][10];
    }

    private static void solution() {
        for(int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < 10; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i-1][1] % INT;
                }else if(j == 9) {
                    dp[i][j] = dp[i-1][8] % INT;
                }else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % INT;
                }
            }
        }

        long result = 0;    //결과값을 10억으로 나눠서 출력하라는 조건이 있기 때문에 결과값의 범위가 int형을 넘어설 수 있으므로 long으로 선언한다.
        for(int i = 0; i < 10; i++) {
            result += dp[n][i];
        }
        stringBuilder.append(result % INT);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(stringBuilder);
    }
}
