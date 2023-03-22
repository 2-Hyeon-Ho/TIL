import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n, m;
    private static int[][] array;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static Queue<Node> queue = new LinkedList<>();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        array = new int[m][n];
        for(int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
    }

    private static int solution() {
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            int nowX = now.getX();
            int nowY = now.getY();
            for(int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if(array[nx][ny] == 0) {
                    queue.add(new Node(nx, ny));
                    array[nx][ny] = array[nowX][nowY] + 1;
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(array[i][j] == 0) {
                    return -1;
                }
                if(result < array[i][j]) {
                    result = array[i][j];
                }
            }
        }
        return result-1;
    }

    public static void main(String[] args) throws IOException {
        input();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(array[i][j] == 1) {
                    queue.add(new Node(i, j));
                }
            }
        }
        System.out.println(solution());
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
        return x;
    }

    public int getY() {
        return y;
    }
}
