import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일로만들기 {

    private static int x;
    private static int[] array;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        x = Integer.parseInt(bufferedReader.readLine());

        array = new int[x+1];
    }

    private static void solution() {
        for (int i = 2; i <= x; i++) {
            //현재의 수에서 1을 뺀 연산을 한번한다.
            //1을 뺀 연산을 했기 때문에 횟수가 하나 증가해야 한다.
            //배열에 저장된 이전의 값은 1로 만든 최소 횟수이므로 이전의 값에 +1을 저장한다.
            array[i] = array[i - 1] + 1;
            //현재의 수가 2로 나누어 떨어지는 경우
            //1을 뺀 연산을 한 결과와 2로 나눈 배열의 인덱스에 +1한 값을 비교해서 더 작은 값을 저장한다.
            //ex) 8이라면 7에 저장되어 있는 값에 +1한 값과 4에 저장되어 있는 값에 +1한 값중 적은 값을 저장한다.
            //=> 8에서 7로 가는 연산횟수와 8에서 4로 가는 연산 횟수는 같기 때문에 더 적은 연산횟수에 +1한 값을 저장하는 것이다.
            if (i % 2 == 0)
                array[i] = Math.min(array[i], array[i / 2] + 1);
            // 현재의 수가 3으로 나누어 떨어지는 경우
            if (i % 3 == 0)
                array[i] = Math.min(array[i], array[i / 3] + 1);
            // 현재의 수가 5로 나누어 떨어지는 경우
            if (i % 5 == 0)
                array[i] = Math.min(array[i], array[i / 5] + 1);
        }
        stringBuilder.append(array[x]);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(stringBuilder);
    }
}
