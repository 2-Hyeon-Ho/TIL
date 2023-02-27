import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 미래도시 {

    private static int n, m;    //전체회사의 개수, 경로
    private static int x, k;    //x : 최종 목적지, k : 중간 경유지
    private static int[][] graph;
    private static StringBuilder stringBuilder = new StringBuilder();
    private static final int INFINITY = (int) 1e9;

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        graph = new int[n+1][n+1];
        for(int[] array : graph) {
            Arrays.fill(array, INFINITY);
        }
        for(int i = 0; i <= n; i++) {
            graph[i][i] = 0;
        }

        for(int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        x = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());
    }

    private static void solution() {
        for(int i = 1; i <= n; i++) {
            for(int a = 1; a <= n; a++) {
                for(int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][i] + graph[i][b]);
                }
            }
        }

        int result = graph[1][k] + graph[k][x];
        if(result >= INFINITY) {    //10억+10억이 나올 수 있으므로 무한보다 크거나 같을 경우로 설정한다.
            stringBuilder.append(-1);
        }else {
            stringBuilder.append(result);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(stringBuilder);
    }
}
