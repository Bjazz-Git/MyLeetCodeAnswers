package Roman_To_Integer;

//https://leetcode.com/problems/roman-to-integer/?envType=study-plan-v2&envId=top-interview-150
public class Solution{
    public static int romanToInt(String s){
        char[] numerals = s.toCharArray();
        int finalNum = 0;
        // If the numeral has an odd number of digits set the front number that's missed by the loop
        int firstNum = (numerals.length % 2 != 0) ? convertRomanToNumeric(numerals[0]) : 0;

        // Iterates through the roman numeral and converts all the letters into numeric numbers
        for (int i = numerals.length - 1; i > 0; i -= 2){
            int n1 = convertRomanToNumeric(numerals[i]);
            int n2 = convertRomanToNumeric(numerals[i - 1]);
            
            // If n2 is less than n1 that means it is one of the unique roman numeral combinations (like IV)
            if (n2 < n1){
                finalNum += n1 - n2;
            }

            // If n1 and n2 don't represent a proper numeral pair
            // Add n1 to the final number and start at n2's position in the next iteration
            else if(n2 / n1 != getFirstDigit(n2)){
                finalNum += n1;
                i++;

                // If firstNum was not set then there were odd number of pairs
                // However, with the current pair not being valid there are now even pairs
                if (firstNum == 0){
                    firstNum = convertRomanToNumeric(numerals[0]);
                }

                // The firstNum was set, therefore there were even pairs, but now there are odd
                else{
                    firstNum = 0;
                }
            }

            // If not a unique combination add the pair to the final number
            else{
                finalNum += n1 + n2;
            }
        }

        return finalNum + firstNum;
    }

    // Converts a roman numeral into a numeric digit
    private static int convertRomanToNumeric(char letter){
        // I = 1
        if (letter == 'I'){
            return 1;
        }

        // V = 5
        else if (letter == 'V'){
            return 5;
        }

        // X = 10
        else if (letter == 'X'){
            return 10;
        }

        // L = 50
        else if (letter == 'L'){
            return 50;
        }

        // C = 100
        else if (letter == 'C'){
            return 100;
        }

        // D = 500
        else if (letter == 'D'){
            return 500;
        }

        // The only other digit is M, which M = 1000
        else{
            return 1000;
        }
    }

    // Gets the first digit of a number
    private static int getFirstDigit(int n){
        while (n > 9){
            n /= 10;
        }

        return n;
    }
}