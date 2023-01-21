import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(input.readLine());
        int[][] time = new int[N][2];

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(input.readLine(), " ");
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]){return o1[0] - o2[0];}
                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int curTime = 0;

        for (int i = 0; i < N; i++){
            if (time[i][0] < curTime) {continue;}
            count++;
            curTime = time[i][1];
        }

        System.out.println(count);
    }
}