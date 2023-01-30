import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    private static boolean[] visited = new boolean[1001];

    private static void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");
        for(int i = 0; i < graph.get(start).size(); i++) {
            Integer node = graph.get(start).get(i);
            if(!visited[node]) {
                dfs(node);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        System.out.print(start + " ");
        while (!queue.isEmpty()) {
            Integer x = queue.poll();
            for(int i = 0; i < graph.get(x).size(); i++) {
                Integer y = graph.get(x).get(i);
                if(!visited[y]) {
                    queue.offer(y);
                    visited[y] = true;
                    System.out.print(y + " ");
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();  //정점의 개수
        int M = scanner.nextInt();  //간선의 개수
        int start = scanner.nextInt();  //시작 지점

        for(int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            int node1 = scanner.nextInt();
            int node2 = scanner.nextInt();
            if(node1 > node2) {
                node2 = swap(node1, node1 = node2);
            }
            list1.add(node1);
            list2.add(node2);
        }
        for(int i = 0; i < list1.size(); i++) {
            graph.get(list1.get(i)).add(list2.get(i));
            graph.get(list2.get(i)).add(list1.get(i));
        }
        for(int i = 0; i < N+1; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(start);
        Arrays.fill(visited, false);
        System.out.println();
        bfs(start);
    }

    private static int swap(int a, int b) {
        return a;
    }
}