package Integer_To_Roman;

public class Solution {
    public static String intToRoman(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        String numToString = "";

        for (int i = 0; i < digits.length; i++){
            int power = (int) (Math.pow(10, (digits.length - 1) - i));
            int n = Character.getNumericValue(digits[i]);

            if (n == 0){
                continue;
            }
            else{
                numToString += convertToRoman(n * power, power);
            }
        }

        return numToString;
    }

    public static String convertToRoman(int num, int power){
        String numToString = "";

        if (num / power == 4 || num / power == 9){
            numToString += convertToRoman(power, 1);
            num += power;
        }

        while(num > 0){
            // If greater than or equal to 1000 add a M to the numeral
            if (num >= 1000){
               numToString += "M";
               num -= 1000; 
            }

            // If greater than or equal to 500 add a D to the numeral
            else if (num >= 500){
               numToString += "D";
               num -= 500; 
            }

            // If greater than or equal to 100 add a C to the numeral
            else if (num >= 100){
               numToString += "C";
               num -= 100; 
            }

            // If greater than or equal to 50 add a L to the numeral
            else if (num >= 50){
               numToString += "L";
               num -= 50; 
            }

            // If greater than or equal to 10 add a X to the numeral
            else if (num >= 10){
               numToString += "X";
               num -= 10; 
            }

            // If greater than or equal to 5 add a V to the numeral
            else if (num >= 5){
               numToString += "V";
               num -= 5; 
            }

            // If greater than or equal to 1 add a I to the numeral
            else if (num >= 1){
               numToString += "I";
               num -= 1; 
            }
        }


        return numToString;
    }
}