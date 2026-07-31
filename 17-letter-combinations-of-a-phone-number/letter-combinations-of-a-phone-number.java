class Solution {
    public List<String> letterCombinations(String digits) {
        List <String> result= new ArrayList<>();

        //base case
        if(digits == null || digits.length()==0)
        {
            return result;
        }
        backtrack(digits,0,new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits,int index, StringBuilder current, List<String> result)
    {
        // Base case: reached the end of digits string
        if(index == digits.length())
        {
            result.add(current.toString());
            return;
        }

        //get mapped letters from current digit
        String letters= keypad[digits.charAt(index) -'0'];

        //explore all choices from current digit
        for(char ch: letters.toCharArray())
        {
            current.append(ch);//choose 
            //explore
            backtrack(digits, index+1, current, result);
            current.deleteCharAt(current.length()-1); // unchoose

        }
    }

    //mapping from digit char to telephone letters
    private static final String[] keypad= {
        "", 
        "",
        "abc",
        "def",
        "ghi"
        ,"jkl",
        "mno",
        "pqrs",
        "tuv","wxyz"
    };

}