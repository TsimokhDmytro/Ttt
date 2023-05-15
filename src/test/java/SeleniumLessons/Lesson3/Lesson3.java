package SeleniumLessons.Lesson3;

import org.testng.annotations.Test;

public class Lesson3 {
@Test
    public static int ddd() {
        int aaa = Integer.parseInt("13");
        System.out.println(aaa);
        return aaa;
    }


    public static int summa (int a, int b) {
        return a + b;
    }

    @Test
    public static void test3() {
        System.out.println(summa(3, 4));
//        Assert.assertEquals(a+b)
    }

}
