package Graph;

import java.util.ArrayList;

class node{
  int rank;
  int parent;
  node(int rank,int parent){
    this.rank = rank;
    this.parent = parent;
  }
  int getRank(){
    return rank;
  }
  int getParent(){
    return parent;
  }
  void setParent(int parent){
    this.parent = parent;
  }
  void setRank(int rank){
    this.rank = rank;
  }
}
public class Disjoint{
  ArrayList<node> list = new ArrayList<>();
  Disjoint(){}
  Disjoint(int n){
    for(int i=0;i<=n;i++){
      list.add(new node(0, i));
    }
  }

  public int findParent(int n){
    if(n == list.get(n).getParent()){
      return n;
    }else{
      list.get(n).setParent(findParent(list.get(n).getParent()));
      return findParent(list.get(n).getParent());
    }
  }

  public void unionByRank(int u,int v){
    int ult_parent_u = findParent(u);
    int ult_parent_v = findParent(v);
    if(ult_parent_u == ult_parent_v){
      return;
    }else if(list.get(ult_parent_u).getRank() < list.get(ult_parent_v).getRank()){
      list.get(ult_parent_u).setParent(ult_parent_v);
    }else if(list.get(ult_parent_v).getRank() < list.get(ult_parent_u).getRank()){
      list.get(ult_parent_v).setParent(ult_parent_u);
    }else{
      list.get(ult_parent_v).setParent(ult_parent_u);
      list.get(ult_parent_u).setRank(list.get(ult_parent_u).getRank()+1);
    } 
  }
}