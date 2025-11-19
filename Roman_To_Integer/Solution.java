package Roman_To_Integer;

//https://leetcode.com/problems/roman-to-integer/?envType=study-plan-v2&envId=top-interview-150
public class Solution{
    public static int romanToInt(String s){
        char[] numerals = s.toCharArray();
        int finalNum = 0;
        int firstNum = convertRomanToNumeric(numerals[0]);

        // Iterates through the roman numeral and converts all the letters into numeric numbers
        for (int i = 1; i < numerals.length; i++){
            finalNum += convertRomanToNumeric(numerals[i]);
        }

        // If the roman numeral has 2 letters and the first letter is less than the last.
        // This indicates the roman numeral is one of the unique few that have the smaller digit in front
        if (numerals.length == 2 && firstNum < finalNum){
            finalNum -= firstNum;
        }

        // If not one of the unique roman numerals, simply add the first number to the sum
        else{
            finalNum += firstNum;
        }

        return finalNum;
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
}