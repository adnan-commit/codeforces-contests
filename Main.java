//Problem Link: https://codeforces.com/contest/2252/problem/A

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

            int[] arr = new int[n];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Map<Integer, Integer> map = new HashMap<>();
            int totalSum = 0;

            for (int i = 0; i < n; i++) {
                totalSum += arr[i];
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }

            int maxDamage = totalSum;

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int val = entry.getKey();
                int count = entry.getValue();

                int otherCards = n - count;
                int maxUsable = otherCards + 2;

                if (count > maxUsable) {
                    int unUsed = count - maxUsable;
                    int lostDamage = unUsed * val;
                    maxDamage = totalSum - lostDamage;
                    break;
                }
            }
            sb.append(maxDamage).append("\n");
        }

        System.out.print(sb.toString());
    }

}
