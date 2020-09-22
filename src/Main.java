
/**
 * @author god-jiang
 * @date 2020/4/3  14:22
 */
public class Main {
    public static void main(String[] args) {
        String str="  this   is  a sentence ";
        System.out.println(reorderSpaces(str));
    }

    public static String reorderSpaces(String text) {
        // "\\s"表示空格，回车换行符等
        // "\\s+"就是说多个
        String[] strs = text.trim().split("\\s+");
        // 单词长度
        int charLen=0;
        for(String str:strs){
            charLen+=str.length();
        }

        // 空格长度
        int kongge=text.length()-charLen;
        int a=kongge/(charLen-1);
        int b=kongge%(charLen-1);

        StringBuilder sb=new StringBuilder();
        for(String str:strs){
            sb.append(str);
            for(int i=0;i<a;i++){
                sb.append(" ");
            }
        }

        for(int i=0;i<b;i++){
            sb.append(" ");
        }

        return sb.toString();
    }
}
