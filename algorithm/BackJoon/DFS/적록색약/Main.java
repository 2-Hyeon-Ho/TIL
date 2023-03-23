import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static char[][] array;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());

        array = new char[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String temp = stringTokenizer.nextToken();
            for(int j = 0; j < n; j++) {
                array[i][j] = temp.charAt(j);
            }
        }
    }

    private static void solution(int x, int y) {
        visited[x][y] = true;
        char now = array[x][y];
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(outOfRange(nx, ny)) continue;
            if(!visited[nx][ny] && array[nx][ny] == now) {
                solution(nx, ny);
            }
        }
    }

    private static void patientSolution(int x, int y) {
        visited[x][y] = true;
        char now = array[x][y];
        if(now == 'G') now = 'R';
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(outOfRange(nx, ny))continue;
            if(array[nx][ny] == 'G') array[nx][ny] = 'R';
            if(!visited[nx][ny] && array[nx][ny] == now) {
                patientSolution(nx, ny);
            }
        }
    }

    private static boolean outOfRange(int nx, int ny) {
        return (nx < 0 || ny < 0 || nx >= n || ny >= n);
    }

    public static void main(String[] args) throws IOException {
        int commonResult = 0;
        int patientResult = 0;
        input();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    solution(i, j);
                    commonResult++;
                }
            }
        }
        for (boolean[] booleans : visited) {
            Arrays.fill(booleans, false);
        }
        stringBuilder.append(commonResult).append(" ");

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    patientSolution(i, j);
                    patientResult++;
                }
            }
        }
        stringBuilder.append(patientResult);

        System.out.println(stringBuilder);
    }
}
