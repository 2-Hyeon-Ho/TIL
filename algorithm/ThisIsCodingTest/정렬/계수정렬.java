public class 계수정렬 {

    //계수정렬은 보통 특정한 조건에 부합할 때 사용하는 정렬방법으로 가장 큰 데이터와 가장 작은 데이터의 차이가 작을
    //경우 주로 사용한다. 그러므로 가장 큰 데이터 값을 보통 제한하고 있으므로 최대치를 선언한다.
    private static final int MAX_VALUE = 9;
    private static int[] count;
    private static int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};


    private static void sort(int[] array) {
        count = new int[MAX_VALUE+1];

        for(int value : array) {
            count[value]++;     //배열값의 해당되는 인덱스 카운트 하나씩 증가
        }
    }

    private static void print(int[] count) {
        for(int i = 0; i < count.length; i++) {
            for(int j = 0; j < count[i]; j++) {     //배열값을 카운트한 만큼 출력하기
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        sort(array);
        print(count);
    }
}
