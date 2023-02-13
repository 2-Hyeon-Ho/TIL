import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 개미전사 {

    private static int n;
    private static int[] storage;
    private static int[] maxArray;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        storage = new int[n];
        maxArray = new int[n];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < n; i++) {
            storage[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    private static void solution() {
        maxArray[0] = storage[0];
        //ex) 3 1 1 5 로 식량창고가 채워져 있을 경우
        // 0번째 인덱스 + 3번째 인덱스가 1번째 인덱스 + 3번째 인덱스 보다 크다.
        // 이럴 경우 두칸을 건너띄고 더하는게 더 큰 수를 얻을 수 있다.
        // 이럴때를 위해 1번째 인덱스에는 0번째 인덱스와 1번째 인덱스중 더 큰 값을 저장한다.
        maxArray[1] = Math.max(storage[0], storage[1]);
        for(int i = 2; i < n; i++) {
            //2번째 인덱스 부터는 바로 전의 인덱스를 선택할 경우 현재의 저장소 인덱스는 더할 수 없으므로
            //전의 최댓값 인덱스와 전전의 최댓값 인덱스 + 현재 저장소 인덱스 중 더 큰값을 저장해 나간다.
            //결국 제일 마지막 인덱스에는 얻을 수 있는 최대의 값이 저장된다.
            maxArray[i] = Math.max(maxArray[i-1], maxArray[i-2] + storage[i]);
        }
        stringBuilder.append(maxArray[n-1]);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(stringBuilder);
    }
}