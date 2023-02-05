import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int n, m;
    private static int[] array;
    private static int[] numbers;
    private static boolean[] isUsed;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        array = new int[m];
        numbers = new int[n];
        isUsed = new boolean[n];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(numbers);
    }

    private static void solution(int at, int depth) {
        if(depth == m) {
            for(int i = 0; i < m; i++) {
                stringBuilder.append(array[i]).append(' ');
            }
            stringBuilder.append("\n");
            return;
        }
        int before = 0;
        for(int i = at; i < n; i++) {
            if(!isUsed[i] && before != numbers[i]) {
                array[depth] = numbers[i];
                isUsed[i] = true;
                before = numbers[i];
                solution(i+1, depth+1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solution(0,0);
        System.out.println(stringBuilder);
    }
}

