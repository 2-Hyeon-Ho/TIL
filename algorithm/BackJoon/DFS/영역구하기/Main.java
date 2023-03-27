import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    private static int m, n, k, count;     //m : 세로길이, n : 가로길이, k : 사각형 개수
    private static int[][] array;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static ArrayList<Integer> result = new ArrayList<>();
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        m = Integer.parseInt(stringTokenizer.nextToken());
        n = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());

        array = new int[m][n];
        visited = new boolean[m][n];
        for(int i = 0; i < k; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken()) -1;
            int d = Integer.parseInt(stringTokenizer.nextToken()) -1;
            for(int j = b; j <= d; j++) {
                for(int l = a; l <= c; l++) {
                    array[j][l] = -1;
                }
            }
        }
    }

    private static void solution(int x, int y) {
        visited[x][y] = true;
        count++;
        array[x][y] = count;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
            if(array[nx][ny] != -1 && !visited[nx][ny]) {
                solution(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(array[i][j] != -1 && !visited[i][j]) {
                    solution(i, j);
                    result.add(count);
                    count = 0;
                }
            }
        }
        Collections.sort(result);
        stringBuilder.append(result.size()).append("\n");
        for(int i = 0; i < result.size(); i++) {
            stringBuilder.append(result.get(i)).append(" ");
        }
        System.out.println(stringBuilder);
    }
}
