import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 다익스트라 {

    private static int n, e;    //노드, 간선의 수
    private static int[] distance;
    private static boolean[] visited;
    private static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    private static int v1, v2;  //반드시 거쳐가야 할 노드 v1, v2
    private static StringBuilder stringBuilder = new StringBuilder();
    private static final int INFINITY = (int) 1e9;

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        e = Integer.parseInt(stringTokenizer.nextToken());

        distance = new int[n+1];
        Arrays.fill(distance, INFINITY);

        visited = new boolean[n+1];

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        v1 = Integer.parseInt(stringTokenizer.nextToken());
        v2 = Integer.parseInt(stringTokenizer.nextToken());
    }

    private static void solution() {
        if(e == 0) {
            stringBuilder.append(-1);
            return;
        }

        int answer1 = 0;
        answer1 += dijkstra(1, v1);
        answer1 += dijkstra(v1, v2);
        answer1 += dijkstra(v2, n);

        int answer2 = 0;
        answer2 += dijkstra(1, v2);
        answer2 += dijkstra(v2, v1);
        answer2 += dijkstra(v1, n);


        if(answer1 >= INFINITY && answer2 >= INFINITY) {
            stringBuilder.append(-1);
        }else {
            int result = Math.min(answer1, answer2);
            stringBuilder.append(result);
        }
    }

    private static int dijkstra(int start, int end) {
        if(start == end) {
            return 0;
        }
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        Arrays.fill(distance, INFINITY);
        Arrays.fill(visited, false);
        distance[start] = 0;
        priorityQueue.add(new Node(start, 0));

        while(!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            int now = node.getIndex();
            int nowDistance = node.getDistance();
            if(visited[now]) continue;
            visited[now] = true;
            for(int i = 0; i < graph.get(now).size(); i++) {
                int nextNode = graph.get(now).get(i).getIndex();
                int nextDistance = graph.get(now).get(i).getDistance();
                if(nowDistance + nextDistance < distance[nextNode] && !visited[nextNode]) {
                    distance[nextNode] = nowDistance + nextDistance;
                    priorityQueue.add(new Node(graph.get(now).get(i).getIndex(), distance[nextNode]));
                }
            }
        }

        return distance[end];
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
        return index;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Node other) {
        if(this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}
