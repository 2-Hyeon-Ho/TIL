import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 재귀문을이용한이진탐색 {

    private static int n, target;
    private static int[] array;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        target = Integer.parseInt(stringTokenizer.nextToken());

        array = new int[n];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    private static void binarySearch(int[] array, int start, int end) {
        if(start > end) {
            stringBuilder.append("원소가 존재하지 않습니다.");
            return;
        }
        int midIndex = (start + end) / 2;
        if(array[midIndex] == target) {
            stringBuilder.append(midIndex+1);
        }else if(array[midIndex] > target) {
            binarySearch(array, start, midIndex-1);
        }else {
            binarySearch(array, midIndex+1, end);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        binarySearch(array, 0, n);
        System.out.println(stringBuilder);
    }
}
