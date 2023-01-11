import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Step{
        int eNum;
        int cNum;
        int time;

        public Step(int eNum, int cNum, int time) {
            this.eNum = eNum;
            this.cNum = cNum;
            this.time = time;
        }
    }

    public static boolean validIndex(int input){
        return input > 0 && input < 2000;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());

        int S = Integer.parseInt(st.nextToken());
        boolean[][] visited;
        visited = new boolean[2001][2001];
        Queue<Step> queue = new LinkedList<>();
        queue.add(new Step(1, 0, 0));

        while (!queue.isEmpty()){
            Step start = queue.poll();
            if (start.eNum == S){System.out.println(start.time); return;}

            // 복사
            if (validIndex(start.eNum) && !visited[start.eNum][start.eNum]){
                visited[start.eNum][start.eNum] = true;
                queue.offer(new Step(start.eNum, start.eNum, start.time + 1));
            }

            // 삭제
            if (validIndex(start.eNum - 1) && !visited[start.eNum - 1][start.cNum]){
                visited[start.eNum - 1][start.cNum] = true;
                queue.offer(new Step(start.eNum - 1, start.cNum, start.time + 1));
            }

            // 붙여넣기
            if (validIndex(start.eNum + start.cNum) && !visited[start.eNum + start.cNum][start.cNum]){
                visited[start.eNum + start.cNum][start.cNum] = true;
                queue.offer(new Step(start.eNum + start.cNum, start.cNum, start.time + 1));
            }

        }
    }
}