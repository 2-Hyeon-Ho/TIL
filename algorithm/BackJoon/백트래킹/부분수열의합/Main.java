import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int n, s, result;
    private static int[] array;

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        s = Integer.parseInt(stringTokenizer.nextToken());

        array = new int[n];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(array);
    }

    private static void solution(int depth, int sum) {
        //노드 끝까지 탐색했고 노드값들의 합과 s가 같을 경우에만 result를 증가하고 리턴하고 남은 재귀함수 이어서 진행
        //노드 끝까지 탐색했지만 노드값들의 합과 s가 다를 경우에는 바로 리턴하고 남은 재귀함수 이어서 진행
        if(depth == n) {
            if(sum == s) {
                result++;
            }
            return;
        }
        solution(depth+1, sum);     //해당 깊이의 데이터를 더하지 않음
        solution(depth+1, sum + array[depth]);  //해당 깊이의 데이터를 더함
    }

    public static void main(String[] args) throws IOException {
        input();
        solution(0, 0);
        if(s == 0) {
            System.out.println(result-1);
        }else {
            System.out.println(result);
        }
    }
}
