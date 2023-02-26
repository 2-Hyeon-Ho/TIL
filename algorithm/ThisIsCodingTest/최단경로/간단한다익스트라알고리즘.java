import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 간단한다익스트라알고리즘 {

    private static int n, m;    //노드, 간선의 갯수
    private static int start;   //시작 노드
    private static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    private static boolean[] visited;
    private static int[] distance;
    private static StringBuilder stringBuilder = new StringBuilder();
    private static int INFINITY = (int) 1e9;

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        visited = new boolean[n+1];
        distance = new int[n+1];

        Arrays.fill(distance, INFINITY);

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        start = Integer.parseInt(stringTokenizer.nextToken());

        //노드개수 +1 크기로 그래프 초기화
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        for(int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());
            //a번 노드에서 b번 노드 까지의 거리가 c이다.
            graph.get(a).add(new Node(b, c));
        }
    }

    private static void solution() {
        distance[start] = 0;
        visited[start] = true;

        for(int i = 0; i < graph.get(start).size(); i++) {
            distance[graph.get(start).get(i).getIndex()] = graph.get(start).get(i).getDistance();
        }

        //시작노드를 제외하고 반복한다.
        for(int i = 1; i <= n; i++) {
            //가장 가까운 노드로 이동하고 방문처리
            int now = getSmallestNode();
            visited[now] = true;
            //현재노드와 연결된 노드들을 확인색
            for(int j = 0; j < graph.get(now).size(); j++) {
                int smallestDistance = distance[now] + graph.get(now).get(j).getDistance();
                //기존에 저장된 거리보다 현재노드를 거쳐서 다른노드로 가는 거리가 더 짧을 경우 최단경로 저장
                if(smallestDistance < distance[graph.get(now).get(j).getIndex()]) {
                    distance[graph.get(now).get(j).getIndex()] = smallestDistance;
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

    private static int getSmallestNode() {
        int minDistance = INFINITY;
        int index = 0;  //가장 거리가 짧은 노드의 인덱스를 저장하기 위한 변수

        for(int i = 1; i <= n; i++) {
            if(distance[i] < minDistance && !visited[i]) {
                minDistance = distance[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(stringBuilder);
    }
}

class Node {

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
}
