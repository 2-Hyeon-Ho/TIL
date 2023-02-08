import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 두배열의원소교체 {

    private static int n, k, result;
    private static Integer[] a;
    private static Integer[] b;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());

        a = new Integer[n];
        b = new Integer[n];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    private static void solution() {
        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());

        for(int i = 0; i < k; i++) {
            if(a[i] < b[i]) {
                a[i] = b[i];
            }
        }
        for(int i = 0; i < a.length; i++) {
            result += a[i];
        }
        stringBuilder.append(result);
        System.out.println(stringBuilder);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
