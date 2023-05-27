package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_Assertion {
    public int multification(int numbver1, int number2){
        return numbver1 * number2;
    }
    @Test
    public void validateMultificatons(){
        int actualResult= multification(3,4);
        int expecetdResult= 12;
//        if(actualResult==expecetdResult){
//            System.out.println("passed");
//        }else {
//            System.out.println("failled");
//        }
        Assert.assertEquals(actualResult,expecetdResult);

    }
    @Test
    public void validateZero(){
        int acrtualResult= multification(0,999);
        int expectedResult= 0;
        Assert.assertTrue(acrtualResult==expectedResult);

    }
    @Test
    public void validateNavigateWithPositive(){
        int actual=multification(-1,6);
        int exepected=-6;
        Assert.assertEquals(actual,exepected);

    }
    @Test
    public void validateNrgativeWithNegative(){
        int actual= multification(-2,-5);
        int expect= 10;
        Assert.assertEquals(actual,expect);

    }

}
