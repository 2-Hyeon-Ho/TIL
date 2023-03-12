import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int n;
    private static int[] array;
    private static int[] dp;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());
        array = new int[n+1];
        dp = new int[n+1];

        for(int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(bufferedReader.readLine());
        }
    }

    private static void solution() {
        dp[1] = array[1];
        if(n >= 2) {
            dp[2] = array[1] + array[2];
        }
        for(int i = 3; i <= n; i++) {
            //dp[n]을 출력하는게 항상 최대가 아닐 수 있기 때문에 바로 이전의 dp값과도 비교를 해서 더 큰 값을 저장하면 된다.
            //연속된 선택을 막기 위해 이전의 dp[i-1]값에 array[i]값을 더한것을 비교하는 것이 아니라
            //세번째 전인 dp[i-3]에 array[i-1]값을 더한것을 비교함으로써 연속된 선택을 막을 수 있다.
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + array[i], dp[i-3] + array[i-1] + array[i]));
        }

        stringBuilder.append(dp[n]);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(stringBuilder);
    }
}
