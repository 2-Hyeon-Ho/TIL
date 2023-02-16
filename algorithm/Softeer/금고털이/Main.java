import java.util.*;
import java.io.*;


public class Main {

    private static int w, n, result;
    private static int[][] array;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        w = Integer.parseInt(stringTokenizer.nextToken());
        n = Integer.parseInt(stringTokenizer.nextToken());

        array = new int[n][2];
        for(int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < 2; j++) {
                array[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
    }

    private static void solution() {
        //2차원 배열을 위한 Comparator 익명 클래스 선언과 compare메서드 재정의
        Arrays.sort(array, new Comparator<int[]>() {
            //무게당 가격에 대한 내림차순을 진행하기 위해 o2[1] - o1[1]을 진행함
            //o1 - o2 => 오름차순,  o2 - o1 => 내림차순
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        //정렬된 광물 순서대로 계산 진행
        for(int i = 0; i < n; i++) {
            //남아있는 가방의 무게가 광물의 무게보다 클 경우
            if(w > array[i][0]) {
                result += array[i][0] * array[i][1];    //광물의 가격만큼 광물의 무게를 곱하고 결과에 더한다.
                w -= array[i][0];                       //광물을 넣은 만큼 남은 가방의 무게를 줄인다.
                //남아있는 가방의 무게가 광물의 무게보다 작거나 같을 경우
            }else {
                result += array[i][1] * w;              //광물의 가격만큼 가방의 무게를 곱하고 결과에 더한다.
                stringBuilder.append(result);           //가방이 다 찼으므로 결과를 저장하고 리턴한다.
                return;
            }
        }
    }

    public static void main(String args[]) throws IOException {
        input();
        solution();
        System.out.println(stringBuilder);
    }
}