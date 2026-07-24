class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1=s1.length();
        int len2= s2.length();

        if(len1>len2) return false;

        int[] count1= new int[26];
        int[] count2= new int[26];

        for(int i=0;i<len1;i++)
        {
            count1[s1.charAt(i)-'a']++;
            count2[s2.charAt(i)-'a']++;

        }
        // If initial window matches, return true immediately
        if (Arrays.equals(count1, count2)) {
            return true;
        }

        // Slide the window across s2
        for (int i = len1; i < len2; i++) {
            // Add the new character on the right
            count2[s2.charAt(i) - 'a']++;
            
            // Remove the leftmost character that fell out of the window
            count2[s2.charAt(i - len1) - 'a']--;
            
            // Compare character frequency arrays
            if (Arrays.equals(count1, count2)) {
                return true;
            }
        }
        
        return false;
    }
}