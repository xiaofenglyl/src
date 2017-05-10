package OnetoFive;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by asus-Iabx on 2017/4/13.
 * leetcode third question.
 * learn from the Solution that created by others.
 * the main idea of that author.
 * 基本思想是保留一个将字符串存储在字符串中作为键和其位置作为值的hashmap，并保留两个定义最大子字符串的指针。
 移动右侧指针扫描字符串，同时更新hashmap。
 如果字符已经在hashmap中，则将左侧指针移动到最后找到的同一个字符的右侧。
 请注意，这两个指针只能向前移动。
 */
public class lengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s)
    {
        if(s.length()==0) return 0;
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        int max=0;
        int j=0;
        for(int i=0;i<s.length();i++)
        {
            if(map.containsKey(s.charAt(i)))
                j=Math.max(j,map.get(s.charAt(i))+1);
            map.put(s.charAt(i),i);
            max=Math.max(max,i-j+1);
        }
        return max;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int length=lengthOfLongestSubstring(s);
        System.out.println(length);
    }
}
