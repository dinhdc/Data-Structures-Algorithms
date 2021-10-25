package arrays;

public class Main {

    public static void main(String[] args) {
        // constructor with size n
        int[] intArrays = new int[7];

        intArrays[0] = 20;
        intArrays[1] = 20;
        intArrays[2] = 20;
        intArrays[3] = 20;
        intArrays[4] = 20;
        intArrays[5] = 20;
        intArrays[6] = 20;

        for (int i = 0; i < intArrays.length; i++){
            System.out.println(intArrays[i]);
        }
    }
}
