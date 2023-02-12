import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 피보나치수열 {

    private static int n;
    private static long[] caching;

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        caching = new long[n*2];
    }

    private static long fibonacci(int x) {
        if(x == 1 || x == 2) {
            return 1;
        }
        if(caching[x] != 0) {
            return caching[x];
        }
        caching[x] = fibonacci(x - 1) + fibonacci(x - 2);
        return caching[x];
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(fibonacci(n));
    }
}
