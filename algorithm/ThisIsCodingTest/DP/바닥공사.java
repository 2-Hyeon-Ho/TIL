import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바닥공사 {

    private static int n;
    private static int[] array;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        array = new int[n+1];
    }

    private static void solution() {
        array[1] = 1;
        array[2] = 3;
        for(int i = 3; i <= n; i++) {
            array[i] = (array[i-1] + 2 * array[i-2]) % 796796;
        }
        stringBuilder.append(array[n]);
    }

    public static void main(String[] args) throws IOException{
        input();
        solution();
        System.out.println(stringBuilder);
    }
}
