import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 슬라이딩윈도우 {

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
        //만약 result = -무한으로 초기화 한다면 n과 k의 값이 같다면 i = k+1을 통해 아래의 while문을 실행하지 못하고
        //result를 출력하기 때문에 -무한이 출력되고 틀리게 된다.
        int result = sum;
        int i = k+1;    //첫번째 구간합은 초기에 구했기 때문에 그 다음 부터 구하면 되기 때문에 k+1부터 시작한다.
        while(i <= n) { //i가 마지막 인덱스까지만 반복하도록 한다.
            //구간합을 슬라이딩 윈도우방식으로 이동시키며 하나씩 구하는 방법이다.
            //구간합에 다음 인덱스의 배열값을 추가시키고 제일 앞에 있던 인덱스의 배열값을 빼줘서 구간합에 더하는 방식이다.
            sum += array[i] - array[i-k];
            result = Math.max(result, sum);
            i++;
        }
        stringBuilder.append(result);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(stringBuilder);
    }
}
