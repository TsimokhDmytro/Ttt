package SeleniumLessons.Lesson3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Lesson3HomeWork2 {

    public int summa (int a, int b) {
        return a+b;
    }
    public int division (int a, int b) {
        return a / b;
    }
    public int minus (int a, int b) {
        return a - b;

    }
        public int multiplication (int a, int b) {
            return a * b;
        }

    @Test
    public void test1 (){
        int res1 = summa(25,5);
        Assert.assertTrue(res1==30);
        System.out.println("Result test1 = " + res1);
    }

    @Test
    public void test2 (){
        int res2 = minus(80,95);
        Assert.assertTrue(res2==-15);
        System.out.println("Result test2 = " + res2);
    }

    @Test
    public void test3 (){
        int res3 = multiplication(100,520);
        Assert.assertEquals(res3,52000);
        System.out.println("Result test3 = " + res3);
    }

        @Test
        public void test4 (){
        int res4 = division(12,0);
            Assert.assertEquals(res4,2);
            System.out.println("Result test4 = " + res4);
        }
    }

