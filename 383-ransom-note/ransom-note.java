class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        StringBuilder sb= new StringBuilder(magazine);
        for(int i=0;i<ransomNote.length(); i++)
        {
            char ch=ransomNote.charAt(i);
            int index=(sb.indexOf(String.valueOf(ch)));
            if(index==-1) return false;

            sb.deleteCharAt(index);
        }
        return true;
    }
}