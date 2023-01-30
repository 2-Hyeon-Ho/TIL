import java.io.IOException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner sc =  new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int[] array = new int[a];
        int[] number = new int[a+1];
        for(int i = 0; i < a; i++) {
            array[i]=sc.nextInt();
        }
        number[0] = 0;
        for(int i = 1; i < a+1; i++) {
            number[i] = number[i-1] + array[i-1];
        }
        for(int i = 0; i < b; i++) {
            int c = sc.nextInt();
            int d = sc.nextInt();
            System.out.println(number[d]-number[c-1]);
        }
    }
}