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
        isUsed = new boolean[n];
    }

    private static void solution(int depth) {
        if(depth == m) {
            for(int i = 0; i < m; i++) {
                stringBuilder.append(arr[i]).append(' ');
            }
            stringBuilder.append("\n");
            return;     //배열의 값을 stringBuilder에 저장하고 리턴을 해줌으로써 재귀호출 후 남아있는 부분 실행
        }
        for(int i = 0; i < n; i++) {
            if(!isUsed[i]) {
                arr[depth] = i+1;   //해당 깊이에 i+1값 저장
                isUsed[i] = true;
                solution(depth+1);  // 다음 자식 노드 방문을 위해 depth 1 증가시키면서 재귀호출
                // 자식노드 방문이 끝나고 돌아오면 방문노드를 방문하지 않은 상태로 변경
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
