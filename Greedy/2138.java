import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());

        StringTokenizer initLine = new StringTokenizer(input.readLine().replaceAll("", " "), " ");
        StringTokenizer targLine = new StringTokenizer(input.readLine().replaceAll("", " "), " ");

        int[] initial = new int[N];
        int[] target = new int[N];

        for (int i = 0; i < N; i++){
            initial[i] = Integer.parseInt(initLine.nextToken());
            target[i] = Integer.parseInt(targLine.nextToken());
        }

        int[] case1 = initial.clone();
        int[] case2 = initial.clone();

        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < N; i++){
            if (i == 0){PressSwitch(case1, i); count1++; continue;}
            if (case1[i-1]!=target[i-1]){PressSwitch(case1, i); count1++;}
            if (case2[i-1]!=target[i-1]){PressSwitch(case2, i); count2++;}
        }

        int result = (Arrays.equals(case1, target) & Arrays.equals(case2, target)) ? Math.min(count1, count2) :
                     (Arrays.equals(case1, target)) ? count1 :
                     (Arrays.equals(case2, target)) ? count2 : -1;

        System.out.println(result);
    }

    public static void PressSwitch(int[] bulbs, int i){
        if (i > 0){bulbs[i-1] = (bulbs[i-1] == 0) ? 1 : 0;}
        bulbs[i] = (bulbs[i] == 0) ? 1 : 0;
        if (i < bulbs.length - 1){bulbs[i+1] = (bulbs[i+1] == 0) ? 1 : 0;}
    }

}