import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int k, n;
    private static int[] cable;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        k = Integer.parseInt(stringTokenizer.nextToken());
        n = Integer.parseInt(stringTokenizer.nextToken());
        cable = new int[(int) k];

        for (int i = 0; i < k; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            cable[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(cable);
    }

    private static void binarySearch(long start, long end) {
        while(start <= end) {
            long result = 0;
            long mid = (start + end) / 2;
            for(int i = 0; i < k; i++) {
                result += cable[i]/mid;
            }
            if(result >= n) {
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        //랜선의 최대길이를 구해야 하는 문제이므로 Upper Bound를 이용하여 접근할 수 있다.
        //마지막 start는 원하는 n개의 케이블 보다 많아지는 상태이기 때문에
        //마지막 start-1을 하면 n개의 케이블을 얻는 최대의 길이를 얻을 수 있다.
        stringBuilder.append(start-1);
    }

    public static void main(String[] args) throws IOException {
        input();
        binarySearch(1, cable[k - 1]);
        System.out.println(stringBuilder);
    }
}
