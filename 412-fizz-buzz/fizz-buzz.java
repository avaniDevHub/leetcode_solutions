class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> answer= new ArrayList<>(n);
        for(int i=1;i<=n; i++)
        {
            boolean divisibleby3= (i%3==0);
            boolean divisibleby5= (i%5==0);

            if(divisibleby3 && divisibleby5)
            {
                answer.add("FizzBuzz");
            }
            else if(divisibleby3)

            answer.add("Fizz");

            else if(divisibleby5)
            answer.add("Buzz");

            else
            answer.add(String.valueOf(i));
        }
         return answer;   
    }
}