import java.util.ArrayList;
import javax.swing.text.DefaultEditorKit.CutAction;
import java.util.*;
/*
 * @author: Om K. Dhingani
 * Purpose: Activity Selection
 * Signed Class
 */
class Activity{
    int id,startTime,finishTime;
    Activity(int id,int startTime,int finishTime){
        this.id = id;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }
    void setID(int id){
        this.id = id;
    }
    void setStartTime(int startTime){
        this.startTime = startTime;
    }
    void setFinishTime(int finishTime){
        this.finishTime = finishTime;
    }
    int getId(){
        return id;
    }
    int getFinishTime(){
        return finishTime;
    }
    int getStartTime(){
        return startTime;
    }
    static ArrayList<Activity> generateActivity(){
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity(1, 10, 50));
        activities.add(new Activity(2, 20, 50));
        activities.add(new Activity(3, 15, 10));
        activities = sortingActivity(activities);
        return activities;
    }



    static ArrayList<Activity> sortingActivity(ArrayList<Activity> k){
        for(int i=0;i<k.size()-1;i++){
            int max = i;
            for(int j=i+1;j<k.size();j++){
                if(k.get(max).finishTime > k.get(j).finishTime){
                    max = j;
                }
            }
            Collections.swap(k, i, max);
        }
        return k;
    }

    static  void selectionActivity(ArrayList<Activity> activities){
        ArrayList<Activity> ans = new ArrayList<>();
        int size = activities.size();
        int initial = 0;
        ans.add(activities.get(0));
        for(int i=1;i<size;i++){
            if(activities.get(i).getStartTime() >= activities.get(initial).getFinishTime()){
                ans.add(activities.get(i));
            }
            initial = i;            
        }
        for(Activity a : ans){
            System.out.print(a.getId() + " ");
            System.out.print(a.getStartTime() + " ");
            System.out.println(a.getFinishTime());
        }

    }
    
}

public class ActivitySelectionProblem{
    public static void main(String[] args) {
        ArrayList<Activity> activities = Activity.generateActivity();
        Activity.selectionActivity(activities);
    }
}
