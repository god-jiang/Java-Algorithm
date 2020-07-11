package sort;

import java.util.Arrays;

/**
 * @author god-jiang
 * @date 2020/1/10
 */
public class HeapSort {

    //heapInsert就是建立大根堆
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    //heapify就是把堆顶和最后一个数交换位置，然后堆的大小size--
    public static void heapify(int[] arr, int index, int size) {
        int left = 2 * index + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if (largest == index)
                break;
            swap(arr, index, largest);
            index = largest;
            left = 2 * index + 1;
        }
    }
    
    //交换两个数
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //主函数
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6, 7, 0, 1, 2, 9, 8};
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            heapInsert(arr, i);
        }
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
        System.out.println(Arrays.toString(arr));
    }
}
