import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 플로이드워셜 {

    private static int n, e;    //노드, 간선의 수
    private static int[][] graph;
    private static int v1, v2;  //반드시 거쳐가야 할 노드 v1, v2
    private static StringBuilder stringBuilder = new StringBuilder();
    private static final int INFINITY = (int) 1e9;

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        e = Integer.parseInt(stringTokenizer.nextToken());

        graph = new int[n+1][n+1];
        for(int[] array : graph) {
            Arrays.fill(array, INFINITY);
        }
        for(int i = 1; i <= n; i++) {
            graph[i][i] = 0;
        }

        for(int i = 0; i < e; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());
            graph[a][b] = c;
            graph[b][a] = c;
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        v1 = Integer.parseInt(stringTokenizer.nextToken());
        v2 = Integer.parseInt(stringTokenizer.nextToken());
    }

    private static void solution() {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }

        int temp1 = graph[1][v1] + graph[v1][v2] + graph[v2][n];
        int temp2 = graph[1][v2] + graph[v2][v1] + graph[v1][n];

        int result = Math.min(temp1, temp2);
        if(result >= INFINITY || e == 0) {
            stringBuilder.append(-1);
        }else if(n == 1) {
            stringBuilder.append(0);
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
