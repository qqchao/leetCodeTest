package cn.qqchao.other.arrays;

import cn.qqchao.other.arrays.sort.QuickSort;

import java.util.Arrays;

/**
 * 查找数组arr中第k小的奇数,如果不存在则返回0. (arr[i] > 0 (i>=0))
 * 计算出时间复杂度和空间复杂度（注意代码注释，不要用O(n^2)的排序算法，不要使⽤库函数或脚本中已经实现好的排序算法和⼯具, 需要⾃⼰实现数据结构和所需要的算法）
 * 格式:
 * public int findKth(int[] arr, int k){
 *
 * //代码
 * }
 */


public class FIndKthOddNum {

    public static void main(String[] args) {
        int[] arr = {3,22,43,12,46,32,33,56,99,23,47,111,231,5,9,11};

        System.out.println(findKth(arr, 5));
    }

    public static int findKth(int[] arr, int k){

        QuickSort.quickSort(arr);

        System.out.println(Arrays.toString(arr));

        int oddOrder = 0;

        for (int index = 0; index < arr.length; index++){
            if (arr[index] % 2 == 1 && ++oddOrder == k) {
                return arr[index];
            }
        }

        return 0;
    }
}
