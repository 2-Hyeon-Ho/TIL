import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int testCase;
    private static int n, m, k;  //가로길이, 세로길이, 배추의 수
    private static int[][] array;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        testCase = Integer.parseInt(stringTokenizer.nextToken());

        for(int i = 0; i < testCase; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            n = Integer.parseInt(stringTokenizer.nextToken());
            m = Integer.parseInt(stringTokenizer.nextToken());
            k = Integer.parseInt(stringTokenizer.nextToken());

            array = new int[n][m];
            visited = new boolean[n][m];
            for(int j = 0; j < k; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int a = Integer.parseInt(stringTokenizer.nextToken());
                int b = Integer.parseInt(stringTokenizer.nextToken());
                array[a][b] = 1;
            }

            int result = 0;
            for(int j = 0; j < n; j++) {
                for(int l = 0; l < m; l++) {
                    if (array[j][l] == 1 && !visited[j][l]) {
                        bfs(j, l);
                        result++;
                    }
                }
            }
            stringBuilder.append(result).append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        visited[x][y] = true;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int nowX = node.getX();
            int nowY = node.getY();
            for(int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(array[nx][ny] == 0) continue;
                if(array[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }
}

class Node {
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
}
