import java.util.*;
import java.util.stream.Collectors;

public class ProblemsEasy02 {
//    Write a function to find the longest common prefix string amongst an array of strings.
//    If there is no common prefix, return an empty string ""
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        if (strs.length>0) {
            prefix.append(strs[0]);
            for (int i = 1; i < strs.length; i++) {
                int minLength = prefix.length() <= strs[i].length() ? prefix.length() : strs[i].length();
                StringBuilder prefixLocal = new StringBuilder();
                for (int j = 0; j < minLength; j++) {
                    if (strs[i].charAt(j) == prefix.charAt(j)) {
                        prefixLocal.append(strs[i].charAt(j));
                    } else {
                        break;
                    }
                }
                if (prefixLocal.length() == 0) return "";
                prefix = new StringBuilder();
                prefix.append(prefixLocal);
            }
        }
        return prefix.toString();
    }

    public static int removeDuplicates(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        HashSet<Integer> hashSet = new HashSet<Integer>(list);
        return hashSet.size();
    }

    public static int maxSubArray(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            len ++;
            int sum = nums[i];
            map.put(sum,len);
            for (int j = i+1; j < nums.length; j++) {
                len++;
                sum+=nums[j];
                map.put(sum,len);
            }
        }
        return Collections.max(map.keySet());
    }


}
