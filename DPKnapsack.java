import java.util.ArrayList;

class items {
    int profit;
    int weight;
    items(int profit,int weight){
        this.profit = profit;
        this.weight =weight;
    }

    int getWeight(){
        return weight;
    }
    int getProfit(){
        return profit;
    }
}

class knapsack{
    
    knapsack(ArrayList<items> items,int capacity){
        int[][] matrix = new int[items.size()][capacity];
        matrix = DP(items, capacity);
        System.out.print
        for(int i=0;i<=items.size();i++){
            for(int j=0;j<=capacity;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("\n");
        }
    }

    static int[][] DP(ArrayList<items> items,int capacity){
        int x[] = new int[items.size()];
        int[][] matrix = new int[items.size()+1][capacity+1];
        for(int i=0;i<=items.size();i++){
            matrix[i][0] = 0;
        }
        for(int i=0;i<=capacity;i++){
            matrix[0][i] = 0;
        }
        for(int i=0;i<=items.size();i++){
            for(int j=0;j<=capacity;j++){
                if(i>0 && j>0 && j<items.get(i-1).getWeight()){
                    matrix[i][j] = matrix[i-1][j];
                }else if(i>0 && j>0 && j>=items.get(i-1).getWeight()){
                    matrix[i][j] = Math.max(matrix[i-1][j], items.get(i-1).getProfit()+matrix[i-1][j-items.get(i-1).getWeight()]);
                }
            }
        }
        return matrix;
    }
}
class DPKnapsack{
    public static void main(String[] args) {
        ArrayList<items> list = new ArrayList<>();
        list.add(new items(1, 2));
        list.add(new items(2, 3));
        list.add(new items(5, 4));
        list.add(new items(6, 5));
        new knapsack(list,8);
    }
}

