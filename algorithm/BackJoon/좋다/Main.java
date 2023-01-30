import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] array = new int[a];

        for(int i = 0; i < a; i++) {
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);

        int cnt = 0;
        for(int k = 0; k < array.length; k++) {
            int find = array[k];
            int j = array.length-1;
            int i = 0;

            while(i < array.length && j > 0 && a != 2) {
                if(array[i] + array[j] == find && i != j) {
                    if(i == k) {
                        i++;
                    }else if(j == k) {
                        j--;
                    }else {
                        cnt++;
                        break;
                    }
                }else if(array[i] + array[j] > find) {
                    j--;
                }else {
                    i++;
                }
            }
        }
        System.out.println(cnt);
    }
}
