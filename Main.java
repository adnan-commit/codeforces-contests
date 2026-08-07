//Problem Link: https://codeforces.com/contest/2253/problem/C

import java.io.*;
import java.util.*;

public class Main {

    static class Element implements Comparable<Element> {
        int value;
        int type;

        public Element(int value, int type) {
            this.value = value;
            this.type = type;
        }

        @Override
        public int compareTo(Element other) {
            return Integer.compare(other.value, this.value);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCases = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        while (testCases-- > 0) {

            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Set<Integer> A = new HashSet<>();

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < x; i++) {
                A.add(Integer.parseInt(st.nextToken()));
            }

            Set<Integer> B = new HashSet<>();

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < y; i++) {
                B.add(Integer.parseInt(st.nextToken()));
            }

            Set<Integer> union = new HashSet<>(A);
            union.addAll(B);

            List<Element> elements = new ArrayList<>();

            for (int val : union) {
                boolean isInA = A.contains(val);
                boolean isInB = B.contains(val);

                int type;

                if (isInA && isInB) {
                    type = 2;
                } else if (isInA) {
                    type = 0;
                } else {
                    type = 1;
                }
                elements.add(new Element(val, type));
            }

            Collections.sort(elements);

            long ans1 = solve(elements, n, m - 1, n + m - 1);
            long ans2 = solve(elements, n - 1, m, n + m - 1);

            sb.append(Math.max(ans1, ans2)).append("\n");

        }

        System.out.print(sb.toString());
    }

    private static long solve(List<Element> elements, int maxA, int maxB, int maxTotal) {
        int countA = 0;
        int countB = 0;
        int totalCount = 0;
        long sum = 0;

        for (Element element : elements) {
            if (totalCount >= maxTotal) {
                break;
            }

            if (element.type == 0) {
                if (countA < maxA) {
                    sum += element.value;
                    countA++;
                    totalCount++;
                }
            } else if (element.type == 1) {
                if (countB < maxB) {
                    sum += element.value;
                    countB++;
                    totalCount++;
                }
            } else {
                totalCount++;
                sum += element.value;
            }
        }

        return sum;
    }

}
