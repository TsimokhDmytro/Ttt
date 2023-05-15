//package SeleniumLessons.Lesson6.Pages;
//
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//public class Lesson10 {
//    @DataProvider(parallel = true)
//    public Object [][] setUp(){
//        return new Object[][]{
//                {"user", "12345"},
//                {"user", "12345366"},
//                {"user"}
//        };
//
//    }
//    @Test(dataProvider = "setUp")
//    public void checkRegister1 (String name, String password){
//        System.out.println(name + password);
//    }
//    @Test()
//    public void checkRegister2 (){
//        System.out.println("Hi2");
//    }
//    @Test
//    public void checkRegister3 (){
//        System.out.println("H3");
//    }
//    @Test
//    public void checkRegister4 (){
//        System.out.println("H4");
//    }
//}
