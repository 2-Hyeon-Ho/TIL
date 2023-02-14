import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    private static int testCase, node;
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    private static StringBuilder stringBuilder = new StringBuilder();
    private static Scanner scanner = new Scanner(System.in);

    //    private static void input() throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//
//        testCase = Integer.parseInt(stringTokenizer.nextToken());
//        node = Integer.parseInt(stringTokenizer.nextToken());
//
//        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//        for (int i = 0; i < 200; i++) {
//            graph.add(new ArrayList<Integer>());
//        }
//        for (int i = 0; i < node; i++) {
//            int from = Integer.parseInt(stringTokenizer.nextToken());
//            int to = Integer.parseInt(stringTokenizer.nextToken());
//
//            graph.get(from).add(to);
//        }
//    }
    private static void input() {
        graph = new ArrayList<ArrayList<Integer>>();
        testCase = scanner.nextInt();
        node = scanner.nextInt();

        for (int j = 0; j < 200; j++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int j = 0; j < node; j++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();

            graph.get(from).add(to);
        }
    }

    private static int solution(int start) {
        for (int i = 0; i < graph.get(start).size(); i++) {
            Integer destination = graph.get(start).get(i);
            if (destination == 99) {
                stringBuilder.append(1);
                break;
            }
            solution(destination);
        }

        if (stringBuilder.length() != 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            stringBuilder = new StringBuilder();
            input();
            System.out.println("#" + (i + 1) + " " + solution(0));
        }
    }
}
