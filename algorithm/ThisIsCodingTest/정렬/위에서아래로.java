import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class 위에서아래로 {

    private static int n;
    private static Integer[] array;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());
        array = new Integer[n];

        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(bufferedReader.readLine());
        }
    }

    private static void sort() {
        // 기본 정렬 라이브러리를 이용하여 내림차순 정렬 수행
        Arrays.sort(array, Collections.reverseOrder());
    }

    private static void print(Integer[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        sort();
        print(array);
    }

}
