import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int r, c;    //r : 세로, c : 가로
    private static int result;
    private static char[][] array;
    private static boolean[] visited = new boolean[26];
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        r = Integer.parseInt(stringTokenizer.nextToken());
        c = Integer.parseInt(stringTokenizer.nextToken());

        array = new char[r][c];
        for(int i = 0; i < r; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String temp = stringTokenizer.nextToken();
            for(int j = 0; j < c; j++) {
                array[i][j] = temp.charAt(j);
            }
        }
    }

    private static void solution(int x, int y, int distance) {
        result = Math.max(result, distance);
        int num = array[x][y] - 65;
        visited[num] = true;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
            int nNum = array[nx][ny] - 65;
            if(!visited[nNum]) {
                solution(nx, ny, distance+1);
                visited[nNum] = false;
            }
        }
        stringBuilder.append(result);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution(0, 0, 1);
        System.out.println(result);
    }
}
