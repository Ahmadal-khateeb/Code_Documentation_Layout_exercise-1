import java.util.*;

/**
 * This class demonstrates sorting algorithms including Quick Sort and Merge Sort.
 * It sorts two sample arrays and prints the results.
 * 
 * @author ahmad alkhateeb - 202110492
 * @version 1.0
 */
public class SortExample {

    /**
     * The main method to demonstrate sorting.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // This is an unsorted array
        Integer[] array1 = new Integer[] { 12, 13, 24, 10, 3, 6, 90, 70 };
        int[] array2 = { 2, 6, 3, 5, 1 };

        // Let's sort using quick sort
        quickSort(array1, 0, array1.length - 1);
        // Verify sorted array
        System.out.println(Arrays.toString(array1));

        // Sort using merge sort
        mergeSort(array2, array2.length);
        // Verify sorted array
        System.out.println(Arrays.toString(array2));
    }

    /**
     * Sorts the given array using the Quick Sort algorithm.
     * 
     * @param arr  The array to be sorted.
     * @param low  The starting index.
     * @param high The ending index.
     */
    public static void quickSort(Integer[] arr, int low, int high) {
        if (arr == null || arr.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }

        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        int i = low, j = high;

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(arr, low, j);
        }
        if (high > i) {
            quickSort(arr, i, high);
        }
    }

    /**
     * Swaps two elements in an array.
     * 
     * @param array The array containing elements.
     * @param x     Index of the first element.
     * @param y     Index of the second element.
     */
    public static void swap(Integer[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    /**
     * Sorts the given array using the Merge Sort algorithm.
     * 
     * @param a The array to be sorted.
     * @param n The number of elements in the array.
     */
    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }

        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }

        mergeSort(l, mid);
        mergeSort(r, n - mid);
        merge(a, l, r, mid, n - mid);
    }

    /**
     * Merges two subarrays into the original array.
     * 
     * @param a     The destination array.
     * @param l     Left subarray.
     * @param r     Right subarray.
     * @param left  Size of the left subarray.
     * @param right Size of the right subarray.
     */
    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }

        while (i < left) {
            a[k++] = l[i++];
        }

        while (j < right) {
            a[k++] = r[j++];
        }
    }

    /**
     * Checks if the given array is sorted in ascending order.
     * 
     * @param x The array to be checked.
     * @return true if sorted, false otherwise.
     */
    private static boolean isSorted(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            if (x[i] > x[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
