package io.github.dunwu.algorithm.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/subdomain-visit-count/

A website domain like "discuss.leetcode.com" consists of various subdomains. At the top level, we have "com", at the
next level, we have "leetcode.com", and at the lowest level, "discuss.leetcode.com".
When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and
"com" implicitly.

Now, call a "count-paired domain" to be a count (representing the number of visits this domain received),
followed by a space, followed by the address. An example of a count-paired domain might be "9001 discuss.leetcode.com".

We are given a list cpdomains of count-paired domains. We would like a list of count-paired domains, (in the same format
as the input, and in any order), that explicitly counts the number of visits to each subdomain.

Example 1:
Input:
["9001 discuss.leetcode.com"]
Output:
["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
Explanation:
We only have one website domain: "discuss.leetcode.com". As discussed above, the subdomain "leetcode.com" and "com"
will also be visited. So they will all be visited 9001 times.

Example 2:
Input:
["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
Output:
["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
Explanation:
We will visit "google.mail.com" 900 times, "yahoo.com" 50 times, "intel.mail.com" once and "wiki.org" 5 times.
For the subdomains, we will visit "mail.com" 900 + 1 = 901 times, "com" 900 + 50 + 1 = 951 times, and "org" 5 times.

Notes:

The length of cpdomains will not exceed 100.
The length of each domain name will not exceed 100.
Each address will have either 1 or 2 "." characters.
The input count in any count-paired domain will not exceed 10000.
The answer output can be returned in any order.
*/
public class SubdomainVisitCount {

    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>(); // key: subdomain, value: frequency
        StringBuilder resultStringBuilder = new StringBuilder();

        for (String cpdomain : cpdomains) {
            int indexSpace = cpdomain.indexOf(' ');
            int numClicks = Integer.parseInt(cpdomain.substring(0, indexSpace));
            String domain = cpdomain.substring(indexSpace + 1);
            resultStringBuilder.setLength(0);
            resultStringBuilder.append(domain);
            while (true) {
                map.put(resultStringBuilder.toString(), map.getOrDefault(resultStringBuilder.toString(), 0) + numClicks);
                int dotPosition = resultStringBuilder.indexOf(".");
                if (dotPosition == -1)
                    break;
                resultStringBuilder.delete(0, dotPosition + 1);
            }
        }

        for (String domain : map.keySet())
            result.add(map.get(domain) + " " + domain);

        return result;
    }

    public static void main(String[] args) {
        SubdomainVisitCount tmpl = new SubdomainVisitCount();

        String[] s1 = new String[]{"9001 discuss.leetcode.com"};
        String[] s2 = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        tmpl.subdomainVisits(s1);
        tmpl.subdomainVisits(s2);
    }
}
