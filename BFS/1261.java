import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;

    public static class Room implements Comparable<Room>{
        int y;
        int x;
        int path;

        public Room(int y, int x, int path) {
            this.y = y;
            this.x = x;
            this.path = path;
        }

        @Override
        public int compareTo(Room o) {
            return this.path - o.path;
        }
    }

    public static boolean validIdx(int y, int x){
        return (1 <= y && y <= N && 1 <= x && x <= M);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[][] maze = new int[N+1][M+1];
        boolean[][] visited = new boolean[N+1][M+1];

        for (int i = 1; i <= N; i++){
            st = new StringTokenizer(input.readLine().replaceAll("", " "), " ");
            for (int j = 1; j <= M; j++){
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<Room> queue = new PriorityQueue<>();
        queue.add(new Room(1, 1, 0));
        visited[1][1] = true;

        while (!queue.isEmpty()){
            Room room = queue.poll();

            if (room.y == N && room.x == M){
                System.out.println(room.path); return;
            }

            for (int i = 0; i < 4; i++){ // 오른쪽 아래쪽 왼쪽 위쪽
                int nextY = (i == 3) ? room.y - 1 : (i == 1) ? room.y + 1 : room.y;
                int nextX = (i == 0) ? room.x + 1 : (i == 2) ? room.x - 1 : room.x;

                if (validIdx(nextY, nextX) && !visited[nextY][nextX]){
                    queue.offer(new Room(nextY, nextX, (maze[nextY][nextX]==0) ? room.path : room.path + 1));
                    visited[nextY][nextX] = true;
                }
            }

        }
    }
}