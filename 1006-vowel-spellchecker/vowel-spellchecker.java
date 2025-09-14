class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        String[] result = new String[queries.length];

        // Build maps for case-insensitive and vowel-error matches
        Map<String, String> caseMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();
        Set<String> exactWords = new HashSet<>();

        for (String word : wordlist) {
            exactWords.add(word);

            String lower = word.toLowerCase();
            if (!caseMap.containsKey(lower)) {
                caseMap.put(lower, word); // store first occurrence
            }

            String devowel = replaceVowels(lower);
            if (!vowelMap.containsKey(devowel)) {
                vowelMap.put(devowel, word);
            }
        }

        // Process each query
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];

            if (exactWords.contains(query)) {
                result[i] = query;
            } else {
                String lower = query.toLowerCase();
                String devowel = replaceVowels(lower);

                if (caseMap.containsKey(lower)) {
                    result[i] = caseMap.get(lower);
                } else if (vowelMap.containsKey(devowel)) {
                    result[i] = vowelMap.get(devowel);
                } else {
                    result[i] = "";
                }
            }
        }

        return result;
    }

    // Helper method to replace vowels with '*'
    private String replaceVowels(String word) {
        StringBuilder sb = new StringBuilder();

        for (char c : word.toCharArray()) {
            if (isVowel(c)) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    // Check if a character is a vowel
    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) >= 0;
    }
}
