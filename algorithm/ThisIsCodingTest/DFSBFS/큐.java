import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 큐 {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(5);
        queue.offer(2);
        queue.offer(3);
        queue.offer(7);
        queue.poll();
        queue.offer(1);
        queue.offer(4);
        queue.poll();

        List<Integer> list = new ArrayList<>();
        System.out.print("먼저 들어온 순서대로 출력 : ");
        while(!queue.isEmpty()) {
            System.out.print(queue.peek() + " ");
            list.add(queue.peek());
            queue.poll();
        }
        Collections.reverse(list);
        System.out.print("\n나중에 들어온 순서대로 출력 : ");
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }

}