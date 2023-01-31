import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탈출 {

    private static int N, M;
    //200 x 200 크기의 배열을 생성하면 이동 좌표 계산시 array boundary exceeded가 발생할 수 있다.
    private static int[][] array = new int[201][201];
    // 이동할 네 가지 방향 정의 (상, 하, 좌, 우)
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static int bfs(int x, int y) {
        Queue<미로찾기Node> queue = new LinkedList<>();
        queue.offer(new 미로찾기Node(x, y));
        while (!queue.isEmpty()) {
            미로찾기Node node = queue.poll();
            x = node.getX();
            y = node.getY();
            // 현재 위치에서 4가지 방향으로의 위치 확인
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 미로 찾기 공간을 벗어난 경우 무시
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                // 괴물인 경우 무시
                if(array[nx][ny] == 0) {
                    continue;
                }
                // 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
                if(array[nx][ny] == 1) {
                    //시작점은 항상 1이므로 1부터 시작해서 한칸이동 할 때마다 +1을 통해 이동횟수 카운트
                    //count를 따로 만들어서 count++를 사용하면 모든 칸을 모두 카운트 하므로 올바르지 않다.
                    //대신 이전노드의 거리값에 +1을 해서 BFS탐색을 끝내고 탈출구의 값을 반환하면 된다.
                    array[nx][ny] = array[x][y] + 1;
                    queue.offer(new 미로찾기Node(nx, ny));
                }
            }
        }
        return array[N - 1][M - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        scanner.nextLine(); // 버퍼 지우기

        for(int i = 0; i < N; i++) {
            String arrayX = scanner.nextLine();
            for (int j = 0; j < M; j++) {
                //2차원 리스트의 맵정보가 숫자가 붙어서 입력받으므로
                //스트링으로 입력을 받고 한글자씩 잘라서 int형으로 형변환 하기 위해 - '0'처리
                array[i][j] = arrayX.charAt(j) - '0';
            }
        }
        System.out.println(bfs(0,0));
    }
}

class 미로찾기Node {
    private int x;
    private int y;

    public 미로찾기Node(int x, int y) {
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