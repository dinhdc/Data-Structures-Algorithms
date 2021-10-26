package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Sorting {
    // get common character in string array
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int cntMatch = 0;
        int[] pMap = new int[256];
        for (char c : p.toCharArray()) {
            pMap[c]++;
        }
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char sChar = s.charAt(right);
            pMap[sChar]--;
            if (pMap[sChar] + 1 > 0) {
                cntMatch++;
            }
            while (cntMatch == p.length()) {
                if (right - left + 1 == p.length()) {
                    result.add(left);
                }
                sChar = s.charAt(left);
                pMap[sChar]++;
                if (pMap[sChar] - 1 >= 0) {
                    cntMatch--;
                }
                left++;
            }
        }
        return result;
    }

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

    // How Many Numbers Are Smaller Than the Current Number
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);
        for (int i = 0; i < nums.length ; i++) {
            int tmp = nums[i];
            nums[i] = findIndexOf(arr, tmp);
        }
        return nums;
    }

    // Count of Smaller Numbers After Self
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length-1;i++){
            int[] tmp = copyItem(nums, i+1);
            res.add(countValueSmaller(tmp, nums[i]));
        }
        res.add(0);
        return res;
    }

    // Minimum Number of Moves to Seat Everyone
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int i=0;
        int j=0;
        int numberOfMoves = 0;
        while(i < seats.length){
            if(seats[i] <= students[i]){
                numberOfMoves = numberOfMoves + students[i] - seats[i];
            }else{
                numberOfMoves = numberOfMoves + seats[i] - students[i];
            }
            i++;
        }
        return numberOfMoves;
    }

    // 1859. Sorting the Sentence
    public String sortSentence(String s) {
        return null;
    }

    private int findIndexOf(int[] nums, int value){
        int index = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == value){
                return i;
            }
        }
        return index;
    }

    private int countValueSmaller(int[] nums, int value){
        List<Integer> list = new ArrayList<>();
        for(Integer i : nums){
            list.add(i);
        }
        list.removeIf(p -> p >= value);
        return list.size();
    }

    private int[] copyItem(int[] src, int start){
        List<Integer> res = new ArrayList<>();
        for(int i=start; i<src.length;i++){
            res.add(src[i]);
        }
        return listToArray(res);
    }

    private int[] listToArray(List<Integer> list){
        int[] arr = new int[list.size()];
        int i = 0;
        for(Integer value: list){
            arr[i++] = value;
        }
        return arr;
    }
}
