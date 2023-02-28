import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int v, e;    //정점의 개수, 간선의 개수
    private static int k;       //시작노드의 번호
    private static int[] distance;
    private static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    private static StringBuilder stringBuilder = new StringBuilder();
    private static final int INFINITY = (int) 1e9;

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        v = Integer.parseInt(stringTokenizer.nextToken());
        e = Integer.parseInt(stringTokenizer.nextToken());

        distance = new int[v+1];
        Arrays.fill(distance, INFINITY);
        for(int i = 0; i <= v; i++) {
            graph.add(new ArrayList<Node>());
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        k = Integer.parseInt(stringTokenizer.nextToken());

        for(int i = 0; i < e; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());
            graph.get(a).add(new Node(b, c));
        }
    }

    private static void solution() {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>();
        priorityQueue.add(new Node(k, 0));
        distance[k] = 0;

        while(!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            int now = node.getIndex();
            int nowDistance = node.getDistance();
            if(distance[now] < nowDistance) continue;
            for(int i = 0; i < graph.get(now).size(); i++) {
                int cost = distance[now] + graph.get(now).get(i).getDistance();
                if(cost < distance[graph.get(now).get(i).getIndex()]) {
                    distance[graph.get(now).get(i).getIndex()] = cost;
                    priorityQueue.add(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }

        for(int i = 1; i <= v; i++) {
            if(distance[i] == INFINITY) {
                stringBuilder.append("INF").append("\n");
            }else {
                stringBuilder.append(distance[i]).append("\n");
            }
        }
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
        //거리가 작을 수록 우선순위를 가지도록 설정
        return Integer.compare(distance, other.distance);
    }
}
