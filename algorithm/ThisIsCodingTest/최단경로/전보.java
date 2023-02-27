import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 전보 {

    private static int n, m, c;     //도시의 개수, 통로의 개수, 출발도시
    private static ArrayList<ArrayList<City>> graph = new ArrayList<ArrayList<City>>();
    private static int[] distance;
    private static StringBuilder stringBuilder = new StringBuilder();
    private static final int INFINITY = (int) 1e9;

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        c = Integer.parseInt(stringTokenizer.nextToken());

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<City>());
        }
        distance = new int[n+1];
        Arrays.fill(distance, INFINITY);

        for(int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());
            graph.get(a).add(new City(b, c));
        }
    }

    private static void solution() {
        int totalCount = 0;
        int totalTime = 0;
        PriorityQueue<City> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new City(c, 0));
        distance[c] = 0;

        while(!priorityQueue.isEmpty()) {
            City city = priorityQueue.poll();
            int now = city.getNumber();
            int time = city.getTime();
            if(distance[now] < time) continue;
            for(int i = 0; i < graph.get(now).size(); i++) {
                int cost = distance[now] + graph.get(now).get(i).getTime();
                if(cost < distance[graph.get(now).get(i).getNumber()]) {
                    distance[graph.get(now).get(i).getNumber()] = cost;
                    priorityQueue.add(new City(graph.get(now).get(i).getNumber(), cost));
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            if(distance[i] != INFINITY && distance[i] != 0) {
                totalCount++;
            }
            if(distance[i] != INFINITY && distance[i] > totalTime) {
                totalTime = distance[i];
            }
        }
        stringBuilder.append(totalCount).append(' ').append(totalTime);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(stringBuilder);
    }
}

class City implements Comparable<City> {

    private int number;
    private int time;

    public City(int number, int time) {
        this.number = number;
        this.time = time;
    }

    public int getNumber() {
        return number;
    }

    public int getTime() {
        return time;
    }

    @Override
    public int compareTo(City other) {
        if(this.time < other.time) {
            return -1;
        }
        return 1;
    }
}
