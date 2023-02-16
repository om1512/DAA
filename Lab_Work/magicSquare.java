class magicSquare{


    static void magicSquare(int n){
        int[][] arr = new int[n][n];
        int row = n/2,column = n-1;
        for(int i=1;i<=(n*n);i++){
           
            if(row == -1 && column != n){
                    row = n-1;
                    arr[row][column] = i;
                }else if(row == -1 && column == n){
                    column = 0;
                    arr[row][column] = i;
                }
              if(arr[row][column]==0){
                row++;
                column = column-2;
                if(row != -1 && column != n){
                    arr[row][column] = i;
                }else if(row == -1 && column != n){
                    row = n-1;
                    arr[row][column] = i;
                }else if(row == -1 && column == n){
                    column = 0;
                    arr[row][column] = i;
                }else if(row == -1 && column == n){
                    row = 0;
                    column = n-2;
                    arr[row][column] = i;
                }
            }else{
                row = row -1;
                column = column+1;
                    arr[row][column] = i;

            }
            column++;
            row--;
        }

        for(int[] i : arr){
            for(int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        magicSquare(3);
    }
}