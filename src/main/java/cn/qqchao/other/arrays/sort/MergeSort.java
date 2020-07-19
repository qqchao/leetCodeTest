package cn.qqchao.other.arrays.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
 * 算法描述:
 *
 *     把长度为n的输入序列分成两个长度为n/2的子序列；
 *     对这两个子序列分别采用归并排序；
 *     将两个排序好的子序列合并成一个最终的排序序列。
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr1 = {2,3,56,31,34,94,33,12,6,31};

        List<Integer> arr = new ArrayList();
        arr.add(2);
        arr.add(3);
        arr.add(56);
        arr.add(31);
        arr.add(34);
        arr.add(94);
        arr.add(33);
        arr.add(23);
        arr.add(6);
        arr.add(42);
        arr.add(23);
        System.out.println(mergeSort(arr).toString());
    }

    static List<Integer> mergeSort(List<Integer> arr) {
        int len = arr.size();
        if (len < 2) {
            return arr;
        }
        int middle = len / 2;
        List<Integer> left = arr.subList(0, middle);
        List<Integer> right = arr.subList(middle, len);
        System.out.println(left.toString());
        System.out.println(right.toString());
        return merge(mergeSort(left), mergeSort(right));
    }

    /**
     * ArrayList————Exception in thread "main" java.util.ConcurrentModificationException
     */
    static List<Integer> mergePre(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList();

        while (left.size()>0 && right.size()>0) {
            if (left.get(0) <= right.get(0)) {
                result.add(left.remove(0));
            } else {
                result.add(right.remove(0));
            }
        }

        while (left.size()>0)
            result.add(left.remove(0));

        while (right.size()>0)
            result.add(right.remove(0));

        return result;
    }

    static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList();

        int leftIndex = 0, rightIndex = 0;

        for (int i = 0; i < left.size() + right.size(); i++){
            if ((leftIndex < left.size() && rightIndex < right.size())) {
                if (left.get(leftIndex) <= right.get(rightIndex)){
                    result.add(left.get(leftIndex++));
                } else {
                    result.add(right.get(rightIndex++));
                }
            } else if (leftIndex < left.size()) {
                result.add(left.get(leftIndex++));
            } else {
                result.add(right.get(rightIndex++));
            }
        }

        return result;
    }
}
