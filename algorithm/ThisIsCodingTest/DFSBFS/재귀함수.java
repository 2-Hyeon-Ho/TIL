public class 재귀함수 {
    private static void recursive() {
        System.out.println("재귀함수를 호출합니다.");
        recursive();
    }

    public static void main(String[] args) {
        recursive();
    }

}