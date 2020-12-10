package code.algo.java.hash;

public class ContainsDuplicate2 {
    public static void main(String[] args) {
        int nums[] = {1,0,1,1};
        int k = 1;
       boolean res= containsNearbyDuplicate(nums,k);
       System.out.println(res);
    }

    private static boolean containsNearbyDuplicate(int[] nums, int k)
    {
        boolean myval=false;
        int counter=0;
      outer:  for( int i =0;i<nums.length;i++)
        {
            counter ++;
            for(int j=i+1;j<nums.length-i;j++)
            {
                if(j-i >k){
                    break;
                }
                else if (nums[i]==nums[j]){
                    myval=true;
                    break outer;
                }
                else{
                    myval=false;
                }
                counter ++;
            }
        }
        System.out.println(counter);
        return myval;
    }
}
