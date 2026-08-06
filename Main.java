//Problem Link: https://codeforces.com/contest/2252/problem/D

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

            long[] arr = new long[n];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }

            long[] d = new long[n - 1];
            for (int i = 0; i < n - 1; i++) {
                d[i] = arr[i + 1] - arr[i];
            }

            int l = 0;
            while (l < n - 1) {
                int r = l;
                while (r + 1 < n - 1 && Math.abs(d[r + 1] % 2) == Math.abs(d[l] % 2)) {
                    r++;
                }

                Arrays.sort(d, l, r + 1);

                l = r + 1;
            }

            sb.append(arr[0]);
            long current = arr[0];
            for (int i = 0; i < n - 1; i++) {
                current += d[i];
                sb.append(" ").append(current);
            }
            sb.append("\n");

        }

        System.out.print(sb.toString());
    }

}
