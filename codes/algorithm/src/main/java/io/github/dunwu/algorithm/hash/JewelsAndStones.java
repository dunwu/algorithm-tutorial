package io.github.dunwu.algorithm.hash;

import java.util.HashSet;

/*
https://leetcode.com/problems/jewels-and-stones/

You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters.
Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct.
*/
public class JewelsAndStones {

    public static void main(String[] args) {
        JewelsAndStones tmpl = new JewelsAndStones();

        int result1 = tmpl.numJewelsInStones("aA", "aAAbbbb");
        System.out.println("result1 = [" + result1 + "]");

        int result2 = tmpl.numJewelsInStones("z", "ZZ");
        System.out.println("result1 = [" + result2 + "]");
    }

    public int numJewelsInStones(String J, String S) {
        HashSet set = new HashSet();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }

        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                count++;
            }
        }
        return count;
    }

}
