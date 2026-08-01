class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int p1= num1.length()-1;
        int p2= num2.length()-1;
        int carry=0;

        while(p1>=0 || p2>=0 || carry>0)
        {
            int digit1= (p1>=0) ? num1.charAt(p1)-'0' : 0;
            int digit2= (p2>=0) ? num2.charAt(p2)-'0' : 0;

            int sum= digit1+digit2+carry;
            carry=sum/10;
            result.append(sum%10);

            p1--;
            p2--;

        }
        return result.reverse().toString();
    }
}