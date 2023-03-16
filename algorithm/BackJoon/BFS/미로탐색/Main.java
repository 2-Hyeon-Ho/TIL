import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n, m;    //세로길이, 가로길이
    private static int[][] array;
    private static int[] dx = {-1, 1, 0, 0};    //상하좌우
    private static int[] dy = {0, 0, -1, 1};    //상하좌우
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        array = new int[n][m];

        for(int i = 0; i < n; i++) {
            String line = bufferedReader.readLine();
            for(int j = 0; j < m; j++) {
                array[i][j] = line.charAt(j) - '0';     //char타입을 int형으로 변환하여 저장하기 위해 '0'을 빼줌
            }
        }
    }

    private static void solution(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            int nowX = now.getX();
            int nowY = now.getY();
            for(int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;    //범위를 벗어나는 경우
                if(array[nx][ny] == 0) continue;                        //길이 아닌 경우
                if(array[nx][ny] == 1) {
                    array[nx][ny] = array[nowX][nowY] + 1;
                    queue.offer(new Node(nx, ny));
                }
            }
        }

        stringBuilder.append(array[n-1][m-1]);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution(0, 0);
        System.out.println(stringBuilder);
    }
}

class Node {
    private int x, y;

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
