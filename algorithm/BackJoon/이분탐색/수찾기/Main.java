import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int n, m;
    private static int[] array1, array2;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        array1 = new int[n];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < n; i++) {
            array1[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        m = Integer.parseInt(stringTokenizer.nextToken());
        array2 = new int[m];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < m; i++) {
            array2[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(array1);
    }

    private static void binarySearch(int start, int end, int target) {
        if(start > end) {
            stringBuilder.append("0\n");
            return;
        }
        int mid = (start + end) / 2;
        if(target == array1[mid]) {
            stringBuilder.append("1\n");
        }else if(target < array1[mid]) {
            binarySearch(start, mid-1, target);
        }else {
            binarySearch(mid+1, end, target);
        }
    }

    private static void solution() {
        for(int i = 0; i < m; i++) {
            binarySearch(0, n-1, array2[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(stringBuilder);
    }
}
