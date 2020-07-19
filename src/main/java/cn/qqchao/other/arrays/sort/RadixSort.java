package cn.qqchao.other.arrays.sort;

import java.util.Arrays;

/**
 * 基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前。
 * 算法描述
 *
 *     取得数组中的最大数，并取得位数；
 *     arr为原始数组，从最低位开始取每个位组成radix数组；
 *     对radix进行计数排序（利用计数排序适用于小范围数的特点）
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {2,3,56,31,34,94,33,12,6,31};

        System.out.println(Arrays.toString(radixSort(arr)));
    }

    /**
     * 高位优先法
     *
     * @param arr 待排序列，必须为自然数
     */
    private static int[] radixSort(int[] arr) {
        //待排序列最大值
        int max = arr[0];
        int exp;//指数

        //计算最大值
        for (int anArr : arr) {
            if (anArr > max) {
                max = anArr;
            }
        }

        //从个位开始，对数组进行排序
        for (exp = 1; max / exp > 0; exp *= 10) {
            //存储待排元素的临时数组
            int[] temp = new int[arr.length];
            //分桶个数
            int[] buckets = new int[10];

            //将数据出现的次数存储在buckets中
            for (int value : arr) {
                //(value / exp) % 10 :value的最底位(个位)
                buckets[(value / exp) % 10]++;
            }

            //更改buckets[i]，
            for (int i = 1; i < 10; i++) {
                buckets[i] += buckets[i - 1];
            }

            //将数据存储到临时数组temp中
            for (int i = arr.length - 1; i >= 0; i--) {
                temp[buckets[(arr[i] / exp) % 10] - 1] = arr[i];
                buckets[(arr[i] / exp) % 10]--;
            }

            //将有序元素temp赋给arr
            System.arraycopy(temp, 0, arr, 0, arr.length);

        }
        return arr;
    }
}
