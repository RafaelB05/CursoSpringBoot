package br.com.aulas.restapi.Controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.aulas.restapi.Exception.UnsuportedOperationMathException;
import br.com.aulas.restapi.Services.MathServices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class MathController {

    private MathServices calculadora = new MathServices();

    private void numericVerify(String number1, String number2) {
    if(!isNumeric(number1) || !isNumeric(number2))
        throw new UnsuportedOperationMathException("Please set numeric value");
    };

    private void numericVerify(String number1) {
    if(!isNumeric(number1))
        throw new UnsuportedOperationMathException("Please set numeric value");
    };

    private boolean isNumeric( String num){
        if(num == null)
            return false;
        
        String replacedDot = num.replaceAll(",", ".");
        return replacedDot.matches("[+-]?[0-9]*\\.?[0-9]+");
    }

    @GetMapping(value = "/sum/{number1}/{number2}")
    public Double sum(@PathVariable(value = "number1")String number1, @PathVariable(value = "number2") String number2) throws Exception{
        
        numericVerify(number1, number2);

        return calculadora.sum(number1, number2);
    };
        
    @GetMapping(value = "/sub/{number1}/{number2}")
    public Double sub(@PathVariable(value = "number1")String number1, @PathVariable(value = "number2") String number2) throws Exception{

        numericVerify(number1, number2);
        return calculadora.sub(number1, number2);
    };

    @GetMapping(value = "/mul/{number1}/{number2}")
    public Double mul(@PathVariable(value = "number1")String number1, @PathVariable(value = "number2") String number2) throws Exception{

        numericVerify(number1, number2);
        return calculadora.mul(number1, number2);
    };

    @GetMapping(value = "/div/{number1}/{number2}")
    public Double div(@PathVariable(value = "number1")String number1, @PathVariable(value = "number2") String number2) throws Exception{

        numericVerify(number1, number2);
        if(number2.equals("0"))
            throw new UnsuportedOperationMathException("Division by 0 is not possible");
        
        return calculadora.div(number1, number2);
    };

    @GetMapping(value = "/med/{number1}/{number2}")
    public Double med(@PathVariable(value = "number1")String number1, @PathVariable(value = "number2") String number2) throws Exception{
        
        numericVerify(number1, number2);
        return calculadora.med(number1, number2);
    }

    @GetMapping(value = "/sqr/{number1}")
    public Double sqr(@PathVariable(value = "number1")String number1) throws Exception{
        numericVerify(number1);
        return calculadora.sqr(number1);
    };
    
    
}
