import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 투포인터 {

    private static int n, k;
    private static int[] array;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());
        array = new int[n+1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    private static void solution() {
        int sum = 0;    //연속된 k구간 까지의 합을 저장하기 위한 변수 선언 및 초기화
        //첫번째 인덱스부터 연속된 k구간 까지의 초기 합을 저장한다.
        for(int i = 1; i <= k; i++) {
            sum += array[i];
        }

        //여기서 result를 sum으로 초기화 해야 n과 k의 값이 같을 경우 올바른 result가 출력된다.
        //만약 result = -무한으로 초기화 한다면 n과 k의 값이 같다면 end = k+1을 통해 아래의 for문을 실행하지 못하고
        //result를 출력하기 때문에 -무한이 출력되고 틀리게 된다.
        int result = sum;
        for(int start = 1, end = k+1; end <= n; start++, end++) {
            //투포인터방식으로 시작점과 끝나는 지점을 지정해준다.
            //구간합에 시작지점을 빼고 끝나는 지점+1을 더해줌으로써 한칸 이동한 구간합을 구할 수 있다.
            sum += (array[end] - array[start]);
            result = Math.max(result, sum);
        }
        stringBuilder.append(result);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(stringBuilder);
    }
}
