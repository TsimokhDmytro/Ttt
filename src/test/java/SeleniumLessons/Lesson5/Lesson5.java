package SeleniumLessons.Lesson5;

public class Lesson5 {
    public static void main(String[] args) {
        Lesson5 lesson5 = new Lesson5();
        lesson5.printNumber(13);
        lesson5.getStringLength("Education");
        lesson5.evenNumber(257);
        lesson5.stringReverseStringBuffer("Good luck");
        lesson5.stringReverseStringBuilder("Lesson");
    }

    public int printNumber(int a) {
        System.out.println(a);
        return a;
    }

    public int getStringLength(String srting1) {
        System.out.println("Srting lenght " + "'" + srting1 + "'" + " = " + srting1.length() + " chars");
        return srting1.length();
    }

    public Lesson5 evenNumber(int chislo) {
        if (chislo % 2 == 0) {
            System.out.println("Число " + "'" + chislo + "'" + " є парне");
        } else {
            System.out.println("Число " + chislo + " не є парне");
        }
        return this;
    }

    public String stringReverseStringBuffer(String string2) {
        System.out.print("Reverse string " + "'" + string2 + "'" + " 1-st method: " + "'" + new StringBuffer(string2).reverse() + "'");
        return new StringBuffer(string2).reverse().toString();
    }

    public String stringReverseStringBuilder(String string3) {
        StringBuilder sb = new StringBuilder(string3.length());
        for (int i = string3.length() - 1; i >= 0; i--) {
            sb.append(string3.charAt(i)).toString();
        }
        System.out.print("\n" + "Reverse string " + "'" + string3 + "'" + " 2-nd method: " + "'" + sb + "'");
        return sb.toString();
    }
}
