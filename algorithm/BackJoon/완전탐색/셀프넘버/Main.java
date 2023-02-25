public class Main {

    private static boolean[] array;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void solution() {
        array = new boolean[10001];
        for(int i = 1; i < 10000; i++) {
            int sum = i;
            int num = i;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            if(sum < 10001) {
                array[sum] = true;
            }
        }
        for(int i = 1; i < 10001; i++) {
            if(!array[i]) {
                stringBuilder.append(i).append("\n");
            }
        }
    }

    public static void main(String[] args) {
        solution();
        System.out.println(stringBuilder);
    }
}
