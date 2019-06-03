package myCode;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
/**
 *
 * @author user
 */
public class CalculatorImpl implements Calculator
{
    @Override
    public double calculate(String expression) 
    {
        ScriptEngine sctegn = new ScriptEngineManager().getEngineByName("nashorn");
        try
        {
            defineMathFunctions(sctegn);
            return ((Number) sctegn.eval(expression)).doubleValue();
        }catch( ScriptException e)
        {
            throw new IllegalArgumentException("Failed to evaluate expression",e);
        }
        //return Double.parseDouble(expression);
       // throw new UnsupportedOperationException();
    }
    
    private static void defineMathFunctions( ScriptEngine egn)throws ScriptException
    {
        for(String funcn:new String[] {"sin","cos","sqrt"})
        {
            egn.eval("function "+funcn+"(x) {return Java.type('java.lang.Math')."+funcn+"(x); }");
        }
    }
}
