import java.util.Scanner;

public class 음료수얼려먹기 {

    private static int M, N;
    private static int[][] array = new int[1000][1000];

    public static boolean dfs(int x, int y) {
        // 주어진 범위를 벗어나는 경우에는 즉시 종료
        if(x < 0 || y < 0 || x >= N || y >= M) {
            return false;
        }
        if(array[x][y] == 0) {
            array[x][y] = 1;
            // 상, 하, 좌, 우의 위치들도 모두 재귀적으로 호출
            dfs(x-1, y); //상
            dfs(x+1, y); //하
            dfs(x, y-1); //좌
            dfs(x, y+1); //우
            return true;
        }
        //0이 아닌 지점은 즉시 종료
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        scanner.nextLine(); // 버퍼 지우기

        for(int i = 0; i < N; i++) {
            String arrayX = scanner.nextLine();
            for(int j = 0; j < M; j++) {
                //2차원 리스트의 맵정보가 숫자가 붙어서 입력받으므로
                //스트링으로 입력을 받고 한글자씩 잘라서 int형으로 형변환 하기 위해 - '0'처리
                array[i][j] = arrayX.charAt(j) - '0';
            }
        }
        int result = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                // 0,0자리에서 부터 DFS수행
                if(dfs(i,j)) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}