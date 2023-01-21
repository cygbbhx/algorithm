import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] jewels = new int[N][2];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(input.readLine(), " ");
            jewels[i][0] = Integer.parseInt(st.nextToken());
            jewels[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] C = new int[K];

        for (int i = 0; i < K; i++){
            C[i] = Integer.parseInt(input.readLine());
        }

        Arrays.sort(jewels, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){return Integer.compare(o2[1], o1[1]);}
                else return Integer.compare(o1[0], o2[0]);
            }
        });

        Arrays.sort(C);;
        long total = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        int idx = 0;
        for (int i = 0; i < K; i++){
            while (idx < N && jewels[idx][0] <= C[i]){
                queue.offer(jewels[idx++][1]);
            }
            if (!queue.isEmpty()){total += queue.poll();}
        }

        System.out.println(total);

    }

}