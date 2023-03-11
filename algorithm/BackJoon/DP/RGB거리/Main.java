import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int[][] array;
    private static int[][] dp;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        array = new int[n][3];
        dp = new int[n][3];

        for(int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < 3; j++) {
                array[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
    }

    private static void solution() {
        dp[0] = array[0];
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                if(j == 0) {
                    dp[i][j] = Math.min(dp[i-1][1], dp[i-1][2]) + array[i][j];
                }else if(j == 1) {
                    dp[i][j] = Math.min(dp[i-1][0], dp[i-1][2]) + array[i][j];
                }else {
                    dp[i][j] = Math.min(dp[i-1][0], dp[i-1][1]) + array[i][j];
                }
            }
        }

        int result = Math.min(dp[n-1][0], dp[n-1][1]);
        result = Math.min(result, dp[n-1][2]);
        stringBuilder.append(result);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(stringBuilder);
    }
}
