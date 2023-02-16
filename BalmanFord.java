import java.util.ArrayList;


class graph{
    int source;
    int destination;
    int weight;
    graph(){
    }
    graph(int source,int destination,int weight){
        this.source = source;
        this.destination =destination;
        this.weight = weight;
    }


    public int getSource() {
        return source;
    }


    public void setSource(int source) {
        this.source = source;
    }


    public int getDestination() {
        return destination;
    }


    public void setDestination(int destination) {
        this.destination = destination;
    }


    public int getWeight() {
        return weight;
    }


    public void setWeight(int weight) {
        this.weight = weight;
    }
}
class generateGraph{
    ArrayList<graph> graphs = new ArrayList<>();
    void addEdge(int source,int destination,int weigth){
        graphs.add(new graph(source, destination, weigth));
    }


    void displayGraph(){
        for(int i=0;i<graphs.size();i++){
            System.out.println(graphs.get(i).getSource()+"-------"+graphs.get(i).getWeight() + "------>"+graphs.get(i).getDestination());
        }
    }


    boolean balmondFordCreation(int source){
     for(int i=0;i<graphs.size();i++){
         if(graphs.get(i).getDestination() > graphs.get(i).getSource()+graphs.get(i).getWeight()){
             return false;
         }
        }
      return true;
      }
    
}
public class BalmanFord {
    public static void main(String[] args) {         
        generateGraph g = new generateGraph();
        g.addEdge(0, 3, 3);
        g.addEdge(0, 5, 5);
        g.addEdge(5, 11, 6);
        g.addEdge(11, 9, 7);
        g.addEdge(9, 11, 2);
        g.addEdge(5, 9, 4);
        g.addEdge(3, 5, 2);
        g.addEdge(5, 3, 1);
        g.addEdge(3, 9, 6);
        g.displayGraph();
    }
}
