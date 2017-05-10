package OnetoFive;

/**
 * Created by asus-Iabx on 2017/4/8.
 */
//import java.util.Arrays;
public class twosum{
    public static int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        for(int i=nums.length-1;i>0;i--)
        {
            //if(target-nums[i]<0)
            //    continue;
            //else
            //{
                for (int j = 0; j < i; j++) {
                    if(target-nums[i]==nums[j])
                    {
                        result[0]=i>j?j:i;
                        result[1]=i>j?i:j;
                        return result;
                    }
              //      else if(target-nums[i]<nums[j])
              //          break;
                }
            }
        //}
        return result;

    }
    public static void main(String[] args)
    {
        int[] nums=new int[3];
        nums[0]=3;
        nums[1]=2;
        nums[2]=4;

        int target=6;
        int[] result=new int[2];
        result=twoSum(nums,target);
        for(int i:result)
            System.out.print(i+" ");
    }
}