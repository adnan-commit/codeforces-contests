//Problem Link: https://codeforces.com/contest/2254/problem/D

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

            Map<Long, Integer> map = new HashMap<>();

            for (long val : arr) {
                map.put(val, map.getOrDefault(val, 0) + 1);
            }

            List<Long> list = new ArrayList<>(map.keySet());
            Collections.sort(list);

            int size = list.size();

            if (list.get(0) != 0) {
                sb.append("-1\n");
                continue;
            }

            long[] result = new long[size];
            boolean isPossible = true;

            long c0 = map.get(list.get(0));

            if (size > 1) {
                long targetSum = list.get(1);
                if (targetSum % c0 != 0) {
                    isPossible = false;
                } else {
                    result[0] = targetSum / c0;
                }
            } else {
                result[0] = 1;
            }

            for (int i = 1; i < size && isPossible; i++) {
                long prevU = list.get(i - 1);
                long currU = list.get(i);
                long prevC = map.get(prevU);

                if (currU != prevU + prevC * result[i - 1]) {
                    isPossible = false;
                    break;
                }

                if (i < size - 1) {
                    long nextU = list.get(i + 1);
                    long diff = nextU - currU;
                    long currC = map.get(currU);

                    if (diff % currC != 0) {
                        isPossible = false;
                        break;
                    }
                    result[i] = diff / currC;
                } else {
                    result[i] = result[i - 1] + 1;
                }

                if (result[i] <= result[i - 1]) {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) {
                sb.append("-1\n");
            } else {
                Map<Long, Long> shadowtoVal = new HashMap<>();
                for (int i = 0; i < size; i++) {
                    shadowtoVal.put(list.get(i), result[i]);
                }

                for (int i = 0; i < n; i++) {
                    sb.append(shadowtoVal.get(arr[i])).append(i == n - 1 ? "" : " ");
                }
                sb.append("\n");
            }

        }

        System.out.print(sb.toString());
    }

}