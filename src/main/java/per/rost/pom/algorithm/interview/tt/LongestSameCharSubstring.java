package per.rost.pom.algorithm.interview.tt;

/**
 * Author:bryan.c
 * Date:2021/9/22
 */
public class LongestSameCharSubstring {

    private static final LongestSameCharSubstring INSTANCE=new LongestSameCharSubstring();

    public static void main(String... args){
        System.out.println(INSTANCE.findLongestSameCharSubstring("sssEFdddDDDDd"));
    }

    public String findLongestSameCharSubstring(String str){
        String res="";
        int max=1,curLen=1;
        char pre = 0;
        for (int i =0;i<str.length();i++){
            if (!String.valueOf(str.charAt(i)).equalsIgnoreCase(String.valueOf(pre))){
                pre=str.charAt(i);
                res= String.valueOf(str.charAt(i));
            }else {
                res+=str.charAt(i);
            }
            curLen++;
            if (curLen>=max){
                max=curLen;
            }
        }
        return res;
    }
}
