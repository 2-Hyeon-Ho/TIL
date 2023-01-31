import java.util.Arrays;
import java.util.Scanner;

public class 큰수의법칙 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   //배열의 크기
        int M = sc.nextInt();   //더하는 횟수
        int K = sc.nextInt();   //최대 연속 횟수
        int[] array = new int[N];
        for(int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        int result = 0;
        int first = array[N-1];
        int second = array[N-2];

        int cnt = M / (K + 1) * K;  // M / (K + 1)이 나눠떨어질 경우 가장 큰수가 더해지는 횟수
        cnt += M % (K + 1);     // M / (K  + 1)로 나눠떨어지지 않을 경우 가장 큰수를 추가로 더해주는 횟수

        result = first * cnt + second * (M - cnt);
        System.out.println(result);
    }

}
