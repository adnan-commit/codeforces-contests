import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCases = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        while (testCases-- > 0) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int[] arr = { a, b, c };

            Arrays.sort(arr);

            int diff = 0;

            if (a == b || b == c || a == c) {
                diff = 0;
            } else {
                diff = Math.min(Math.abs(arr[2] - arr[1]),
                        Math.min(Math.abs(arr[1] - arr[0]), Math.abs(arr[2] - arr[0])));
            }
            sb.append(diff).append("\n");
        }

        System.out.print(sb.toString());
    }

}