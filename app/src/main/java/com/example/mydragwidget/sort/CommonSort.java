package com.example.mydragwidget.sort;


import android.util.Log;

import java.util.Arrays;

public class CommonSort {
    private final static String TAG = "CommonSort";

    public static void main() {
        CommonSort sort = new CommonSort();

        sort.testSwap();

        int[] array = {5, 20, 1, 3, 9, 8, 10, 11, 12};
        int[] array2  = array.clone();
        int[] array3  = array.clone();
//        int[] array4  = array.clone();
//        int[] array5  = array.clone();

        Log.d(TAG, "selectionSort  before, res = " + Arrays.toString(array));
        Log.d(TAG, "selectionSort after, res = " + Arrays.toString(sort.selectionSort(array)));

        Log.d(TAG, "bubbleSort before, res = " + Arrays.toString(array2));
        Log.d(TAG, "bubbleSort after, res = " + Arrays.toString(sort.bubbleSort(array2)));

/*        Log.d(TAG, "quickSort before, res = " + Arrays.toString(array3));
        sort.quickSort(array3, 0, array3.length - 1);
        Log.d(TAG, "quickSort after, res = " + Arrays.toString(array3));*/

        int[] array4 = {20, 5, 10, 3, 1};
        Log.d(TAG, "megerSort before, res = " + Arrays.toString(array4));
        Log.d(TAG, "megerSort after, res = " + Arrays.toString(sort.mergeSort(array4, 0, array4.length - 1)));

        //

        int[] array5  = {11, 5, 20, 1, 3, 9, 8 ,10};
        sort.quickSort(array5, 0, array5.length - 1);
        Log.d(TAG, "quickSort = " + Arrays.toString(array5));
    }

    public void testSwap() {
        int a = 5;
        int b = 6;
        //1  可读性最好的
//        int t=a;a=b;b=t;
        //2
//        a=a+b;// a=11  b=6
//        b=a-b;// a=11   b=5
//        a=a-b;// a=6    b=5
        //3  性能最优（没有可读性）  无人机  跑步
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        Log.d(TAG, "a=" + a + "--- b=" + b);


    }

    // 稳定性
    public int[] selectionSort(int[] arr) {
        // 判空和检查长度
        if (null == arr || 1 >= arr.length) {
            return null;
        }

        for (int i = 0; i < arr.length; i++) {
            int k = i;

            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[k]) {
                    k = j;
                }
            }

            int tmp = arr[k];
            arr[k] = arr[i];
            arr[i] = tmp;
        }

//        return Arrays.toString(arr);
        return arr;
    }

    public int[] bubbleSort(int[] arr) {
        // 判空和检查长度
        if (null == arr || 1 >= arr.length) {
            return null;
        }

        int n = arr.length;
        if (n <= 1) return null;

        for (int i = 0; i < n; i++) {

            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = true;
                }
            }

            if (!flag) {
                break;
            }

        }


        return arr;
    }

    public void quickSort(int[] arr, int begin, int end) {
        if (null == arr || 1 >= arr.length) {
            return ;
        }

        if (begin >= end) {
            return ;
        }

        Log.d(TAG, "quickSort0 = " + Arrays.toString(arr));

        int low = begin;
        int high = end;
        int x = arr[begin];

        boolean direction = true;

        L1:
        while (low < high) {
            if (direction) {
                for (int i = high; i > low; i--) {
                    if (arr[i] <= x) {
                        arr[low] = arr[i];
                        ++low;
                        high = i;
                        direction = !direction;

                        Log.d(TAG, "quickSort1 = " + Arrays.toString(arr));
                        continue L1;
                    }
                }

                high = low;
            } else {
                for (int j = low; j < high; j++) {
                    if (arr[j] >= x) {
                        arr[high] = arr[j];
                        --high;
                        low = j;
                        direction = !direction;

                        Log.d(TAG, "quickSort2 = " + Arrays.toString(arr));
                        continue L1;
                    }
                }

                low = high;
            }
        }

        arr[low] = x;
        quickSort(arr, begin, low -1);
        quickSort(arr, low + 1, end);

//        return arr;
    }

    private int a = 0;
    private int b = 0;
    public int[] insertSort(int[] arr) {
        if (null == arr || 1 >= arr.length) {
            return null;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    int tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        return arr;
    }

    public int[] mergeSort(int[] arr, int left, int right) {
        Log.d(TAG, "mergeSort, left = " + left + ", right = " + right);
        if (null == arr || 1 >= arr.length) {
            return null;
        }

        Log.d(TAG, "mergeSort1, arr = " + Arrays.toString(arr));
        if(left == right) {
            return null ;
        } else {
            int mid = (left+right)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            merge(arr,left,mid+1,right);
        }

        return arr;
    }

    private void merge(int[] arr, int left, int mid, int right) {
        Log.d(TAG, "merge, arr = " + Arrays.toString(arr));
        Log.d(TAG, "merge, left = " + left + ", mid = " + mid +", right = " + right);

        int leftSize = mid - left;
        int rightSize = right - mid + 1;
        //生成数组
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        //填充数据
        for(int i = left;i < mid;i++){
            leftArray[i-left] = arr[i];
        }

        for(int i = mid;i <= right;i++){
            rightArray[i-mid] = arr[i];
        }

        Log.d(TAG, "merge, leftArray = " + Arrays.toString(leftArray));
        Log.d(TAG, "merge, rightArray = " + Arrays.toString(rightArray));

        //合并
        int i = 0;
        int j = 0;
        int k = left;
        while(i < leftSize && j < rightSize){
            if (leftArray[i] < rightArray[j]) {
                arr[k] = leftArray[i];
                k++;
                i++;
                Log.d(TAG, "merge, while1, leftArray = " + Arrays.toString(leftArray));
                Log.d(TAG, "merge, while1, rightArray = " + Arrays.toString(rightArray));
                Log.d(TAG, "merge, while1, arr = " + Arrays.toString(arr));
            } else {
                arr[k] = rightArray[j];
                k++;
                j++;
                Log.d(TAG, "merge, while2, leftArray = " + Arrays.toString(leftArray));
                Log.d(TAG, "merge, while2, rightArray = " + Arrays.toString(rightArray));
                Log.d(TAG, "merge, while2, arr = " + Arrays.toString(arr));
            }
        }

        while(i < leftSize){
            arr[k] = leftArray[i];
            k++;
            i++;

            Log.d(TAG, "merge, while3, leftArray = " + Arrays.toString(leftArray));
            Log.d(TAG, "merge, while3, arr = " + Arrays.toString(arr));
        }
        while(j < rightSize){
            arr[k] = rightArray[j];
            k++;
            j++;

            Log.d(TAG, "merge, while4, rightArray = " + Arrays.toString(rightArray));
            Log.d(TAG, "merge, while4, arr = " + Arrays.toString(arr));
        }

    }
}
