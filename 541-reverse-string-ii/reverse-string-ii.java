class Solution {
    public String reverseStr(String s, int k) {
        char arr[]=s.toCharArray();
        for(int ss=0;ss<s.length();ss+=2*k)
        {
            int i=ss;
            int j=Math.min(ss+k-1,s.length()-1);
            while(i<j)
            {
                char temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }
        }
        return new String(arr);
    }
}