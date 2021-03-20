package yandAlgh.sprint4;

import java.io.*;
import java.util.StringTokenizer;

public class CommonSubMass {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());

        StringBuilder builder = new StringBuilder();
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            short s = Short.parseShort(tokenizer.nextToken());
            char c = (char) s;
            builder.append(c);
        }
        String s1 = builder.toString();

        tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());

        builder = new StringBuilder();
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            short s = Short.parseShort(tokenizer.nextToken());
            char c = (char) s;
            builder.append(c);
        }
        String s2 = builder.toString();

        int res = LCSubStr(s1,s2,s1.length(),s2.length());
        System.out.println(res);
    }

    // Function to find the length of the
    // longest LCS
    static int LCSubStr(String s,String t,
                        int n,int m)
    {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return 0;
        }
        // Create DP table
        int dp[][]=new int[2][m+1];
        int res=0;

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(s.charAt(i-1)==t.charAt(j-1))
                {
                    dp[i%2][j]=dp[(i-1)%2][j-1]+1;
                    if(dp[i%2][j]>res)
                        res=dp[i%2][j];
                }
                else dp[i%2][j]=0;
            }
        }
        return res;
    }

    public static int longestCommonSubstring(String A, String B) {
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return 0;
        }
        int [][] D = new int[A.length() + 1][B.length() + 1];
        int max = 0;
        for (int i = 0; i <= A.length(); i++) {
            for(int j = 0; j <= B.length(); j++) {
                if (i == 0 || j == 0) {
                    D[i][j] = 0;
                } else {
                    if (A.charAt(i - 1) == B.charAt(j - 1)) {
                        D[i][j] = D[i - 1][j - 1] + 1;
                    } else {
                        D[i][j] = 0;
                    }
                    max = Math.max(max, D[i][j]);
                }
            }
        }
        return max;
    }

//    private static int longestCommonSubstring2(String S1, String S2)
//    {
//        int Start = 0;
//        int Max = 0;
//        for (int i = 0; i < S1.length(); i++)
//        {
//            for (int j = 0; j < S2.length(); j++)
//            {
//                int x = 0;
//                while (S1.charAt(i + x) == S2.charAt(j + x))
//                {
//                    x++;
//                    if (((i + x) >= S1.length()) || ((j + x) >= S2.length())) break;
//                }
//                if (x > Max)
//                {
//                    Max = x;
//                    Start = i;
//                }
//            }
//        }
//        return S1.substring(Start, (Start + Max)).length();
//    }

}


