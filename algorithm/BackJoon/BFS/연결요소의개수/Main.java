import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n, m, result;
    private static boolean[] visited;
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[n+1];
        for(int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
    }

    private static void solution(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visited[i] = true;
        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int j = 0; j < graph.get(now).size(); j++) {
                int connected = graph.get(now).get(j);
                if(!visited[connected]) {
                    queue.offer(connected);
                    visited[connected] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                solution(i);
                result++;
            }
        }
        System.out.println(result);
    }
}

