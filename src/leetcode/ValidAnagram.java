package leetcode;

import java.util.Arrays;
import java.util.Objects;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        return Objects.equals(sortString(s), sortString(t));
    }

    public String sortString(String s){
        Character[] chars = new Character[s.length()];

        // For each character in the String
        // add it to the List
        for (int i = 0; i<s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        Arrays.sort(chars);
        String res = "";
        for(int i = 0; i < s.length(); i++){
            res = res + chars[i];
        }
        System.out.println(res);
        return res;
    }
}
