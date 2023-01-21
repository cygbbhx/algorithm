import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String[] split = input.readLine().split("-");
        int result = 0;

        for (int i = 0; i < split.length; i++){
            int sum = 0;
            String[] split2 = split[i].split("\\+");
            for (String s : split2) {
                sum += Integer.parseInt(s);
            }
            result = (i == 0) ? result + sum : result - sum;
        }
        System.out.println(result);
    }
}