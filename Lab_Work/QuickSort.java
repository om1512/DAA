public class QuickSort {
    static int swaps = 0, cmp = 1; 
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int partition(int[] arr, int low, int high)
    {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            cmp++;
            if (arr[j] < pivot) {
                i++;
                swaps++;
                swap(arr, i, j);
            }
        }
        swaps++;
        swap(arr, i + 1, high);
        return (i + 1);
    }
    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    public static void main(String[] args) {
        int[] arr = new ArrayGenerator().asc(10000);
        int n = arr.length;
        // quickSort(arr, 0, n - 1);
        // System.out.println("Sorted Array of "+arr.length);
        // System.out.println("Comparisons : "+cmp);
        // System.out.println("Swaps : "+swaps);
        // arr = new ArrayGenerator().desc(1000);
        // int n = arr.length;
        quickSort(arr, 0, n - 1);
        System.out.println("Descending Array of "+arr.length);
        System.out.println("Comparisons : "+cmp);
        System.out.println("Swaps : "+swaps);
    }
}