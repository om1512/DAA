package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class edge{
  int u;
  int v;
  int weight;
  edge(int u,int v,int weight){
    this.u = u;
    this.v = v;
    this.weight = weight;
  }
  int getU(){
    return u;
  }
  int getV(){
    return v;
  }
  int getWeight(){
    return weight;
  }
}
class SortComparator implements Comparator<edge>{
  
  public int compare(edge n1,edge n2){
    if(n1.getWeight() < n2.getWeight()){
      return -1;
    }else if(n1.getWeight() > n2.getWeight()){
      return 1;
    }else{
      return 0;
    }
  }
}
public class krushkal {
  static void MST(ArrayList<edge> list,int N){
    Collections.sort(list,new SortComparator());
    Disjoint d = new Disjoint(N);
    int MSTCost = 0;
    ArrayList<edge> mst = new ArrayList<>();
    for(edge n:list){
      if(d.findParent(n.getU()) != d.findParent(n.getV())){
        MSTCost += n.getWeight();
        mst.add(n);
        d.unionByRank(n.getU(),n.getV());
      }
    }
    System.out.println("Cost of MST is : "+MSTCost);
    for(edge n:mst){
      System.out.println(n.getU() +" "+n.getV()+" "+n.getWeight());
    }
  }
}
