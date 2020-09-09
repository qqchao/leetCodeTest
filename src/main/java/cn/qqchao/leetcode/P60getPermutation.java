package cn.qqchao.leetcode;

public class P60getPermutation {

    public static void main(String[] args) {
        System.out.println(getPermutation(8, 40320));
    }

    public static String getPermutation(int n, int k) {

        int factorial[] = {0,1,2,6,24,120,720,5040,40320};
        int numList[] = {1,2,3,4,5,6,7,8,9};
        int moveSteps[] = new int[8];

        k-=1;
        for (int i = n-1; i > 0; i--) {
            moveSteps[n-1-i] = k/(factorial[i]);
            k = k % factorial[i];
        }

        for (int i = 0; i < n-1; i++) {
            if (moveSteps[i]>0) {
                arrayMove(numList, i, moveSteps[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(numList[i]);
        }
        return sb.toString();
    }

    static void arrayMove(int[] array, int index, int step){
        int temp = array[index+step];
        for (int i = index + step - 1; i >= index ; i--) {
            array[i+1] = array[i];
        }
        array[index] = temp;
    }
}
