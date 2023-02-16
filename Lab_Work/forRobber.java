import java.util.Scanner;
 
class knapsack {
    int price;
    int weight;
    int ratio;
    knapsack(){
 
    }
    knapsack(int price,int weight){
        this.price = price;
        this.weight = weight;
        this.ratio = price / weight;
    }
    void setPrice(int price){
        this.price = price;
    }
    void setWeigt(int weight){
        this.weight = weight;
    }
    void setRatio(int ratio){
        this.ratio = ratio;
    }
    int getPrice(){
        return this.price;
    }
    int getWeigt(){
        return this.weight;
    }
    int getRatio(){
        return this.ratio;
    }
}
 
class forRobber{
 
    static knapsack[] sorting(knapsack[] k){
        for(int i=0;i<k.length-1;i++){
            int max = i;
            for(int j=i+1;j<k.length;j++){
                if(k[max].ratio < k[j].ratio){
                    max = j;
                }
            }
            int temp = k[i].getPrice();
            int temp1 = k[i].getWeigt();
            int temp2 = k[i].getRatio();
            k[i].setPrice(k[max].getPrice());
            k[i].setWeigt(k[max].getWeigt());
            k[i].setRatio(k[max].getRatio());
            k[max].setPrice(temp);
            k[max].setWeigt(temp1);
            k[max].setRatio(temp2);
        }
        return k;
    }
 
    static void itemFiller(knapsack[] k,int weight){
        float price = 0;
        int i=0;
        while(weight > 0){
            if(k[i].weight <=  weight){
                price += k[i].price;
                weight = weight - k[i].weight;
            }else{
                double fractional = (double)weight/(double)k[i].weight;
                price = price + (int)(fractional*k[i].price);
              
                weight = 0;
                break;
            }
            i++;
        }
//         280 100 120 120
//         40 10 20 24
        System.out.println("Output :"+price);   
    }
 
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Size Of Knapsack  ");
        int kanpsackSize = sc.nextInt();
        System.out.print("How many items are there : ");
        int size = sc.nextInt();
        int price,weight;
        knapsack[] k = new knapsack[size];
        for(int i=0;i<size;i++){
            System.out.println("Enter Item Price");
            price = sc.nextInt();
            System.out.println("Enter Item Weigth");
            weight = sc.nextInt();
            k[i] = new knapsack(price,weight);
        }
        k = sorting(k);
        itemFiller(k, kanpsackSize);
        // for(int i=0;i<k.length;i++){
        //     System.out.println(k[i].price + " "+k[i].weight);
        // }
    }
}

