import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][M];
        int[][] B = new int[N][M];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(input.readLine().replaceAll("", " "), " ");
            for (int j = 0; j < M; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(input.readLine().replaceAll("", " "), " ");
            for (int j = 0; j < M; j++){
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int height = N - 3 + 1;
        int width = M - 3 + 1;

        int count = 0;
        
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                if (A[i][j]!=B[i][j]){
                    for (int k = i; k < i+3; k++){
                        for (int l = j; l < j+3; l++){
                            A[k][l] = (A[k][l]==0) ? 1 : 0;
                        }
                    }
                    count++;
                }
            }
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (A[i][j] != B[i][j]){
                    System.out.println(-1); return;
                }
            }
        }

        System.out.println(count);

    }
}