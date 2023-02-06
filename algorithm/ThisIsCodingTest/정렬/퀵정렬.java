public class 퀵정렬 {

    private static int swap(int a, int b) {
        return a;
    }

    private static void sort(int[] array, int start, int end) {
        //원소가 1개인 경우 종료?
        if(start >= end) return;
        int pivot = start;
        int left = start+1;
        int right = end;
        while (left <= right) {
            //pivot 보다 큰 값을 만날 때까지 left 인덱스를 하나씩 증가하며 확인
            //left <= end를 먼저 비교하고 array[pivot] >= array[left]를 나중에 비교해야 제일 마지막에
            //left++를 통해서 left값이 배열의 범위 보다 큰값을 갖는다. 이때 배열을 먼저 비교하면 ArrayIndexOutOfBoundsException가
            //발생할 수 있으므로 left <= end를 먼저 비교해서 while문을 탈출한다.
            while (left <= end && array[pivot] >= array[left]) {
                left++;
            }
            //pivot 보다 작은 값을 만날 때까지 right 인덱스를 하나씩 감소하며 확인
            while (array[pivot] <= array[right] && right > start) {
                right--;
            }
            if(left > right) {
                array[pivot] = swap(array[right], array[right] = array[pivot]);
            }else {
                array[left] = swap(array[right], array[right] = array[left]);
            }
        }
        //left 인덱스가 right 인덱스 보다 커지면 while문을 탈출하고 분할이 일어났기 때문에 왼쪽과 오른쪽 각각 정렬 수행
        sort(array, start, right-1);
        sort(array, right+1, end);
    }

    private static void print(int[] array) {
        for(int i = 0; i <array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        print(array);
        sort(array, 0, array.length-1);
        print(array);
    }
}
