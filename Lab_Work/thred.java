abstract class anaonymus{
    abstract void print();
}
class t{
    public static String show(){
        return "SHOW";
    } 
}
interface A{
    void A();
} 
interface B{
    void B();
}
class C implements A,B{
    public void A(){
        System.out.println("A");
    }
    public void B(){
        System.out.println("B");
    }
}
class way1 implements Runnable{
    
    public void run(){

        System.out.println("RUN");
        try{
            Thread.sleep(1000);
            System.out.println("WAY@");
        }catch(Exception e){

        }
        
    }
}
class way2 extends Thread{
    public void run(){
        try{
            Thread.sleep(1000);
            System.out.println("GSDS");
            Thread.sleep(5000);
        }catch(Exception e){

        }
    }
}
public class thred {
    public static void main(String[] args) {

        new way2().run();
        
        
    }
}
