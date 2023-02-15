import java.util.*;
import java.io.*;


public class Main {

    private static int k, p, n;
    private static long[] array;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        k = Integer.parseInt(stringTokenizer.nextToken());
        p = Integer.parseInt(stringTokenizer.nextToken());
        n = Integer.parseInt(stringTokenizer.nextToken());

        array = new long[n+1];
    }

    private static void solution() {
        array[0] = k;
        for(int i = 1; i <= n; i++) {
            array[i] = (array[i-1] * p) % 1000000007;
        }
        stringBuilder.append(array[n]);
    }

    public static void main(String args[]) throws IOException {
        input();
        solution();
        System.out.println(stringBuilder);
    }
}