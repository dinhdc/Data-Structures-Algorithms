package leetcode;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Sorting s = new Sorting();
        int[] src = {8,1,2,2,3};
        List<Integer> res = s.countSmaller(src);
        for (int value:res) {
            System.out.println(value + " ");
        }
    }
}
