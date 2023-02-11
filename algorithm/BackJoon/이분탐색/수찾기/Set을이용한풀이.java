import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Set을이용한풀이 {
    private static int n, m;
    private static Set<Integer> set;
    private static int[] array1;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        set = new HashSet<>(n);

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < n; i++) {
            set.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        m = Integer.parseInt(stringTokenizer.nextToken());
        array1 = new int[m];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < m; i++) {
            array1[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    private static void solution() {
        for(int i = 0; i < m; i++) {
            if(set.contains(array1[i])) {
                stringBuilder.append("1\n");
            }else {
                stringBuilder.append("0\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(stringBuilder);
    }
}
