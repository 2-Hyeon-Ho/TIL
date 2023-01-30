import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        ReverseWord reverseWord = new ReverseWord();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String word = bufferedReader.readLine();
        reverseWord.reverse(word);
    }
}

class ReverseWord {
    public void reverse(String word) {
        Stack<String> stack = new Stack<>();
        boolean isTag = false;
        for(int i = 0; i < word.length(); i++) {
            String s = "";
            s = Character.toString(word.charAt(i));
            if(s.equals("<")) {
                isTag = true;
                while(!stack.isEmpty()) {
                    System.out.print(stack.pop());
                }
                System.out.print(s);
            }else if(s.equals(">")) {
                isTag = false;
                System.out.print(s);
            }else if(isTag) {
                System.out.print(s);
            }else if(!isTag) {
                if(s.equals(" ")) {
                    while(!stack.isEmpty()) {
                        System.out.print(stack.pop());
                    }
                    System.out.print(s);
                }else {
                    stack.push(s);
                }
            }
        }
        while(!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}