import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 누적합 {

    private static int n, k;
    private static int[] array;
    private static int[] accumulateSum;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());
        array = new int[n+1];
        accumulateSum = new int[n+1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    private static void solution() {
        for(int i = 1; i <= n; i++) {
            accumulateSum[i] = accumulateSum[i-1] + array[i];
        }

        int result = -(int) 1e9;
        for(int i = k; i <= n; i++) {
            //누적합에서 특정 구간만큼의 합을 구할때는 i를 구간의 개수부터 시작해서 끝까지 반복하는데
            //누적합[i] - 누적합[i-구간]이 특정 구간에서의 합이다.
            //ex)특정 구간이 3일 경우
            //누적합 배열의 5번째는 1번째 원소부터 5번째 원소까지의 합이다.
            //누적합 배열의 2번째는 1번째 원소부터 2번째 원소까지의 합이다.
            //누적합 배열의 5번째 값 - 누적합 배열의 2번째 값 = 3번째원소 부터 5번째 원소까지 3개 구간의 합
            //이처럼 누적합으로 특정구간의 합을 구할때 누적합[i] - 누적합[i-구간]으로 구할 수 있다.
            result = Math.max(result, accumulateSum[i] - accumulateSum[i-k]);
        }
        stringBuilder.append(result);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(stringBuilder);
    }
}
