import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n, max, result;
    private static int[][] array;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        array = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                max = Math.max(max, array[i][j]);
            }
        }
    }

    private static void solution(int x, int y, int height) {
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if(!visited[nx][ny] && array[nx][ny] > height) {
                solution(nx, ny, height);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        int tempResult = 0;
        for(int i = 0; i < max; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    if(!visited[j][k] && array[j][k] > i) {
                        solution(j, k, i);
                        tempResult++;
                    }
                }
            }
            result = Math.max(result, tempResult);
            tempResult = 0;
            visited = new boolean[n][n];
        }
        System.out.println(result);
    }
}
