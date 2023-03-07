import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int n, k;    //본인 위치, 동생 위치(시작점, 끝점)
    private static int[] time;
    private static StringBuilder stringBuilder = new StringBuilder();
    private static final int INFINITY = (int) 1e9;

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());

        int temp = Math.max(n, k);
        time = new int[temp * 2];
        Arrays.fill(time, INFINITY);
    }

    private static void solution() {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>();
        priorityQueue.add(new Node(n, 0));
        time[n] = 0;

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            int now = node.getIndex();
            int nowDistance = node.getDistance();
            if (time[now] < nowDistance) {
                continue;
            }
            if(now == k) {
                break;
            }
            int point1 = now - 1;
            if(isValid(point1) && time[point1] > nowDistance+1) {
                time[point1] = nowDistance+1;
                priorityQueue.add(new Node(point1, time[point1]));
            }

            int point2 = now + 1;
            if(isValid(point2) && time[point2] > nowDistance+1) {
                time[point2] = nowDistance+1;
                priorityQueue.add(new Node(point2, time[point2]));
            }

            int point3 = now * 2;
            if(isValid(point3) && time[point3] > nowDistance) {
                time[point3] = nowDistance;
                priorityQueue.add(new Node(point3, time[point3]));
            }
        }

        stringBuilder.append(time[k]);
    }

    private static boolean isValid(int point) {
        if(point >= 0 && point < time.length) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(stringBuilder);
    }
}

class Node implements Comparable<Node> {

    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public int compareTo(Node other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}
