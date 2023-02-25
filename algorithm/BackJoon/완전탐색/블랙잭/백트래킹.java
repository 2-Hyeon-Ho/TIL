import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백트래킹 {

    private static int n, m, result;
    private static int[] array;

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        array = new int[n];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    private static void solution(int depth, int start, int sum) {
        if(depth == 2) {
            if(sum <= m) {
                result = Math.max(result, sum);
            }
            return;
        }
        for(int i = start + 1; i < n; i++) {
            sum += array[i];
            solution(depth+1, i, sum);
            sum -= array[i];
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        for(int i = 0; i < n; i++) {
            solution(0, i, array[i]);
        }
        System.out.println(result);
    }
}
