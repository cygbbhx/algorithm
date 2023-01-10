import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] time = new int[100001];
        int[] parent = new int[100001];

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        queue.add(N);
        time[N] = 1;

        if (N == K) {
            System.out.println(0);
            System.out.println(N);
            return;}

        while (!queue.isEmpty()){
            int start = queue.poll();
            for (int i = 0; i < 3; i++){
                int dest = (i == 0) ? start - 1 : (i == 1) ? start + 1 : start * 2;
                if (dest == K) {
                    System.out.println(time[start]);

                    stack.push(K);
                    int idx = start;
                    while (idx != N){
                        stack.push(idx);
                        idx = parent[idx];
                    } stack.push(N);

                    StringBuilder answer = new StringBuilder();
                    while (!stack.isEmpty()){
                        answer.append(stack.pop()).append(" ");
                    }

                    System.out.println(answer);
                    return;
                }

                if (dest >= 0 && dest < 100001 && time[dest] == 0){
                    time[dest] = time[start] + 1;
                    parent[dest] = start;
                    queue.add(dest);
                }
            }
        }
    }
}