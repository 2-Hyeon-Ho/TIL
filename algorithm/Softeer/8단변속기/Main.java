import java.util.*;
import java.io.*;


public class Main
{
    private static int[] gear = new int[8];
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for(int i = 0; i < gear.length; i++) {
            gear[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    private static void solution() {
        int count = 0;
        for(int i = 0; i < gear.length; i++) {
            if(gear[i] == i+1) {
                count++;
            }else if(gear[i] == 8-i) {
                count--;
            }
        }
        if(count == 8) {
            stringBuilder.append("ascending");
        }else if(count == -8) {
            stringBuilder.append("descending");
        }else {
            stringBuilder.append("mixed");
        }
    }
    public static void main(String args[]) throws IOException {
        input();
        solution();
        System.out.println(stringBuilder);
    }
}
