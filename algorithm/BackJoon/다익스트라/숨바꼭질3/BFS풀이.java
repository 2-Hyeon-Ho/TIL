import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS풀이 {

    private static int n, k;    //본인 위치, 동생 위치(시작점, 끝점)
    private static int result;
    private static boolean[] visited;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[100001];
        result = Integer.MAX_VALUE;
    }

    private static void solution() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(n, 0));
        visited[n] = true;

        while(!queue.isEmpty()) {
            Point point = queue.poll();
            if(point.getIndex() == k) {
                result = Math.min(result, point.getTime());
            }

            int twoTime = point.getIndex() * 2;
            if(isValid(twoTime) && !visited[twoTime]) {
                visited[twoTime] = true;
                queue.offer(new Point(twoTime, point.getTime()));
            }

            int previous = point.getIndex() - 1;
            if(isValid(previous) && !visited[previous]) {
                visited[previous] = true;
                queue.offer(new Point(previous, point.getTime()+1));
            }

            int next = point.getIndex() + 1;
            if(isValid(next) && !visited[next]) {
                visited[next] = true;
                queue.offer(new Point(next, point.getTime()+1));
            }
        }

        stringBuilder.append(result);
    }

    private static boolean isValid(int index) {
        return index >= 0 && index < visited.length;
    }

    public static void main(String[] args) throws IOException {
        input();
        if(n >= k) {
            stringBuilder.append(n-k);
        }else {
            solution();
        }
        System.out.println(stringBuilder);
    }
}

class Point {

    private int index;
    private int time;

    public Point(int index, int time) {
        this.index = index;
        this.time = time;
    }

    public int getIndex() {
        return index;
    }

    public int getTime() {
        return time;
    }
}
