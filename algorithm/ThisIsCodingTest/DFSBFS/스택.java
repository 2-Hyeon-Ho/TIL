import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class 스택 {

    //스택
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(5);
        stack.push(2);
        stack.push(3);
        stack.push(7);
        stack.pop();
        stack.push(1);
        stack.push(4);
        stack.pop();

        List<Integer> list = new ArrayList<>();
        System.out.print("제일 마지막에 삽입된 원소부터 출력 : ");
        while(!stack.empty()) {
            System.out.print(stack.peek() + " ");
            list.add(stack.peek());
            stack.pop();
        }
        System.out.print("\n제일 처음에 삽입된 원소부터 출력 : ");
        Collections.reverse(list);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }

}