import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 반복문 {

    private static int testCase;
    private static int[] n;
    private static int zero, one, zeroPlusOne;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        testCase = Integer.parseInt(bufferedReader.readLine());
        n = new int[testCase];

        for(int i = 0; i < testCase; i++) {
            n[i] = Integer.parseInt(bufferedReader.readLine());
        }
    }

    private static void solution(int x) {
        zero = 1;
        one = 0;
        zeroPlusOne = 1;
        for(int i = 0; i < x; i++) {
            zero = one;
            one = zeroPlusOne;
            zeroPlusOne = zero + one;
        }
        stringBuilder.append(zero).append(' ').append(one);
    }

    public static void main(String[] args) throws IOException {
        input();
        for(int i = 0; i < testCase; i++) {
            stringBuilder = new StringBuilder();
            solution(n[i]);
            System.out.println(stringBuilder);
        }
    }
}
