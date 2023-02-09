import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 순차탐색 {

    private static int n;
    private static String target;
    private static String[] array;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        System.out.println("생성할 원소 개수를 입력한 다음 한 칸 띄고 찾을 문자열을 입력하세요.");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        target = stringTokenizer.nextToken();

        System.out.println("앞서 적은 원소 개수만큼 문자열을 입력하세요. 구분은 띄어쓰기 한 칸으로 합니다.");
        array = new String[n];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < n; i++) {
            array[i] = stringTokenizer.nextToken();
        }
    }

    private static void sequentialSearch(String[] array) {
        for(int i = 0; i < array.length; i++) {
            if(array[i].equals(target)) {
                stringBuilder.append(i+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        sequentialSearch(array);
        System.out.println(stringBuilder);
    }
}
