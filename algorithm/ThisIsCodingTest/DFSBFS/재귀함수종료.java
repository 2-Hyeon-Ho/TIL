public class 재귀함수종료 {

    private static void recursive(int i) {
        if(i == 100) {
            return;
        }
        System.out.println(i + "번 째 재귀 함수에서 " + (i+1) + "번 째 재귀 함수를 호출합니다.");
        recursive(i + 1);
        System.out.println(i + "번 째 재귀 함수를 종료합니다.");
    }

    public static void main(String[] args) {
        recursive(1);
    }

}