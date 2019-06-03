package myCode;

import jdk.nashorn.internal.objects.Global;
import myCode.CalculatorImpl;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CalculatorTestNGTest
{
    private CalculatorImpl CALC;

    @BeforeClass
    public void setUpClass() throws Exception 
    {
        CALC=new CalculatorImpl();
    }
    
    @Test(expectedExceptions = AssertionError.class)
    private void zeroTest()
    {
        double res = CALC.calculate("0");
        assertEquals(res, 1.0,"Ошибка_1 ! zeroTest");
    }
    
    @Test
    public void floatingPointTest() 
    {
        double res = CALC.calculate("-3000.02");
        assertEquals(res, -3000.02,"Ошибка_1 ! floatingPointTest");
        //assertEquals(-3000.02, resl,1e-9);
    }
    @Test
    public void addTest_1() 
    {
        double res = new CalculatorImpl().calculate("30.4/2");
        assertEquals(res, 15.2,"Ошибка_1 ! addTest_1");
        //assertEquals(15.2, resl,1e-9);
    }
    @Test
    public void addTest_2() 
    {
        double res = new CalculatorImpl().calculate("(2+2)*1.5/10-444");
        assertEquals(res, -443.4,"Ошибка_1 ! addTest_2");
        //assertEquals(-443.4, resl,1e-9);
    }
    @Test
    public void functionTest() 
    {
        double res = new CalculatorImpl().calculate("sin(1)*sin(1)+cos(1)*cos(1)");
        assertEquals(res, 1.0,"Ошибка_1 ! functionTest");
        //assertEquals(1, resl,1e-9);
    }
    @Test
    public void divideByZero() 
    {
        double res = new CalculatorImpl().calculate("1234/0");
        assertEquals(res, Global.Infinity,"Ошибка_1 ! divideByZero");
        //assertEquals(Global.Infinity, resl,1e-9);
    }
}
