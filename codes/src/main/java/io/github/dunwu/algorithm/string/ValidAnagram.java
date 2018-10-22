package io.github.dunwu.algorithm.string;


import java.util.HashMap;
import java.util.Map;

/*
@see https://leetcode.com/problems/valid-anagram/

Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        else if (s == null || t == null) return false;
        else if (s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                Integer count = map.get(s.charAt(i));
                ++count;
                map.remove(s.charAt(i));
                map.put(s.charAt(i), count);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        Map<Character, Integer> map2 = new HashMap<Character, Integer>();
        for (int j = 0; j < t.length(); j++) {
            if (map2.containsKey(t.charAt(j))) {
                Integer count = map2.get(t.charAt(j));
                ++count;
                map2.remove(t.charAt(j));
                map2.put(t.charAt(j), count);
            } else {
                map2.put(t.charAt(j), 1);
            }
        }

        if (map.size() != map2.size()) {
            return false;
        }

        for (Map.Entry<Character, Integer> entry1 : map.entrySet()) {
            Integer m1value = entry1.getValue() == null ? 0 : entry1.getValue();
            Integer m2value = map2.get(entry1.getKey()) == null ? 0 : map2.get(entry1.getKey());
            if (!m1value.equals(m2value)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean result1 = isAnagram("anagram", "nagaram");
        boolean result2 = isAnagram("rat", "car");
        boolean result3 = isAnagram("a", "ab");
        System.out.println("result:" + result1);
        System.out.println("result:" + result2);
        System.out.println("result:" + result3);
    }
}
