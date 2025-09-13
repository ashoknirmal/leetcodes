class Solution {
    public int maxFreqSum(String s) {
        int sum=0;
        HashMap<Character,Integer> vow=new HashMap<>();
        HashMap<Character,Integer> cons=new HashMap<>();
        for(char c:s.toCharArray())
        {
            if("aeiou".contains(String.valueOf(c)))
            {
                vow.put(c,vow.getOrDefault(c,0)+1);
            }
            else{
                cons.put(c,cons.getOrDefault(c,0)+1);
            }
        }
        int v=vow.isEmpty()?0:Collections.max(vow.values());
        int c=cons.isEmpty()?0:Collections.max(cons.values());
        sum=v+c;
        return sum;
    }
}