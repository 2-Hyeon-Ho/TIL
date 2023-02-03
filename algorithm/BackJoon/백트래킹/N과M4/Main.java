import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n, m;
    private static int[] array;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        array = new int[m];
    }

    private static void solution(int at, int depth) {
        if(depth == m) {
            for(int i = 0; i < m; i++) {
                stringBuilder.append(array[i]).append(' ');
            }
            stringBuilder.append("\n");
            return;
        }
        for(int i = at; i <= n; i++) {
            array[depth] = i;
            solution(i, depth+1);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solution(1, 0);
        System.out.println(stringBuilder);
    }
}
