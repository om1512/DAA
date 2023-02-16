class lab2
{
	static int count = 0;
    static void brutForce(int[] arr){
        int forceCount = 0;
        int max =0;
        for(int i=0;i<arr.length;i++){
            int sum = 0;
            for(int j=0;j<arr.length;j++){
                forceCount++;
                sum += arr[j];
                if(sum > max){
                    max = sum;
                }
            }
        }
        System.out.println("Brut Force: \nMaximum Contigues Sum Of Elements "+max);
        System.out.println("Number of comparisons "+forceCount);
   
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
            count++;
			sum += nums[i];
			if (sum > leftMax) {
				leftMax = sum;
			}
		}

		int rightMax = Integer.MIN_VALUE;
		sum = 0;	// reset sum to 0
		for (int i = mid + 1; i <= right; i++)
		{
            count++;
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
		int[] nums = new ArrayGenerator().asc(1000);
		System.out.println("Divide and Conquer: \nThe maximum sum of the subarray is " +
				findMaximumSum(nums,0,nums.length-1));
        System.out.println("Number of Comparisons in Divide And Conquer is "+count);
        brutForce(nums);
    }
}


