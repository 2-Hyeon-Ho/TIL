public class 선택정렬 {

    //시간복잡도는 O(N^2)
    private static int swap(int a, int b) {
        return a;
    }

    private static void sort(int[] array) {
        //제일 마지막의 숫자는 비교할 필요가 없이 무조건 제일 큰 수 이므로 length-1 까지만 반복한다.
        for(int i = 0; i < array.length-1; i++) {
            int minIndex = i;
            for(int j = i+1; j < array.length; j++) {
                if(array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            array[minIndex] = swap(array[i], array[i] = array[minIndex]);
        }
    }

    private static void print(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        sort(array);
        print(array);
    }
}
