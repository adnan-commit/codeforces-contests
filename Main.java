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

            List<Integer> evenA = new ArrayList<>();
            List<Integer> oddA = new ArrayList<>();
            List<Integer> evenB = new ArrayList<>();
            List<Integer> oddB = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (str1.charAt(i) == '1') {
                    if (i % 2 == 0) {
                        evenA.add(i);
                    } else {
                        oddA.add(i);
                    }
                }
                if (str2.charAt(i) == '1') {
                    if (i % 2 == 0) {
                        evenB.add(i);
                    } else {
                        oddB.add(i);
                    }
                }
            }

            if (evenA.size() != evenB.size() || oddA.size() != oddB.size()) {
                sb.append(-1).append("\n");
                continue;
            }

            long totalOps = 0;

            for (int i = 0; i < evenA.size(); i++) {
                totalOps += Math.abs(evenA.get(i) - evenB.get(i)) / 2;
            }

            for (int i = 0; i < oddA.size(); i++) {
                totalOps += Math.abs(oddA.get(i) - oddB.get(i)) / 2;
            }

            sb.append(totalOps).append("\n");

        }

        System.out.print(sb.toString());
    }

}