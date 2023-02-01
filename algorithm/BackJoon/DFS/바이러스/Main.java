import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//DFS로 해결
public class Main {

    private static int node, edge;
    private static boolean[] visited;
    private static int[][] array;
    private static int result;
    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        node = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        edge = Integer.parseInt(stringTokenizer.nextToken());

        array = new int[node+1][node+1];
        visited = new boolean[node+1];

        for(int i = 0; i < edge; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(stringTokenizer.nextToken());
            int to = Integer.parseInt(stringTokenizer.nextToken());

            array[from][to] = array[to][from] = 1;
        }
    }

    private static int dfs(int start) {
        visited[start] = true;
        for(int i = 1; i <= node; i++) {
            if(array[start][i] == 1 && !visited[i]) {
                result++;
                dfs(i);
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(dfs(1));
    }
}
