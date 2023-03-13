import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 개선된풀이 {

    private static int n, k;    //물건의 개수, 버틸 수 있는 무게
    private static int[] weight;
    private static int[] value;
    private static int[] dp;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());
        weight = new int[n+1];
        value = new int[n+1];
        dp = new int[k+1];

        for(int i = 1; i <= n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            weight[i] = Integer.parseInt(stringTokenizer.nextToken());
            value[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    private static void solution() {
        for(int i = 1; i <= n; i++) {
            for(int j = k; j - weight[i] >= 0; j--) {
                dp[j] = Math.max(dp[j], value[i] + dp[j-weight[i]]);
            }
        }
        stringBuilder.append(dp[k]);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(stringBuilder);
    }
}
