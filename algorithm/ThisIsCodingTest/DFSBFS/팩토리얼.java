public class 팩토리얼 {
    private static int iterativeFactorial(int n) {
        int result = 1;
        for(int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private static int recursiveFactorial(int n) {
        if(n <= 1) {
            return 1;
        }
        return n * recursiveFactorial(n-1);
    }

    public static void main(String[] args) {
        System.out.println("반복으로 구현 : " + iterativeFactorial(5));

        //재귀적으로 구현할 때는 점화식을 소스코드로 옮겨야 한다.
        //1. n이 0혹은 1일 때 factorial(n) = 1
        //2. n이 1보다 클 때 factorial(n) = n x factorial(n-1)
        System.out.println("재귀적으로 구현 : " + recursiveFactorial(5));
    }

}