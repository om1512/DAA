class changeMaker{
  int amount;
  int[] denomination;
  changeMaker(int[] denomination,int amount){
    this.amount = amount;
    this.denomination = denomination;
    makeChange(denomination, amount);
  }
  void makeChange(int[] denomination,int amount){
    int[][] matrix = new int[denomination.length+1][amount+1];
    for(int i=0;i<=denomination.length;i++){
        matrix[i][0] = 0;
    }
    for(int i=0;i<=amount;i++){
      matrix[0][i] = 0;
    }
    for(int i=0;i<=denomination.length;i++){
      for(int j=0;j<=amount;j++){
        if(i>0 && j>0 && i == 1){
          if(j<denomination[i-1]){
            matrix[i][j] = Integer.MAX_VALUE;
          }else{
            matrix[i][j] = 1 + matrix[i][j-denomination[1-1]];
          }
        }else if(i>0 && j>0){
          if(j<denomination[i-1]){
            matrix[i][j] = matrix[i-1][j];
          }else{
            matrix[i][j] = Math.min(matrix[i-1][j],1+ matrix[i][j-denomination[i-1]]);
          }
        }
      }
    }
    System.out.println();
    for(int[] i:matrix){
      for(int j:i){
        System.out.print(j + "   ");
      }
      System.out.println();
    }
  } 
}
public class DPMakingChange {
  public static void main(String[] args) {
    int[] denomination = {1,4,6};
    new changeMaker(denomination,12);
  }
}

