import java.util.*;
import java.io.*;


public class Main {

    private static int testcase, result, a, b;
    private static boolean[][] check = {
        {true, true, true, true, true, true, false},
        {false, true, true, false, false, false, false},
        {true, true, false, true, true, false, true},
        {true, true, true, true, false, false, true},
        {false, true, true, false, false, true, true},
        {true, false, true, true, false, true, true},
        {true, false, true, true, true, true, true},
        {true, true, true, false, false, true, false},
        {true, true, true, true, true, true, true},
        {true, true, true, true, false, true, true}
    };
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void solution() {
        int[] num1 = new int[5];
        int[] num2 = new int[5];
        Arrays.fill(num1, -1);
        Arrays.fill(num2, -1);
        for (int i = 0; i < 5; i++) {
            num1[i] = a % 10;
            a /= 10;
            if (a == 0) {
                break;
            }
        }
        for (int i = 0; i < 5; i++) {
            num2[i] = b % 10;
            b /= 10;
            if (b == 0) {
                break;
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                if (num1[i] != num2[i]) {
                    if (num1[i] == -1) {
                        if (check[num2[i]][j]) {
                            result++;
                        }
                    } else if (num2[i] == -1) {
                        if (check[num1[i]][j]) {
                            result++;
                        }
                    } else {
                        if (check[num1[i]][j] != check[num2[i]][j]) {
                            result++;
                        }
                    }
                }
            }
        }
        stringBuilder.append(result).append("\n");
        result = 0;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        testcase = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 0; i < testcase; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            a = Integer.parseInt(stringTokenizer.nextToken());
            b = Integer.parseInt(stringTokenizer.nextToken());
            solution();
        }
        System.out.println(stringBuilder);
    }
}