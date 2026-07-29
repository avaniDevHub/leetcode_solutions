class Solution {
    public boolean validString(String s)
    {
        int count=0;
        for(char ch:s.toCharArray())
        {
            if(ch=='(') count++;
            else count--;

            if(count<0) return false;

        }
        return count == 0;
    }

    public void generateParenthesisIsHelper(String curr, int n, List<String> res)
    {
        if(curr.length()==2*n)
        {
            if(validString(curr))
            {
                res.add(curr);
            }
            return;
        }
        generateParenthesisIsHelper(curr+"(", n, res);
        generateParenthesisIsHelper(curr+")", n, res);

    }
    public List<String> generateParenthesis(int n) {
        List<String> res= new ArrayList<>();
        //generateParenthesisIsHelper("", n, res);
        Queue<String> d_s= new LinkedList<>();

        d_s.add("");

        while(!d_s.isEmpty())
        {
            String curr= d_s.remove();
            if(curr.length()==2*n)
            {
                if(validString(curr))
                {
                    res.add(curr);
                }
                continue;
            }
            d_s.add(curr + "(");
            d_s.add(curr + ")");
        }

        return res;
    }
}