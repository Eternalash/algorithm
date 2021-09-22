package per.rost.pom.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:bryan.c
 * Date:2021/9/16
 */
public class ByteDancePermutation {

    private static final ByteDancePermutation INSTANCE=new ByteDancePermutation();

    static List<String> res=new ArrayList<>();

    public static void main(String... args) {
        INSTANCE.permutation("abc",0);
        System.out.println(res);
    }

    public void permutation(String str,int start){
        if (str.length()==0){
            return;
        }
        for(int i=0;i<str.length();i++){

        }
    }
}
