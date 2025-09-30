class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start=0;
        int end=0;
        int maxlen=Math.min(s.length(),1);
        HashSet<Character> seen=new HashSet<>();
        while(end<s.length())
        {
            char c=s.charAt(end);
            while(seen.contains(c))
            {
                seen.remove(s.charAt(start));
                start+=1;
            }
            seen.add(c);
            maxlen=Math.max(maxlen,seen.size());
            end+=1;
        }
        return maxlen;
    }
}