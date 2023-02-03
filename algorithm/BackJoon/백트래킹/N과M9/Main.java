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

    private static void solution(int depth) {
        if(depth == m) {
            for(int i = 0; i < m; i++) {
                stringBuilder.append(array[i]).append(' ');
            }
            stringBuilder.append("\n");
            return;
        }
        //이전의 값을 여기에서 초기화 해줌으로써 조건을 만족하는 노드를 출력한 후에 초기화가 된다.
        //아직 재귀문을 완전히 탈출하지 못했을 때는 before가 0으로 초기화되지 않고 이전의 값을 갖고있어서 체크할 수 있다.
        int before = 0;
        for(int i = 0; i < n; i++) {
            if(!isUsed[i] && before != numbers[i]) {
                array[depth] = numbers[i];
                isUsed[i] = true;
                before = numbers[i];
                solution(depth+1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solution(0);
        System.out.println(stringBuilder);
    }
}
