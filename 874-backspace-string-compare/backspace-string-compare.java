class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i=s.length()-1; 
        int j= t.length()-1;

        int skipS=0; int skipT=0;

        while(i>=0 || j>=0)
        {
            while (i >= 0) { // Find position of next possible char in build(S)
                if (s.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (t.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
        }
        return true;
    }
}