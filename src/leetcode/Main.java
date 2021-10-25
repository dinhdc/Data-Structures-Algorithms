package leetcode;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ValidAnagram v = new ValidAnagram();
        //FindAllAnagramInString f = new FindAllAnagramInString();
        //List<Integer> res = f.findAnagrams("aa","bb");
        //if(res == null){
          //  System.out.println("empty");
        //}
        if (v.isAnagram("aa", "bb")) {
            System.out.println("empty");
        } else {
            System.out.println("not empty");
        }
    }
}
