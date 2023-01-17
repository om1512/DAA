public class makingChange {
 
    static int[] denominationsSort(int[] arr){
        for(int i = 0;i<arr.length;i++){
            int min = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j] >  min){
                    min= j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
    static void change(int value){
        int[] denominations = {1,4,6};
        denominations = denominationsSort(denominations);
        int i = 0;
        while(value > 0)
        if(value>=denominations[i]){        
                value=value-denominations[i];
                System.out.println(denominations[i]);
            }
            else
            {
                i++;
            }
    }
    public static void main(String[] args) {
        change(8);
    }
}
