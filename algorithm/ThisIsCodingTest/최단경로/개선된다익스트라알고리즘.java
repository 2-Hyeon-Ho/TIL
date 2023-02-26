import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 개선된다익스트라알고리즘 {

    private static int n, m;    //노드, 간선의 갯수
    private static int start;   //시작 노드
    private static ArrayList<ArrayList<Node2>> graph = new ArrayList<ArrayList<Node2>>();
    private static int[] distance;
    private static StringBuilder stringBuilder = new StringBuilder();
    private static int INFINITY = (int) 1e9;

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        distance = new int[n+1];

        Arrays.fill(distance, INFINITY);

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        start = Integer.parseInt(stringTokenizer.nextToken());

        //노드개수 +1 크기로 그래프 초기화
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node2>());
        }

        for(int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());
            //a번 노드에서 b번 노드 까지의 거리가 c이다.
            graph.get(a).add(new Node2(b, c));
        }
    }

    private static void solution() {
        PriorityQueue<Node2> priorityQueue = new PriorityQueue<>();
        // 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
        priorityQueue.add(new Node2(start, 0));
        distance[start] = 0;

        while(!priorityQueue.isEmpty()) {
            // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            Node2 node = priorityQueue.poll();
            int now = node.getIndex();
            int nowDistance = node.getDistance();
            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if(distance[now] < nowDistance) continue;
            //현재노드와 연결된 노드들을 확인
            for(int i = 0; i < graph.get(now).size(); i++) {
                int cost = distance[now] + graph.get(now).get(i).getDistance();
                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                if(cost < distance[graph.get(now).get(i).getIndex()]) {
                    distance[graph.get(now).get(i).getIndex()] = cost;
                    priorityQueue.offer(new Node2(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            if(distance[i] == INFINITY) {
                stringBuilder.append("infinity").append("\n");
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

class Node2 implements Comparable<Node2> {

    private int index;
    private int distance;

    public Node2(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    //거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Node2 other) {
        if(this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}
