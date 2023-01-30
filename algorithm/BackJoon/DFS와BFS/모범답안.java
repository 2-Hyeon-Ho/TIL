import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 모범답안 {

    private static int node, edge, start;
    private static boolean[] visited;
    private static int[][] array;   //인접 행렬을 위한 배열 생성
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        node = Integer.parseInt(stringTokenizer.nextToken());
        edge = Integer.parseInt(stringTokenizer.nextToken());
        start = Integer.parseInt(stringTokenizer.nextToken());

        array = new int[node+1][node+1];        //인접행렬 초기화
        visited = new boolean[node+1];          //방문한 노드를 체크하기 위한 배열 초기화

        for(int i = 0; i < edge; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int node = Integer.parseInt(stringTokenizer.nextToken());
            int to = Integer.parseInt(stringTokenizer.nextToken());

            array[node][to] = 1;    //연결된 노드 간의 거리를 저장
            array[to][node] = 1;    //연결된 노드 간의 거리를 저장
        }
    }

    private static void dfs(int start) {
        visited[start] = true;
        stringBuilder.append(start + " ");
        for(int i = 1; i <= node; i++) {
            //노드간 연결되어 있고, 방문하지 않은 경우 재귀함수 호출
            if(array[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            start = queue.poll();
            stringBuilder.append(start + " ");
            for(int i = 1; i <= node; i++) {
                //노드간 연결되어 있고, 방문하지 않은 경우 큐에 삽입
                if(array[start][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    private static void solution() {
        dfs(start);
        stringBuilder.append("\n");
        Arrays.fill(visited, false);
        bfs(start);
        System.out.println(stringBuilder);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
