package com.kroyce;

import java.util.ArrayList;
import java.util.List;

public class IntegerDivision {

    public String makeDivision(int dividend, int divisor){
        if(divisor == 0){
            throw new IllegalArgumentException("Division by zero not allowed");
        }

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        if(dividend < divisor){
            return dividend + " / "+ divisor + " = 0";
        }

        StringBuilder result = new StringBuilder(getFirstThreeLines(dividend,divisor));
        List<Integer> numbersToDisplay = getNumbersToDisplay(dividend,divisor);
        result.append(getResultString(numbersToDisplay, dividend));

        return result.toString();
    }

    private String getResultString(List<Integer> list, int dividend){
        int spaces = 1;
        int digitPosition = 0;
        int flag = 0;
        StringBuilder result = new StringBuilder();
        String[] dividendDigits = String.valueOf(dividend).split("");

        for(int i = 2; i<list.size()-1; i++){
            if(i % 2 == 0){
                if(list.get(i-2) - list.get(i-1) == 0 ){
                    spaces++;
                    digitPosition++;
                }

                int difference = countDigits(list.get(i-2)) - (countDigits(list.get(i-2) - list.get(i-1)));
                spaces = spaces + difference;
                digitPosition = digitPosition + difference;

                while(digitPosition < dividendDigits.length && dividendDigits[digitPosition].equals("0") && list.get(i-2) - list.get(i-1) == 0){
                    spaces++;
                    digitPosition++;
                }

                result.append(cloneCharacter(' ',spaces-1)).append(cloneCharacter('_', 1)).append(list.get(i)).append('\n');

            }else{
                if(countDigits(list.get(i)) < countDigits(list.get(i-1))){
                    flag = 1;
                }

                result.append(cloneCharacter(' ', spaces+flag)).append(list.get(i)).append('\n');
                result.append(cloneCharacter(' ',spaces+flag)).append(cloneCharacter('-',countDigits(list.get(i)))).append('\n');
                flag = 0;
            }
        }
        result.append(cloneCharacter(' ', countDigits(dividend) - countDigits(list.get(list.size()-1))+1)).append(list.get(list.size()-1)).append('\n');

        return result.toString();
    }

    private List<Integer> getNumbersToDisplay(int dividend, int divisor){
        List<Integer> result = new ArrayList<>();
        String[] digits = Integer.toString(dividend).split("");
        StringBuilder string = new StringBuilder();
        Integer remainder = 0;
        int numToDisplay;
        int toSubtract;

        for(int i = 0; i < digits.length; i++) {
            string.append(digits[i]);
            numToDisplay = Integer.parseInt(string.toString());

            if(numToDisplay >= divisor){
                remainder = numToDisplay % divisor;
                toSubtract = numToDisplay / divisor * divisor;
                result.add(numToDisplay);
                result.add(toSubtract);
                string.replace(0,string.length(), remainder.toString());
            }
        }
        result.add(dividend % divisor);

        return result;
    }

    private String getFirstThreeLines(int dividend, int divisor){
        int leftDividendNum = findDividend(dividend,divisor);
        int flag = 0;
        String []digits = Integer.toString(dividend).split("");
        StringBuilder dividendAsStr = new StringBuilder(digits[0]);

        for(int i = 1; leftDividendNum > Integer.parseInt(dividendAsStr.toString());i++){
            dividendAsStr.append(digits[i]);
        }

        if(countDigits(Integer.parseInt(dividendAsStr.toString())) != countDigits(findDividend(dividend,divisor))){
            flag = 1;
        }

        String intFormat = cloneCharacter(' ', flag) + " %" + (countDigits(dividend) * -1 + flag) + "d";

        String lineOne = "_" + dividend + '|' + divisor + "\n";

        String lineTwo = String.format(intFormat, leftDividendNum) + '|';
        lineTwo = lineTwo + cloneCharacter('-', countDigits(dividend/divisor)) + "\n " + cloneCharacter(' ', flag);

        String lineThree = cloneCharacter('-', countDigits(leftDividendNum));
        lineThree = lineThree + cloneCharacter(' ', countDigits(dividend) - countDigits(leftDividendNum) - flag) + '|' + dividend/divisor;

        return lineOne+lineTwo+lineThree+"\n";
    }

    private int countDigits(int num) {
        if (num == 0){
            return 1;
        }

        int digits = 0;
        while (num > 0){
            digits++;
            num /= 10;
        }
        return digits;
    }

    public int findDividend(int dividend, int divisor){
        int digits = countDigits(dividend);
        double smallestDividend = dividend / Math.pow(10, digits - 1);
        while (smallestDividend < divisor){
            smallestDividend *= 10;
        }
        smallestDividend = (int)smallestDividend / divisor * divisor;

        return (int)smallestDividend;
    }

    private String cloneCharacter(char character, int times){
        StringBuilder sb = new StringBuilder();

        for(int i =0; i < times; i++){
            sb.append(character);
        }

        return sb.toString();
    }
}
