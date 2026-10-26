//problem link: https://codeforces.com/contest/2272/problem/A

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

            int[] arr = new int[Integer.parseInt(st.nextToken())];
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int originalScore = calculateScore(arr, k);

            int bestScore = originalScore;
            int bestI = -1;
            int bestJ = -1;

            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {

                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                    int score = calculateScore(arr, k);

                    if (score > bestScore) {
                        bestScore = score;
                        bestI = i;
                        bestJ = j;
                    }

                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

            if (bestI == -1) {
                System.out.println(-1);
            } else {
                System.out.println((bestI + 1) + " " + (bestJ + 1));
            }

        }

        System.out.print(sb.toString());
    }

    private static int calculateScore(int[] a, int k) {
        int n = a.length;
        boolean[] seen = new boolean[n + 1];
        int[] mexValues = new int[n];
        int mex = 0;

        for (int i = 0; i < n; i++) {
            seen[a[i]] = true;

            while (seen[mex]) {
                mex++;
            }

            mexValues[i] = mex;
        }

        Arrays.sort(mexValues);

        return mexValues[n - k];
    }

}
