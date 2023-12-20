package br.com.aulas.restapi.Services;

import java.lang.Math;

public class MathServices {

    private Double parseNumber(String num){
        if(num == null)
            return 0D;
        
        String replacedDot = num.replaceAll(",", ".");

        return Double.parseDouble(replacedDot);

    }
    
    public Double sum(String number1, String number2){
        return parseNumber(number1) + parseNumber(number2);
    }

    public Double sub(String number1, String number2){
        return parseNumber(number1) - parseNumber(number2);
    }

    public Double mul(String number1, String number2){
        return parseNumber(number1) * parseNumber(number2);
    }

    public Double div(String number1, String number2){
        return parseNumber(number1) / parseNumber(number2);
    }

    public Double med(String number1, String number2){
        return (parseNumber(number1) + parseNumber(number2))/2;
    }

    public Double sqr(String number1){
        return Math.sqrt(parseNumber(number1));
    }
}
