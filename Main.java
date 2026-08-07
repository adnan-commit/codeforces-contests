//Problem Link: https://codeforces.com/contest/2253/problem/B

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

            List<Integer> colors = new ArrayList<>();
            List<Integer> length = new ArrayList<>();

            int count = 1;

            for (int i = 1; i < n; i++) {
                if (arr[i] == arr[i - 1]) {
                    count++;
                } else {
                    colors.add(arr[i - 1]);
                    length.add(count);
                    count = 1;
                }
            }

            colors.add(arr[n - 1]);
            length.add(count);

            int k = colors.size();

            boolean canPlusTwo = false;
            for (int i = 0; i < k-1; i++) {
                if (length.get(i) >= 2 && length.get(i + 1) >= 2) {
                    canPlusTwo = true;
                    break;
                }
            }

            if(canPlusTwo){
                sb.append(k + 2).append("\n");
                continue;
            }

            boolean canPlusOne = false;
            for (int i = 0; i < k; i++) {
                if (length.get(i) >= 2) {
                    if(i > 0){
                        if(i == 1 || !colors.get(i-2).equals(colors.get(i))){
                            canPlusOne = true;
                            break;
                        }   
                    }
                    if(i < k - 1){
                        if(i == k - 2 || !colors.get(i+2).equals(colors.get(i))){
                            canPlusOne = true;
                            break;
                        }
                    }
                }
            }

            if(canPlusOne){
                sb.append(k + 1).append("\n");
                continue;
            }else{
                sb.append(k).append("\n");
            }

        }

        System.out.print(sb.toString());
    }


}
