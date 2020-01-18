package io.github.dunwu.algorithm.hashtable;

/*
https://leetcode.com/problems/to-lower-case/

Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.



Example 1:

Input: "Hello"
Output: "hello"
Example 2:

Input: "here"
Output: "here"
Example 3:

Input: "LOVELY"
Output: "lovely"

 */
public class ToLowerCase {

    public static void main(String[] args) {
        ToLowerCase tmpl = new ToLowerCase();
        String result = tmpl.toLowerCase("Hello");
        System.out.println("result = [" + result + "]");
    }

    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                sb.append((char) (str.charAt(i) + 32));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

}
