import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int n, m;    //도시의 개수, 버스의 개수
    private static int[] distance;
    private static ArrayList<ArrayList<City>> graph = new ArrayList<ArrayList<City>>();
    private static int start, end;
    private static StringBuilder stringBuilder = new StringBuilder();
    private static final int INFINITY = (int) 1e9;

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        m = Integer.parseInt(stringTokenizer.nextToken());

        distance = new int[n+1];
        Arrays.fill(distance, INFINITY);

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());

            graph.get(a).add(new City(b, c));
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        start = Integer.parseInt(stringTokenizer.nextToken());
        end = Integer.parseInt(stringTokenizer.nextToken());
    }

    private static void solution() {
        PriorityQueue<City> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new City(start, 0));
        distance[start] = 0;

        while(!priorityQueue.isEmpty()) {
            City city = priorityQueue.poll();
            int now = city.getNumber();
            int nowCharge = city.getCharge();
            if(distance[now] < nowCharge) continue;
            if(now == end) break;

            for(int i = 0; i < graph.get(now).size(); i++) {
                int cost = distance[now] + graph.get(now).get(i).getCharge();
                if(cost < distance[graph.get(now).get(i).getNumber()]) {
                    distance[graph.get(now).get(i).getNumber()] = cost;
                    priorityQueue.add(new City(graph.get(now).get(i).getNumber(), cost));
                }
            }
        }

        stringBuilder.append(distance[end]);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(stringBuilder);
    }
}

class City implements Comparable<City> {

    private int number;
    private int charge;

    public City(int number, int charge) {
        this.number = number;
        this.charge = charge;
    }

    public int getNumber() {
        return this.number;
    }

    public int getCharge() {
        return this.charge;
    }

    @Override
    public int compareTo(City other) {
        if(this.charge < other.charge) {
            return -1;
        }
        return 1;
    }
}
