// Merge sort in Java

class MergeSort {

   static int comp = 0;
    // Merge two subarrays L and M into arr
    void merge(int arr[], int p, int q, int r) {
  
      int n1 = q - p + 1;
      int n2 = r - q;
  
      int L[] = new int[n1];
      int M[] = new int[n2];
  
      for (int i = 0; i < n1; i++)
        L[i] = arr[p + i];
      for (int j = 0; j < n2; j++)
        M[j] = arr[q + 1 + j];
  
      int i, j, k;
      i = 0;
      j = 0;
      k = p;
  
      while (i < n1 && j < n2) {
        if (L[i] <= M[j]) {
          comp++;
          arr[k] = L[i];
          i++;
        } else {
          comp++;
          arr[k] = M[j];
          j++;
        }
        k++;
      }
  
        while (i < n1) {
          comp++;
        arr[k] = L[i];
        i++;
        k++;
      }
  
      while (j < n2) {
        comp++;
        arr[k] = M[j];
        j++;
        k++;
      }
    }
  
    void mergeSort(int arr[], int l, int r) {
      if (l < r) {
  
        int m = (l + r) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
      }
    }
  
    // Print the array
    static void printArray(int arr[]) {
      int n = arr.length;
      for (int i = 0; i < n; ++i)
        System.out.print(arr[i] + " ");
      System.out.println();
    }
  
    // Driver program
    public static void main(String args[]) {

      MergeSort ob = new MergeSort();

      int arr[] = new ArrayGenerator().asc(200);
      ob.mergeSort(arr, 0, arr.length - 1);
      // printArray(arr);
      System.out.println("Best Case : Ascending Order");
      System.out.println("Number of comparisons required For "+arr.length+" length array is "+comp);

      // arr = new ArrayGenerator().desc(1000);
      // ob.mergeSort(arr, 0, arr.length - 1);
      // // printArray(arr);
      // System.out.println("wrost Case : Descending Order");
      // System.out.println("Number of comparisons required For "+arr.length+" length array is "+comp);

      // arr = new ArrayGenerator().random(500);
      // ob.mergeSort(arr, 0, arr.length - 1);
      // // printArray(arr);
      // System.out.println("Average Case : Random Order");
      // System.out.println("Number of comparisons required For "+arr.length+" length array is "+comp);

    }
  }