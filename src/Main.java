import java.util.Arrays;

public class Main {

    public  static void main(String[] args) {
        String str = "dc,e4,19,e7,ae,8a,83,f2,06,64,59,c8,f3,ff,51,99,4a,f9,a5,cd,4d,0a,44,cf,1a,01,50,8e,1c,a9,97,e0";
        String[] strs=str.split(",");
        String[] num = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            num[i]=Long.parseLong(strs[i], 16)+",";
        }

        StringBuffer str5 = new StringBuffer();
        for (String s : num) {
            str5.append(s);
        }
        System.out.println(str5.toString()); // 012345
    }
}
