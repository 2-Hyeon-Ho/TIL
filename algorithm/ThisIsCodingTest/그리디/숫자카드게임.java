import java.util.Scanner;

public class 숫자카드게임 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //N x M 배열을 만들고 행내에서 최솟값이면서 그중에서 가장 큰 수를 뽑아내는 문제
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int result = 0;

        //아래와 같은 작업이 필요없이 입력받음과 동시에 최솟값을 추출하고
        //그중에서 최댓값을 뽑아오는 작업이 효율적임
//        int[][] array = new int[N][M];
//        for(int i = 0; i < N; i++) {
//            for(int j = 0; j < M; j++) {
//                array[i][j] = scanner.nextInt();
//            }
//        }
//        int[] minArray = new int[N];
//        for(int i = 0; i < N; i++) {
//            int min = 10000;
//            for(int j = 0; j < M; j++) {
//                if(array[i][j] < min) {
//                    min = array[i][j];
//                }
//            }
//            minArray[i] = min;
//        }
//        Arrays.sort(minArray);
//        System.out.println(minArray[N-1]);

        for(int i = 0; i < N; i++) {
            int min = 10001;
            for(int j = 0; j < M; j++) {
                min = Math.min(scanner.nextInt(), min);
            }
            result = Math.max(min, result);
        }

        System.out.println(result);
    }

}