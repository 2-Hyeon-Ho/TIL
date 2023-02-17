import java.util.*;
import java.io.*;


public class Main {

    private static int n;
    private static int[] sum;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void solution() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        sum = new int[n];

        //3번의 시험을 시행함으로 3번의 반복문을 실행
        for(int i = 0; i < 3; i++) {
            //인덱스와 점수를 필드로 갖는 Pair객체를 점수 순서대로 우선순위 큐에 삽입
            PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < n; j++) {
                Pair pair = new Pair(j, Integer.parseInt(stringTokenizer.nextToken()));
                priorityQueue.offer(pair);
                //학생의 각 시험 점수를 총점에 더함
                sum[j] += pair.getScore();
            }
            int[] grades = getGrade(priorityQueue);

            for(int j = 0; j < n; j++) {
                stringBuilder.append(grades[j]).append(' ');
            }
            stringBuilder.append("\n");
        }

        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            priorityQueue.offer(new Pair(i, sum[i]));
        }
        int[] grades = getGrade(priorityQueue);

        for(int i = 0; i < n; i++) {
            stringBuilder.append(grades[i]).append(' ');
        }
    }

    //등수를 뽑아올 수 있는 메서드 작성
    private static int[] getGrade(PriorityQueue<Pair> priorityQueue) {
        int[] grades = new int[n];
        Pair first = priorityQueue.poll();  //첫번째 원소를 뽑아옴 => 점수가 가장 높은 원소
        int grade = 1;
        int preScore = first.getScore();    //이전 원소의 점수를 저장해두고 같은 점수인지 체크하기 위해
        int sameCount = 1;                  //preScore와 sameCount변수 생성

        grades[first.getIndex()] = grade;   //첫번째 원소의 등수는 1등으로 저장

        while(!priorityQueue.isEmpty()) {
            Pair pair = priorityQueue.poll();

            if(preScore != pair.getScore()) {   //이전 원소의 점수와 현재 원소의 점수가 다를 경우 => 등수에 sameCount를 더함
                grade += sameCount;             //=> sameCount변수가 2이상일 때는 앞의 등수가 점수가 같았을 때였으므로 등수를
                sameCount = 1;                  //=> 건너띄고 저장해야 하므로 sameCount를 더해주고 다시 1로 저장
            }else {                             //이전 원소의 점수와 현재 원소의 점수가 같을 경우
                sameCount++;                    //=> 등수를 그대로 저장하고 sameCount변수를 하나 증가시킴
            }

            grades[pair.getIndex()] = grade;
            preScore = pair.getScore();
        }
        return grades;
    }

    public static void main(String args[]) throws IOException {
        solution();
        System.out.println(stringBuilder);
    }
}
//Priority Queue안에 담길 객체를 자신만의 Class로 사용하려면 Comparable Interface를 implements하는 Class를 생성한 후,
//compareTo method를 우선 순위에 맞게 구현해 주면 된다.
class Pair implements Comparable<Pair> {

    private int index;
    private int score;

    public Pair(int index, int score) {
        this.index = index;
        this.score = score;
    }

    public int getIndex() {
        return index;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Pair o) {
        return o.score - this.score;
    }
}