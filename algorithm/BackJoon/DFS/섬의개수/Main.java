import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int w, h, result;
    private static int[][] array;
    private static boolean[][] visited;
    private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    private static StringTokenizer stringTokenizer;
    private static StringBuilder stringBuilder = new StringBuilder();
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    private static void solution(int x, int y) {
        visited[x][y] = true;
        for(int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
            if(!visited[nx][ny] && array[nx][ny] == 1) {
                solution(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            result = 0;
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            w = Integer.parseInt(stringTokenizer.nextToken());
            h = Integer.parseInt(stringTokenizer.nextToken());
            if(w == 0 && h == 0) break;

            array = new int[h][w];
            visited = new boolean[h][w];
            for(int i = 0; i < h; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for(int j = 0; j < w; j++) {
                    array[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(!visited[i][j] && array[i][j] == 1) {
                        solution(i, j);
                        result++;
                    }
                }
            }
            stringBuilder.append(result).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
