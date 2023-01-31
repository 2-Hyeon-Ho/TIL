import java.util.Scanner;

public class 시각 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();


            /*
            직접 작성한 시간복잡도가 더 우수하지만
            시간은 정해져있어서 그렇지만 사람이 직접 구할 수 없는 수 일경우에느
            완전 탐색방법으로 구현해야한다.
             */
//        final int notIncludeThreeHour = 1575;
//        final int subCount = 2025;
//
//        int result = 0;
//        result += (N+1) * notIncludeThreeHour;
//        if(N == 23) {
//            result += subCount * 3;
//            System.out.println(result);
//        }else if(N >= 13) {
//            result += subCount * 2;
//            System.out.println(result);
//        }else if(N >= 3) {
//            result += subCount;
//            System.out.println(result);
//        }else {
//            System.out.println(result);
//        }

        //완전 탐색으로 모든 시간을 비교하는 방법
        long start = System.currentTimeMillis();
        int result = 0;
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    if (check(i, j, k)) {
                        result++;
                    }
                }
            }
        }
        System.out.println(result);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static boolean check(int hour, int min, int sec) {
        if (hour % 10 == 3 || min / 10 == 3 || min % 10 == 3 || sec / 10 == 3 || sec % 10 == 3) {
            return true;
        }
        return false;
    }
}
