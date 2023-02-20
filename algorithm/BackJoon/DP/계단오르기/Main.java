import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int step;
    private static int[] scores;
    private static int[] dp;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        step = Integer.parseInt(bufferedReader.readLine());
        scores = new int[step+1];   //점수를 저장할 배열
        dp = new int[step+1];       //결과를 저장할 배열

        for(int i = 1; i <= step; i++) {
            scores[i] = Integer.parseInt(bufferedReader.readLine());
        }
        dp[1] = scores[1];  //첫번째 계단을 올라갔을 때
        if(step >= 2) {     //step이 1일 경우에 dp[2] = scores[1] + scores[2];를 하면 배열의 크기가 맞지 않아 에러발생
            dp[2] = scores[1] + scores[2];
        }
    }

    private static void solution() {
        for(int i = 3; i <= step; i++) {
            //두 계단 전의 합 결과와 한 계단 전의 합 결과중 더 큰값을 선택해서 현재 계단의 값을 더하는게 최댓값을 구할 수 있다.
            //하지만 dp[i-1]을 호출하는 경우는 연속된 계단을 오르는 경우이다.
            //이때 dp[i-1]을 호출하면 그전에도 연속된 계단을 올랐는지 체크를 할 수 없으므로
            //세 계단 전의 합 결과와 한 계단 전의 값을 더해서 한 계단 전의 합 결과를 구한다.
            dp[i] = Math.max(dp[i-2], dp[i-3] + scores[i-1]) + scores[i];
        }
        stringBuilder.append(dp[step]);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(stringBuilder);
    }
}
