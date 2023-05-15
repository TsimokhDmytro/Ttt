package SeleniumLessons.Lesson3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Lesson3HomeWork1 {

    @Test
    public void summa() {
        int a = 5;
        int b = 6;
        int c = a + b;
        Assert.assertTrue(c == 11);
        System.out.println("Result a+b = " + c);
    }

    @Test
    public void minus() {
        int a = 10;
        int b = 6;
        int c = a - b;
        Assert.assertEquals(c, 4);
        System.out.println("Result a-b = " + c);
    }

    @Test
    public void multiplication() {
        double a = 51.78f;
        double b = 3.52f;
        double c = (float) (a * b);
        Assert.assertTrue(c == 182.2656f);
        System.out.println("Result a*b = " + c);
    }

    @Test
    public void division() {
        int a = 100;
        int b = 8;
        double c = (double) a / b;
        Assert.assertTrue(c == 12.5);
        System.out.println("Result a/b = " + c);
    }
}

