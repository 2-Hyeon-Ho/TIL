import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        StickCut stickCut = new StickCut();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine();
        stickCut.cuttingCount(input);
    }
}

class StickCut {
    /*
     * 1. (를 만날 시 stack에 push한다.
     * 2. )를 만날 시 stack에서 pop한다.
     * 2-1. 전의 문자가 (일 경우 stack의 사이즈 만큼 result에 더한다.
     * 2-2. 전의 문자가 )일 경우 막대를 뜻하므로 result에 +1을 한다.
     */
    public void cuttingCount(String input) {
        Stack<String> stack = new Stack<>();
        String s = "";
        int result = 0;

        for(int i = 0; i < input.length(); i++) {
            s = Character.toString(input.charAt(i));
            if(s.equals("(")) {
                stack.push(s);
            }else if(s.equals(")")) {
                stack.pop();
                if(Character.toString(input.charAt(i-1)).equals("(")) {
                    result += stack.size();
                }else if(Character.toString(input.charAt(i-1)).equals(")")) {
                    result += 1;
                }
            }
        }
        System.out.println(result);
    }
}