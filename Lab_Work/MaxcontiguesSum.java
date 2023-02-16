class MaxcontiguesSum
{
    static int counter = 0;
    static int c = 0;
static void brutForce(int[] arr){
int max =0;
for(int i=0;i<arr.length;i++){
int sum = 0;
for(int j=i;j<arr.length;j++){
    sum += arr[j];
    c++;
    if(sum > max){
        max = sum;
    }
}
}
System.out.println("Maximum Contigues Sum Of Elements : "+max);
}
public static int findMaximumSum(int[] nums, int left, int right)
{
    if (right == left) {
        return nums[left];
    }
int mid = (left + right) / 2;
int leftMax = Integer.MIN_VALUE;
int sum = 0;
for (int i = mid; i >= left; i--)
{
    counter++;
    sum += nums[i];
    if (sum > leftMax) {
    leftMax = sum;
    }
}
    int rightMax = Integer.MIN_VALUE;
    sum = 0; // reset sum to 0
    for (int i = mid + 1; i <= right; i++)
    {
    counter++;
    sum += nums[i];
    if (sum > rightMax) {   
        rightMax = sum;
    }
    }
int maxLeftRight = Integer.max(findMaximumSum(nums, left, mid),
findMaximumSum(nums, mid + 1, right));
return Integer.max(maxLeftRight, leftMax + rightMax);
}
public static void main(String[] args)
{
int[] nums = {-2,5,-3,6,-1};
System.out.println("The maximum sum of the subarray is " +
findMaximumSum(nums,0,nums.length-1));
brutForce(nums);
System.out.println(MaxcontiguesSum.counter);
System.out.println(MaxcontiguesSum.c);
}
}