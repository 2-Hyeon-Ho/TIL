import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n, k;
    private static int result;
    private static boolean[] visited;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());
        result = Integer.MAX_VALUE;
        visited = new boolean[100001];
    }

    private static void solution() {
        if(n > k) {
            stringBuilder.append(n-k);
        }else {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(new Node(n, 0));
            visited[n] = true;
            while(!queue.isEmpty()) {
                Node now = queue.poll();
                if(now.getIndex() == k) {
                    result = Math.min(result, now.getTime());
                    break;
                }

                int previous = now.getIndex() - 1;
                if(previous >= 0 && !visited[previous]) {
                    queue.offer(new Node(previous, now.getTime()+1));
                    visited[previous] = true;
                }

                int next = now.getIndex() + 1;
                if(next < visited.length && !visited[next]) {
                    queue.offer(new Node(next, now.getTime()+1));
                    visited[next] = true;
                }

                int twoTime = now.getIndex() * 2;
                if(twoTime < visited.length && !visited[twoTime]) {
                    queue.offer(new Node(twoTime, now.getTime()+1));
                    visited[twoTime] = true;
                }
            }

            stringBuilder.append(result);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(stringBuilder);
    }
}

class Node {
    private int index;
    private int time;

    public Node(int index, int time) {
        this.index = index;
        this.time = time;
    }
    public int getIndex() {
        return this.index;
    }
    public int getTime() {
        return this.time;
    }
}
