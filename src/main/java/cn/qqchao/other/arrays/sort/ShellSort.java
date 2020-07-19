package cn.qqchao.other.arrays.sort;

import java.util.Arrays;

/**
 * 1959年Shell发明，第一个突破O(n2)的排序算法，是简单插入排序的改进版。它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。
 * 算法描述
 *
 * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：
 *
 *     选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 *     按增量序列个数k，对序列进行k 趟排序；
 *     每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {2,3,56,31,34,94,33,12,6,31};

        System.out.println(Arrays.toString(shellSort(arr)));
    }

    static int[] shellSort(int[] arr) {
        int len = arr.length;
        for (int gap = len / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < len; i++) {
                int j = i;
                int current = arr[i];
                while (j - gap >= 0 && current < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j = j - gap;
                }
                arr[j] = current;
            }
        }
        return arr;
    }
}
