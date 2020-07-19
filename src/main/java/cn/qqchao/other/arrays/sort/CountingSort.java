package cn.qqchao.other.arrays.sort;

import java.util.Arrays;

/**
 * 计数排序不是基于比较的排序算法，其核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。
 * 算法描述
 *
 *     找出待排序的数组中最大和最小的元素；
 *     统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
 *     对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
 *     反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {2,3,56,31,34,94,31,3,31,3,12,6,31};

        System.out.println(Arrays.toString(countingSort(arr, 95)));
    }

    static int[] countingSort(int[] arr, int maxValue) {
        int[] bucket = new int[maxValue + 1];
        int sortedIndex = 0;
        int arrLen = arr.length;
        int bucketLen = maxValue + 1;

        for (int i = 0; i < arrLen; i++) {
            bucket[arr[i]]++;
        }

        for (int j = 0; j < bucketLen; j++) {
            while(bucket[j] > 0) {
                arr[sortedIndex++] = j;
                bucket[j]--;
            }
        }

        return arr;
    }
}
