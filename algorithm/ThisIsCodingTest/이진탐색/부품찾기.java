import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 부품찾기 {

    private static int n, m;
    private static int[] parts;
    private static int[] demand;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        parts = new int[n];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            parts[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        m = Integer.parseInt(stringTokenizer.nextToken());
        demand = new int[m];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < m; i++) {
            demand[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    private static void binarySearch(int target, int start, int end) {
        Arrays.sort(parts);

        int midIndex = (start + end) / 2;
        if (start > end) {
            stringBuilder.append("no").append(' ');
            return;
        }
        if (parts[midIndex] == target) {
            stringBuilder.append("yes").append(' ');
        } else if (parts[midIndex] > target) {
            binarySearch(target, start, midIndex-1);
        } else {
            binarySearch(target, midIndex+1, end);
        }
    }

    private static void solution() {
        for(int i = 0; i < m; i++) {
            binarySearch(demand[i], 0, n);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(stringBuilder);
    }
}
