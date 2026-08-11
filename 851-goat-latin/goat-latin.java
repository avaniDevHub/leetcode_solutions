class Solution {
    private static Set<Character> vowels = new HashSet<>() {{
        add('a'); add('e'); add('i'); add('o'); add('u');
        add('A'); add('E'); add('I'); add('O'); add('U');
    }};

    public String toGoatLatin(String sentence) {
        String suff = "";
        StringBuilder sb = new StringBuilder();

        for (String tok : sentence.split(" ")) {
            suff += 'a';
            if (!vowels.contains(tok.charAt(0))) {
                tok = tok.substring(1) + tok.charAt(0);
            }
            sb.append(tok).append("ma").append(suff).append(' ');
        }

        sb.deleteCharAt(sb.length() - 1); // remove extra space
        return sb.toString();
    }
}