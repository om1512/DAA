import java.util.Scanner;

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
    static Activity[] generateActivity(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Activity Amount : ");
        int noOfActivities = sc.nextInt();
        Activity[] activities = new Activity[noOfActivities];
        for(int i= 0;i<noOfActivities;i++){
            System.out.println("Enter Activity ID : ");
            int id = sc.nextInt();
            System.out.println("Enter Activity Start Time :");
            int startTime = sc.nextInt();
            System.out.println("Enter Activity Finish Time :");
            int finishTime = sc.nextInt();
            activities[i] = new Activity(id,startTime,finishTime);
        }
        activities = sorting(activities);
        return activities;
    }


    static Activity[] sorting(Activity[] k){
        for(int i=0;i<k.length-1;i++){
            int max = i;
            for(int j=i+1;j<k.length;j++){
                if(k[max].finishTime < k[j].finishTime){
                    max = j;
                }
            }
            int temp = k[i].getId();
            int temp1 = k[i].getStartTime();
            int temp2 = k[i].getFinishTime();
            k[i].setID(k[max].getId());
            k[i].setStartTime(k[max].getStartTime());
            k[i].setFinishTime(k[max].getFinishTime());
            k[max].setID(temp);
            k[max].setStartTime(temp1);
            k[max].setFinishTime(temp2);
        }
        return k;
    }

    static void  selectionActivity(Activity[] activities){
        int size = activities.length;
        
    }
    
}
class selectionSort{
    public static void main(String[] args) {
        Activity[] activities = Activity.generateActivity();
        Activity.selectionActivity(activities);
    }
}