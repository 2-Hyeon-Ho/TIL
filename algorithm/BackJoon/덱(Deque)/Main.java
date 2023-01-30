import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Deque deque = new Deque();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        for(int i = 0; i < N; i++) {
            String a = "";
            a = bufferedReader.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(a);

            String s = "";
            s = stringTokenizer.nextToken();
            if(s.equals("push_back")) {
                int number = Integer.parseInt(stringTokenizer.nextToken());
                deque.push_back(number);
            }else if(s.equals("push_front")) {
                int number = Integer.parseInt(stringTokenizer.nextToken());
                deque.push_front(number);
            }else if(s.equals("front")) {
                System.out.println(deque.front());
            }else if(s.equals("back")) {
                System.out.println(deque.back());
            }else if(s.equals("pop_front")) {
                System.out.println(deque.pop_front());
            }else if(s.equals("pop_back")) {
                System.out.println(deque.pop_back());
            }else if(s.equals("size")) {
                System.out.println(deque.size());
            }else if(s.equals("empty")) {
                System.out.println(deque.empty());
            }else {
                System.out.println("Not exist command");
            }
        }
    }
}

class Deque {
    ArrayDeque<Integer> deque = new ArrayDeque<Integer>();

    public int empty() {
        if(deque.isEmpty()) {
            return 1;
        }else {
            return 0;
        }
    }

    public void push_front(int number) {
        deque.addFirst(number);
    }

    public void push_back(int number) {
        deque.addLast(number);
    }

    public int pop_front() {
        if(this.empty() == 1) {
            return -1;
        }else {
            return deque.pollFirst();
        }
    }

    public int pop_back() {
        if(this.empty() == 1) {
            return -1;
        }else {
            return deque.pollLast();
        }
    }

    public int size() {
        return deque.size();
    }

    public int front() {
        if(this.empty() == 1) {
            return -1;
        }else {
            return deque.peekFirst();
        }
    }

    public int back() {
        if(this.empty() == 1) {
            return -1;
        }else {
            return deque.peekLast();
        }
    }
}