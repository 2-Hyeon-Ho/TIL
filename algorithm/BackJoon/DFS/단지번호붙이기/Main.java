import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static int length;
    private static int houseCount;
    private static boolean[][] visited;
    private static int[][] array;
    private static int[] dx = {-1, 1, 0, 0};    //상,하,좌,우
    private static int[] dy = {0, 0, -1, 1};    //상,하,좌,우
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        length = Integer.parseInt(bufferedReader.readLine());
        array = new int[length][length];
        visited = new boolean[length][length];
        for(int i = 0; i < length; i++) {
            String s = bufferedReader.readLine();
            for(int j = 0; j < length; j++) {
                int house = s.charAt(j) - '0';
                array[i][j] = house;
            }
        }
    }

    private static int dfs(int x, int y) {
        visited[x][y] = true;
        //상,하,좌,우 모두 이동해보면서 연결되어 있는지 확인
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            //주어진 배열의 크기를 벗어났으면 넘어가기
            if(nx < 0 || ny < 0 || nx >= length || ny >= length) {
                continue;
            }
            //연결되어 있고 방문하지 않은 곳이라면 재귀적으로 함수실행하면서 탐색
            if(!visited[nx][ny] && array[nx][ny] == 1) {
                houseCount++;
                dfs(nx, ny);
            }
        }
        return houseCount;
    }

    public static void main(String[] args) throws IOException {
        input();
        List<Integer> list = new ArrayList<>();     //각 단지의 가구 갯수를 저장하기 위한 리스트
        //모든 배열을 확인하면서 집이 있으면서 방문하지 않은 곳이면 dfs 메서드 실행 후 결과를 리스트에 저장
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                if(!visited[i][j] && array[i][j] == 1) {
                    //새로운 단지내 집의 수를 카운트하기 위해 초기화
                    houseCount = 1;
                    list.add(dfs(i,j));
                }
            }
        }
        //가구의 수를 오름차순으로 보여주기 위해 정렬실행
        Collections.sort(list);
        stringBuilder.append(list.size()).append("\n");
        for (Integer integer : list) {
            stringBuilder.append(integer).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
