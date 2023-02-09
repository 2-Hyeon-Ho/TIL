import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class 집합을이용한부품찾기 {

    private static int n, m;
    private static Set<Integer> parts;
    private static int[] demand;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        parts = new HashSet<>(n);

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            parts.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        m = Integer.parseInt(stringTokenizer.nextToken());
        demand = new int[m];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < m; i++) {
            demand[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    private static void solution() {
        for(int i = 0; i < m; i++) {
            if(parts.contains(demand[i])) {
                stringBuilder.append("yes").append(' ');
            }else {
                stringBuilder.append("no").append(' ');
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(stringBuilder);
    }
}