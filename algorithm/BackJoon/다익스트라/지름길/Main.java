import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static int n, d;    //지름길의 개수, 가야하는 총 길이
    private static int[] distance = new int[10001];
    private static ArrayList<ArrayList<ShortCut>> graph = new ArrayList<ArrayList<ShortCut>>();
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        d = Integer.parseInt(stringTokenizer.nextToken());

        for(int i = 0; i < distance.length; i++) {
            distance[i] = i;
            graph.add(new ArrayList<ShortCut>());
        }

        for(int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());
            graph.get(a).add(new ShortCut(b, c));
        }
    }

    private static void solution(int start) {
        if(start >= d) {
            return;
        }
        distance[start+1] = Math.min(distance[start+1], distance[start] + 1);
        for(int i = 0; i < graph.get(start).size(); i++) {
            int cost = distance[start] + graph.get(start).get(i).getDistance();
            if(cost < distance[graph.get(start).get(i).getEndPoint()]) {
                distance[graph.get(start).get(i).getEndPoint()] = cost;
            }
        }
        solution(start+1);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution(0);
        stringBuilder.append(distance[d]);
        System.out.println(stringBuilder);
    }
}

class ShortCut implements Comparable<ShortCut> {

    private int endPoint;
    private int distance;

    public ShortCut(int index, int distance) {
        this.endPoint = index;
        this.distance = distance;
    }

    public int getEndPoint() {
        return endPoint;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(ShortCut other) {
        return Integer.compare(distance, other.distance);
    }
}
