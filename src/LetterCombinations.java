
/***
17 medium
***/

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        Map<Character, String> phonePad = new HashMap<>();
        phonePad.put('2', "abc");
        phonePad.put('3', "def");
        phonePad.put('4', "ghi");
        phonePad.put('5', "jkl");
        phonePad.put('6', "mno");
        phonePad.put('7', "pqrs");
        phonePad.put('8', "tuv");
        phonePad.put('9', "wxyz");

        result.add("");
        
        for (int i = 0; i < digits.length(); i++) {
            char curDigit = digits.charAt(i);
            String letters = phonePad.get(curDigit);
            List<String> temp = new ArrayList<>();
            for (String pre : result) {
                for (int j = 0; j < letters.length(); j++) {
                    String curletter = letters.substring(j, j + 1);
                    temp.add(pre + curletter);
                }
            }
            result = temp;
        }
        
        return result;
    }
}