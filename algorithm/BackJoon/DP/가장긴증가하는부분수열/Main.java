import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int n, result;
    private static int[] array;
    private static int[] dp;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        array = new int[n];
        dp = new int[n];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    private static void solution() {
        Arrays.fill(dp, 1);     //모든 순열은 자기 자신을 이루고 있을 때 1이 최소이므로 1을 모두 넣어준다.
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                //현재 인덱스에서 값이 이전 인덱스 값보다 크고
                //해당 인덱스에서 길이값이 이전 인덱스 길이값보다 작으면 이전 인덱스의 길이값에 +1한 값을 저장한다.
                if(array[i] > array[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        //배열내에서 최대 길이값을 뽑아옴
        for(int i = 0; i < n; i++) {
            if(dp[i] > result) {
                result = dp[i];
            }
        }
        stringBuilder.append(result);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(stringBuilder);
    }
}
