class MED{
  char[][] status;
  int[][] T;
  int e = 0,d = 0,i = 0,c = 0;
  void stringChange(String x,String y){
      char[] str1 = x.toCharArray();
      char[] str2 = y.toCharArray();
      T = new int[x.length()+1][y.length()+1];
      status = new char[x.length()+1][y.length()+1];
      int min = 0;
      int m = x.length();
      int n = y.length();
      for(int i=0;i<=m;i++){
          T[i][0] = i;
      }
      for(int i=1;i<=n;i++){
          T[0][i] = i;
      }
      for(int i=1;i<=m;i++){
          for(int j=1;j<=n;j++){
              min= Integer.min(T[i-1][j],T[i][j-1])+1;
              T[i][j] = Integer.min(min, T[i-1][j-1] + ((str1[i-1] == str2[j-1])?0:2));
          }
      }
      for(int i=1;i<=m;i++){
        for(int j=1;j<=n;j++){
            if(T[i][j] == T[i-1][j-1] + 2){
              status[i][j] = 'E';
            }else if(T[i][j] == T[i-1][j-1]){
                status[i][j] = 'C';
            }else if(T[i][j] == T[i-1][j]+1){
                status[i][j] = 'D';
            }else if(T[i][j] == T[i][j-1]+1){
                status[i][j] = 'I';
            }
          }
        }
      System.out.println("To Change String : "+min);


      for(int[]i :T){
          for(int j:i){
              System.out.print(j +" ");
          }
          System.out.println("");
      }
    
      for(char[]i :status){
        for(char j:i){
            System.out.print(j +" ");
        }
        System.out.println("");
    }
  }
  void counter(int i,int j){
    if(i == 0 && j == 0){
      return;
    }else{
          if(status[i][j] == 'C'){
              counter(i-1, j-1);
              c++;
          }else if(status[i][j] == 'E'){
              counter(i-1, j-1);
              e++;
          }else if(status[i][j] == 'I'){
              counter(i, j-1);
              i++;
          }else if(status[i][j] == 'D'){
              counter(i-1, j);
              d++;
          }
      } 
  }
  public static void main(String[] args) {
    MED m = new MED();  
    m.stringChange("RAM","ROM");
    m.counter(3, 3);
    System.out.println();
    System.out.println("Exchange : "+m.e);
    System.out.println("Delete : "+m.d);
    System.out.println("Insert : "+m.i);
    System.out.println("Copy : "+m.c);
  }
}
