class Solution {
    public int[] beautifulArray(int n) {
        ArrayList<Integer> result=buildbeautifull(n);
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=result.get(i);
        }
        return arr;

    }
    private ArrayList<Integer> buildbeautifull(int n)
    {
        ArrayList<Integer> res=new ArrayList<>();
        if(n==1)
        {
            res.add(n);
            return res;
        }
        ArrayList<Integer> odd= buildbeautifull((n+1)/2);
        ArrayList<Integer> even= buildbeautifull(n/2);
        for(int i:odd)
        {
            res.add(i*2-1);
        }
        for(int i:even)
        {
            res.add(i*2);
        }
        return res;
    }
}