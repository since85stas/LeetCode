package yandAlgh.sprint8;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class ShpargDp {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input4.txt"))));
        String s = reader.readLine();

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizerStr.nextToken());

        Shrarg.Trie trie = new Shrarg.Trie();
        HashSet<String> dict = new HashSet<>();

//        HashSet<String> dict = new HashSet<>();
        for (int i = 0; i < n; i++) {
//            trie.put(reader.readLine());
            dict.add(reader.readLine());
        }

        List<Integer> result = new ArrayList<>();

        boolean res =  trie.testWord(s,0, result);


        StringBuilder out = new StringBuilder();
        wordBreakDP(0,"","",s,dict,out);

        if (!res) System.out.println("NO");
        else System.out.println("YES");

    }

    static boolean wordBreakDP(int i, String currWord, String currSentence, String s, HashSet<String> wordDict, StringBuilder output)
    {
        //We exhausted the input string
        if(i == s.length())
        {
            //If the last word is part of the dictionary, we save the entire sence
            if(wordDict.contains(currWord) )
            {
                //To avoid whitespaces at the beginning of a output sentence
                if(currSentence.length() == 0)
                    output.append(currWord);
                else
                    output.append(currSentence + " " + currWord);
            }

            return true;
        }

        currWord += s.charAt(i);

        //Let's try not breaking the currWord just yet
        boolean res = wordBreakDP(i+1, currWord, currSentence, s, wordDict, output);

        /*
        Let's try breaking the current word, if it is part of the
        dictionary, we add it to the currSentence and reset the
        current word
        */
        if(wordDict.contains(currWord))
        {
            /*
            If the currSentence is empty, the the new sentence is just
            the current word, this is to avoid whitespaces at the beginnng
            of sentences
            */
            if(currSentence.length() == 0)
                res = wordBreakDP(i+1, "", currWord, s, wordDict, output);
            else //Otherwise, we just append the currWord to the currSentence and reset currWord
                res = wordBreakDP(i+1, "", currSentence + " " + currWord, s, wordDict, output);
        }
        return res;
    }

}
