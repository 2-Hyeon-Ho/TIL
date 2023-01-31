import java.util.Scanner;

public class 일이될때까지 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //N이 1이 될때 까지 1,2번 중에 반복
        //1. N에서 1을 뺀다.
        //2. N을 K로 나눈다(나누어 떨어질 경우)
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int target = 0;
        int result = 0;

        while(N != 1) {
            if(N % K == 0) {
                N /= K;
                result++;
                continue;
            }
//            N--;          //이와 같은 방법은 N이 큰 수 일 경우 빼는 작업이 계속 반복되므로 비효율적일 수 있다.
//            result++;
            if(N < K) {
                break;
            }
            target = (N / K) * K;
            result += N - target;
            N = target;
        }
        result += (N-1);

        System.out.println(result);
    }

}