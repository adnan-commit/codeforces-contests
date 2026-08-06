//Problem Link: https://codeforces.com/contest/2252/problem/B

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

            String s = br.readLine();

            int cnt0 = 0, cnt1 = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0')
                    cnt0++;
                else
                    cnt1++;
            }

            int L0 = 0;
            char expected = '0';
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == expected) {
                    L0++;
                    expected = (expected == '0') ? '1' : '0';
                }
            }

            int L1 = 0;
            expected = '1';
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == expected) {
                    L1++;
                    expected = (expected == '0') ? '1' : '0';
                }
            }

            int minDeletions = Integer.MAX_VALUE;

            for (int m = 1; m <= L0; m++) {
                int rem0, rem1;
                if (m % 2 == 0) {
                    rem0 = m / 2;
                    rem1 = m / 2;
                } else {
                    rem0 = (m + 1) / 2;
                    rem1 = (m - 1) / 2;
                }
                int d0 = cnt0 - rem0;
                int d1 = cnt1 - rem1;
                if (d0 >= 0 && d1 >= 0 && Math.abs(d0 - d1) <= 1) {
                    minDeletions = Math.min(minDeletions, n - m);
                }
            }

            for (int m = 1; m <= L1; m++) {
                int rem0, rem1;
                if (m % 2 == 0) {
                    rem0 = m / 2;
                    rem1 = m / 2;
                } else {
                    rem0 = (m - 1) / 2;
                    rem1 = (m + 1) / 2;
                }
                int d0 = cnt0 - rem0;
                int d1 = cnt1 - rem1;
                if (d0 >= 0 && d1 >= 0 && Math.abs(d0 - d1) <= 1) {
                    minDeletions = Math.min(minDeletions, n - m);
                }
            }

            if (minDeletions == Integer.MAX_VALUE) {
                sb.append("-1\n");
            } else {
                sb.append(minDeletions).append("\n");
            }
        }

        System.out.print(sb.toString());
    }

}
