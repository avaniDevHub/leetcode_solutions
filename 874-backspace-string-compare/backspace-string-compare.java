class Solution {
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    public String build(String s)
    {
        Stack<Character> st= new Stack<>();
        for(char ch: s.toCharArray())
        {
            if(ch!= '#')
                st.push(ch);

            else if(!st.empty())
            st.pop(); 
        }
        return String.valueOf(st);
    }
}