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

            String str1 = br.readLine();
            String str2 = br.readLine();

            int evenOnesA = 0, oddOnesA = 0, evenOnesB = 0, oddOnesB = 0;

            for (int i = 0; i < n; i++) {
                if (str1.charAt(i) == '1') {
                    if (i % 2 == 0) {
                        evenOnesA++;
                    } else {
                        oddOnesA++;
                    }
                }
                if (str2.charAt(i) == '1') {
                    if (i % 2 == 0) {
                        evenOnesB++;
                    } else {
                        oddOnesB++;
                    }
                }
            }

            if (evenOnesA == evenOnesB && oddOnesA == oddOnesB) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }

        }

        System.out.print(sb.toString());
    }

}