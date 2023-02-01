import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {

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

    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            start = queue.poll();
            for(int i = 1; i <= node; i++) {
                if(array[start][i] == 1 && !visited[i]) {
                    result++;
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(bfs(1));
    }
}