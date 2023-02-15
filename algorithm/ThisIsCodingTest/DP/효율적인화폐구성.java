import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 효율적인화폐구성 {

    private static int n, m;
    private static int[] coin;  //화폐단위 배열
    private static int[] array; //DP를 이용한 최소의 화폐구성 배열
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        coin = new int[n];
        array = new int[m+1];   //원하는 가격까지 최소의 화폐구성을 저장해야 하므로 m+1 크기배열 생성
        for(int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            coin[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    private static void solution() {
        //최대 가격이 10_000원 이므로 최대 화폐구성은 1원으로 10_000원을 채우는것이기 때문에
        //10_001을 배열에 채워준다.
        Arrays.fill(array, 10001);
        //0원을 만들 수 있는 구성은 0
        array[0] = 0;
        for(int i = 0; i < n; i++) {
            for(int j = coin[i]; j <= m; j++) {
                //(j - coin[i](모든 화폐들을 차례대로))가 10_001이 아니라면
                //화폐로 만들 수 있는 경우 이므로 array[j-coin[i]] + 1로 나타낼 수 있다.
                //이때 array[j]와 array[j - coin[i]] + 1 중 더 적은 값을 저장해둔다.
                if(array[j - coin[i]] != 10001) {
                    array[j] = Math.min(array[j], array[j - coin[i]] + 1);
                }
            }
        }
        if(array[m] == 10001) { //주어진 화폐로 구성할 수 없는 경우
            stringBuilder.append(-1);
        }else {
            stringBuilder.append(array[m]);
        }

    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(stringBuilder);
    }
}
