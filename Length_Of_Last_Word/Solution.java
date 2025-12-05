package Length_Of_Last_Word;

public class Solution {
    public static int lengthOfLastWord(String s) {
        int lengthOfLastWord = 0;
        char[] chars = s.toCharArray();

        for (int i = chars.length - 1; i >= 0; i--){
            if (chars[i] == ' '){
                if (lengthOfLastWord != 0){
                    break;
                }
            }

            else{
                lengthOfLastWord++;
            }
        }

        return lengthOfLastWord;
    }
}