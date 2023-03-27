import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static boolean[] visited;
    private static int[] result;
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        visited = new boolean[n+1];
        result = new int[n+1];

        for(int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
    }

    private static void solution(int node) {
        visited[node] = true;
        for(int i = 0; i < graph.get(node).size(); i++) {
            int num = graph.get(node).get(i);
            if(!visited[num]) {
                result[num] = node;
                solution(num);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solution(1);
        for(int i = 2; i <= n; i++) {
            stringBuilder.append(result[i]).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
