import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n, m, result;
    private static int[] array;
    private static StringBuilder stringBuilder = new StringBuilder();

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

    private static void solution() {
        for(int i = 0; i < n-2; i++) {
            int sum = 0;
            if(array[i] > m) continue;
            for(int j = i+1; j < n-1; j++) {
                if(array[i] + array[j] > m) continue;
                for(int k = j+1; k < n; k++) {
                    sum = array[i] + array[j] + array[k];
                    if(sum == m) {
                        stringBuilder.append(sum);
                        return;
                    }
                    if(sum > result && sum < m) {
                        result = sum;
                    }
                }
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
