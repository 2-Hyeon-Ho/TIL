import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 떡볶이떡만들기 {

    private static int n, m; //n : 떡의 갯수, m : 요청한 떡의 길이
    private static int[] array;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        array = new int[n];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    private static void sort() {
        Arrays.sort(array);
    }

    private static void solution(int start, int end) {
        int mid = (end + start) / 2;
        if(start > end) {
            stringBuilder.append(mid); //적어도 요청한 m만큼의 떡을 가져가기 위해서 나눠떨어지지 않는다면 현재 mid값을 출력한다.
            return;
        }
        int result = 0;
        for(int i = 0; i < n; i++) {
            if(array[i] > mid) {
                result += (array[i] - mid);
            }
        }
        if(result == m) {
            stringBuilder.append(mid);
        }else if(result > m) {
            solution(mid+1, end);
        }else {
            solution(start, mid-1);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        sort();
        solution(0, array[n-1]);
        System.out.println(stringBuilder);
    }
}
