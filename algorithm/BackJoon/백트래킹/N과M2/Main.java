import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n, m;
    private static int arr[];
    private static boolean isUsed[];
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        arr = new int[m];
        isUsed = new boolean[n+1];
    }

    private static void solution(int at, int depth) {
        if(depth == m) {
            for(int i = 0; i < arr.length; i++) {
                stringBuilder.append(arr[i]).append(' ');
            }
            stringBuilder.append("\n");
            return;
        }
        //at이라는 현재지점을 명시해줌으로써 어디서 부터 시작할지 정할 수 있다.
        //재귀를 at+1과 depth+1로 다음 재귀를 반복하므로 더 작은 숫자가 뒤에 올 수 없게 된다.
        for(int i = at; i <= n; i++) {
            if(!isUsed[i]) {
                arr[depth] = i;
                isUsed[i] = true;
                solution(i+1, depth+1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solution(1, 0);
        System.out.println(stringBuilder);
    }
}
