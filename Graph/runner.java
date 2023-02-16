package Graph;
import java.util.ArrayList;
public class runner {
  public static void main(String[] args) {
    ArrayList<edge> list = new ArrayList<>();
    
    list.add(new edge(1,6,10));
    list.add(new edge(1,2,28));
    list.add(new edge(2,7,14));
    list.add(new edge(7,5,24));
    list.add(new edge(5,6,25));
    list.add(new edge(5,4,22));
    list.add(new edge(4,3,12));
    list.add(new edge(2,3,16));
    krushkal.MST(list, 7);
  
  }
}
