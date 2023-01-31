import java.util.Scanner;

public class 왕실의나이트 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] xRoutes = {-2, -2, 2, 2, -1, -1, 1, 1};
        int[] yRoutes = {-1, 1, -1, 1, -2, 2, -2, 2};

        String input = scanner.next();
        int column = input.charAt(0) - 'a' + 1; //알파벳을 정수로 변환
        int row = input.charAt(1) - '0';        //문자로 입력된 숫자를 정수로 변환

        int result = 0;

        for(int i = 0; i < 8; i++) {
            int nextRow = row + xRoutes[i];
            int nextColumn = column + yRoutes[i];
            if(nextRow > 0 && nextColumn > 0 && nextRow < 9 && nextColumn < 9) {
                result ++;
            }
        }
        System.out.println(result);
    }

}