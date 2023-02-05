import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int n, result;
    private static int[] board; //1차원 배열로 선언해서 인덱스를 열로 생각하고 값을 행으로 생각한다.

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());
        board = new int[n];
    }

    private static void solution(int column) {
        //행을 다 채웠을 경우(배열을 다 채웠을 경우) 결과를 증가시키고 리턴해서 재귀적으로 실행
        if(column == n) {
            result++;
            return;
        }
        for(int i = 0; i < n; i++) {
            board[column] = i;
            if(check(column)) {
                solution(column+1);
            }
        }
    }

    private static boolean check(int column) {
        for(int i = 0; i < column; i++) {
            //같은 행에 있을 경우
            if(board[i] == board[column]) {
                return false;
                //절댓값의 차가 같으면 대각선상에 있는 것이다.
            }else if(Math.abs(column - i) == Math.abs(board[column] - board[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        input();
        solution(0);
        System.out.println(result);
    }
}
