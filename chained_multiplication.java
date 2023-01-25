

class chained_multiplication{
    static void runner(int[] p){
        int n = p.length -1;
        int[][]c = new int[n+1][n+1];
        int[][]k = new int[n+1][n+1];
        for(int l=2;l<=n;l++){
            for(int i=1;i<=(n-l+1);i++){
                int j = i+l-1;
                c[i][j] = Integer.MAX_VALUE;
                for(int x=i;x<j;x++){
                    int q = (c[i][x]+c[x+1][j])+(p[i-1]*p[x]*p[j]);
                    if(q < c[i][j]){
                        c[i][j]= q;
                        k[i][j]= x;
                    }
                }
            }
        }

        System.out.println("MiniMum number of multiplication : ");
        for(int a[] : c){
            for(int b:a){
                System.out.print(b + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Valid Cuts Non Recursive : ");
        for(int r[] : k){
            for(int s:r){
                System.out.print(s + " ");
            }
            System.out.println();
        }  
        System.out.println("\nOptimul Pattern ");
        print_optimum_pattern(p, k, 1, 4);
    }

    static void print_optimum_pattern(int[]p,int [][]k,int i,int j){
        if(i==j){
            System.out.print("A"+i+ " ");
        }else{
            System.out.print("(");
            print_optimum_pattern(p, k, i, k[i][j]);
            print_optimum_pattern(p, k, k[i][j]+1, j);
            System.out.print(")");
        }
    }

    public static void main(String args[]){
        int[] p = {3,5,4,7,2};
        runner(p);
    }
}