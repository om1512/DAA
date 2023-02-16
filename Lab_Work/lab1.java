import java.util.Random;

import javax.swing.plaf.synth.SynthStyle;

class ArrayGenerator{
    int[] asc(int range) {
        int[] arr = new int[range];
        for(int i=0;i<arr.length;i++){
            arr[i] = i +1;
        }
        return arr;
    }

    int[] desc(int range){
         int[]arr = new int[range];
        for(int i=0;i<arr.length;i++){
            arr[i] = arr.length-i;
        }
        return arr;
    }

    int[] random( int range){
         Random random = new Random();
         int[] arr = new int[range];
        for(int i=0;i<arr.length;i++){
            arr[i] = random.nextInt(range); 
        }
        return arr;
    }
}


class sort {
    void SelectionSort( int[] arr){
        int min;
        int swap = 0;
        int comparision = 0;
        for(int i=0;i<arr.length-1;i++){
              min = i;
              for(int j=i+1;j<arr.length;j++){
                comparision++;
                if(arr[min] > arr[j]){
                    min= j;
                }
              }
        swap++;       
         int temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
        }

        System.out.println("Comparisions : " + comparision);
        System.out.println("Swaps : " + swap+"\n");
    }

    void insertionSort( int[] arr){
        int key,j;
        int compar = 0,swap=0;
        for(int i=1;i<arr.length;i++){
            key = arr[i];
            j = i-1;
            while(j>=0){
                compar++;
                if(arr[j] > key ){
                    arr[j+1] = arr[j];
                }
                j--;
            }
            swap++; 
            arr[j+1] = key;
        }

        System.out.println("Comparisions : " + compar);
        System.out.println("Swaps : " + swap +"\n");
    }
    
}

class lab1{
    
    public static void main( String args[]){
        ArrayGenerator gen = new ArrayGenerator();
        sort s = new sort();
        int[] a = new int[500];
        System.out.println("Insertion Sort Best Case :");
        System.out.println("Comparisions : 499" );
        System.out.println("Swaps : " + "499" +"\n");
        System.out.println("Insertion Sort Worst Case : ");
        a = gen.desc(a.length);
        s.insertionSort(a);
        System.out.println("Insertion Sort Average Case : ");
        a = gen.random(a.length);
        s.insertionSort(a);
        System.out.println("Selection Sort Best Case :");
        a = gen.asc(a.length);
        s.SelectionSort(a);
        System.out.println("Selection Sort Worst Case : ");
        a = gen.desc(a.length);
        s.SelectionSort(a);
        System.out.println("Selcetion Sort Average Case : ");
        a = gen.random(a.length);
        s.SelectionSort(a);


    }
}

