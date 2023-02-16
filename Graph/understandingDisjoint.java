package Graph;
import java.util.ArrayList;

public class understandingDisjoint {
  public static void main(String[] args) {
    Disjoint d = new Disjoint(7);
    d.unionByRank(1, 2);
    d.unionByRank(2, 3);
    d.unionByRank(4, 5);
    d.unionByRank(6, 7);
    d.unionByRank(5, 6);
    if(d.findParent(3) == d.findParent(7)){
      System.out.println("Same");
    }else{
      System.out.println("Not Same");
    }

    d.unionByRank(3, 7);

    if(d.findParent(3) == d.findParent(7)){
      System.out.println("Same");
    }else{
      System.out.println("Not Same");
    }

  }
}
