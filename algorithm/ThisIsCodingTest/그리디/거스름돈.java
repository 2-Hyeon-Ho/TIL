public class 거스름돈 {

    public static void main(String[] args) {
        int n = 1260;   //거스름돈
        int count = 0;

        int[] coinType = {500, 100, 50, 10};

        for (int i : coinType) {
            count += n / i;
            n %= i;
        }

        System.out.println(count);
    }

}