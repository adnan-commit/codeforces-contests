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

            int n = Integer.parseInt(st.nextToken());

            String str = br.readLine();

            int originalLen = 1;

            for (int i = 1; i < n; i++) {

                if (str.charAt(i) != str.charAt(i - 1)) {
                    originalLen++;
                }
            }

            int minLen = originalLen;

            for (int i = 1; i < n - 1; i++) {
                char prev = str.charAt(i - 1);
                char curr = str.charAt(i);
                char next = str.charAt(i + 1);

                if (curr != prev && curr != next) {
                    if (prev == next) {
                        minLen = Math.min(minLen, originalLen - 2);
                    } else {
                        minLen = Math.min(minLen, originalLen - 1);
                    }
                }
            }

            sb.append(minLen).append("\n");

        }

        System.out.print(sb.toString());
    }

}