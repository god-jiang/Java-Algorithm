
/**
 * @author god-jiang
 * @date 2020/4/3  14:22
 */
public class Main {
    public static void main(String[] args) {
        String str1 = "god-jiang";
        String str2 = new String("god-jiang");
        String str3 = new String("god-jiang").intern();

        //false
        System.out.println(str1 == str2);
        //true
        System.out.println(str1 == str3);

        System.out.println("666");
    }
}
