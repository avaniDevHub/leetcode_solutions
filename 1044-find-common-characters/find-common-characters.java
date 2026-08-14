class Solution {
    public List<String> commonChars(String[] words) {
        int wordsSize = words.length;
        int[] commonCharacterCount = new int[26];
        int[] currentCharacterCount= new int[26];
        List<String> result= new ArrayList<>();

        for(char ch: words[0].toCharArray())
        {
            commonCharacterCount[ch- 'a']++;
        }

        for(int i=1;i<wordsSize;i++)
        {
            Arrays.fill(currentCharacterCount,0);

 // Count characters in the current word
            for(char ch: words[i].toCharArray())
            {
                currentCharacterCount[ch - 'a']++;
            }

            // Update the common character counts to keep the minimum counts
            for(int letter=0;letter<26;letter++)
            {
                commonCharacterCount[letter]=Math.min(commonCharacterCount[letter], currentCharacterCount[letter]);
            }

        }

        for(int letter=0; letter<26; letter++)
        {
            for(int commoncount=0;commoncount< commonCharacterCount[letter];commoncount++)
            {
                result.add(String.valueOf((char) (letter+'a')));
            }
        }
        return result;
    }

}