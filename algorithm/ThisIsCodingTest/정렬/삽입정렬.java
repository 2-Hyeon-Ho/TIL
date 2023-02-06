public class 삽입정렬 {

    //삽입정렬의 시간복잡도는 O(N^2)이지만 현재 리스트의 데이터가 거의 정렬되어 있는 상태라면 매우 빠르게 동작한다.
    //최선의 시간 복잡도는 O(N)
    private static int swap(int a, int b) {
        return a;
    }

    private static void sort(int[] array) {
        //첫번째 원소는 정렬되어 있다고 생각하기 때문에 인덱스 1부터 반복한다.
        for(int i = 1; i < array.length; i++) {
            //j-1과 j를 비교하므로 j를 인덱스 1까지 줄어들면서 반복한다.
            for(int j = i; j > 0; j--) {
                if(array[j-1] > array[j]) {
                    array[j-1] = swap(array[j], array[j] = array[j-1]);
                }
            }
        }
    }

    private static void print(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        print(array);
        sort(array);
        print(array);
    }

}
