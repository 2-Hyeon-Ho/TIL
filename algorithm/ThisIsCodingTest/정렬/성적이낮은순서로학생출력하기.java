import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Exam implements Comparable<Exam> {

    private String name;
    private int score;

    public Exam(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Exam other) {
        //성적이 낮은순서대로 출력 => 오름차순
        //오름차순은 this.score < other.score => return -1;
        if(this.score < other.score) {
            return -1;
        }
        return 1;
    }
}

public class 성적이낮은순서로학생출력하기 {

    private static int n;
    private static List<Exam> list = new ArrayList<>();
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());

        for(int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            list.add(new Exam(stringTokenizer.nextToken(), Integer.parseInt(stringTokenizer.nextToken())));
        }
    }

    private static void solution(List<Exam> list) {
        Collections.sort(list);

        for(int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i).getName()).append(' ');
        }
        System.out.println(stringBuilder);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution(list);
    }
}
