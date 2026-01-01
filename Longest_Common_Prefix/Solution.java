package Longest_Common_Prefix;
// Write a function to find the longest common prefix string amongst an array of strings.
// If there is no common prefix, return an empty string ""
class Solution{
    public static String longestCommonPrefix(String[] strs){
        String prefix = strs[0];

        // If there are more than 1 word loop through the words and find the prefix
        if (strs.length > 1){
            for (int i = 1; i < strs.length; i++){
                // If there is no prefix
                if (prefix.length() <= 0){
                    break;
                }

                String newPrefix = "";
                int smallestSize = (prefix.length() < strs[i].length()) ? prefix.length() : strs[i].length();
                // Check to see if the prefix size should be reduced
                for (int j = 0; j < smallestSize; j++){
                    if (prefix.charAt(j) == strs[i].charAt(j)){
                        newPrefix += strs[i].charAt(j);
                    }
                    else{
                        break;
                    }
                }
                prefix = newPrefix;
            }
        }

        // If there is one word then return that word
        else{
            return strs[0];
        }
        
        // Return the prefix
        return prefix;
    }
}