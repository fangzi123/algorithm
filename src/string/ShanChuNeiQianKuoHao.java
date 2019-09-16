package string;

/**
 * @author wangff
 * @date 2019/9/16 14:37
 */
public class ShanChuNeiQianKuoHao {
   public static String shanChuNeiQianKuoHao(char[] chars){
       if (chars.length==0) {
           throw new RuntimeException();
       }
       if (chars[0] != '('&&chars[chars.length-1]!=')') {
           throw new RuntimeException();
       }
       StringBuilder sb = new StringBuilder("(");
       int num = 0;
       for (int i = 1; i < chars.length-1; i++) {
           if (chars[i]=='(') {
               num++;
           }else if(chars[i]==')'){
               num--;
               if (num <0) {
                   throw new RuntimeException();
               }
           }else{
               sb.append(chars[i]);
           }
       }
       sb.append(')');
       return sb.toString();
   }

    public static void main(String[] args) {
        String a = "(a,b,((b),n,b),m)";
        System.out.println(shanChuNeiQianKuoHao(a.toCharArray()));
    }
}
