package br.com.aulas.restapi.Controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class MathController {

        @GetMapping(value = "/sum/{number1}/{number2}")
        public Double sum(@PathVariable(value = "number1")String number1, @PathVariable(value = "number2") String number2) throws Exception{
            
            if(!isNumeric(number1) || !isNumeric(number2)){
                throw new Exception();
            }
            return parseNumber(number1) + parseNumber(number2);

        };
        
        private Double parseNumber(String num){
            if(num == null)
                return 0D;
            
            String replacedDot = num.replaceAll(",", ".");
            if(isNumeric(num)){
                 return Double.parseDouble(replacedDot);
            }

            return 0D;
        }

        private boolean isNumeric( String num){
            if(num == null)
                return false;
            
            String replacedDot = num.replaceAll(",", ".");
            return replacedDot.matches("[+-]?[0-9]*\\.?[0-9]+");
        }
    
}
