import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 반복문을이용한이진탐색 {

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
        while(start <= end) {
            int midIndex = (start + end) / 2;
            if(array[midIndex] == target) {
                stringBuilder.append(midIndex+1);
                return;
            }else if(array[midIndex] > target) {
                end = midIndex-1;
            }else {
                start = midIndex+1;
            }
        }
        stringBuilder.append("원소가 존재하지 않습니다.");
    }

    public static void main(String[] args) throws IOException {
        input();
        binarySearch(array, 0, n);
        System.out.println(stringBuilder);
    }
}
