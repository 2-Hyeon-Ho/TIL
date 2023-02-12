import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 반복피보나치수열 {

    private static int n;
    private static long[] caching;

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        caching = new long[n+1];

        caching[1] = 1;
        caching[2] = 1;
    }

    private static long fibonacci(int x) {
        for(int i = 3; i <= n; i++) {
            caching[i] = caching[i-1] + caching[i-2];
        }
        return caching[x];
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(fibonacci(n));
    }
}