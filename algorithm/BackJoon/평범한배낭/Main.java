import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n, k;    //물건의 개수, 버틸 수 있는 무게
    private static int[][] array;
    private static int[][] dp;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());
        array = new int[n+1][2];
        dp = new int[n+1][k+1];

        for(int i = 1; i <= n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            array[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            array[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    private static void solution() {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= k; j++) {
                if(array[i][0] > j) {
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], array[i][1] + dp[i-1][j-array[i][0]]);
                }
            }
        }

        stringBuilder.append(dp[n][k]);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(stringBuilder);
    }
}
