import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 재귀함수 {

    private static int testCase;
    private static int[] n;
    private static int[][] dp = new int[41][2];
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        testCase = Integer.parseInt(bufferedReader.readLine());
        n = new int[testCase];

        for(int i = 0; i < testCase; i++) {
            n[i] = Integer.parseInt(bufferedReader.readLine());
        }
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 1;   //fibonacci(0)일 때 0은 1번 호출
        dp[0][1] = 0;   //fibonacci(0)일 때 1은 0번 호출
        dp[1][0] = 0;   //fibonacci(1)일 때 0은 0번 호출
        dp[1][1] = 1;   //fibonacci(1)일 때 1은 1번 호출
    }

    private static int[] solution(int x) {
        if(dp[x][0] == -1 || dp[x][1] == -1) {
            dp[x][0] = solution(x-1)[0] + solution(x-2)[0];
            dp[x][1] = solution(x-1)[1] + solution(x-2)[1];
        }
        return dp[x];
    }

    public static void main(String[] args) throws IOException {
        input();
        for(int i = 0; i < testCase; i++) {
            stringBuilder = new StringBuilder();
            solution(n[i]);
            stringBuilder.append(dp[n[i]][0]).append(' ').append(dp[n[i]][1]);
            System.out.println(stringBuilder);
        }
    }
}