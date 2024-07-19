package rudy.dsa.TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MaxInWindow {

    public ArrayList<Integer>solve(ArrayList<Integer>nums , int k){
        ArrayList<Integer>ans = new ArrayList<>();
        int left =0;
        int right = k-1;

        while (right< nums.size()){
            int max =0;
            while (left <= right){
                max= Math.max(nums.get(left),max);
                left++;

            }
            ans.add(max);
            right++;
        }
        return ans;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int left =0;
        int right = k-1;
        int n = nums.length;
        int max = 0;
        while(right < n){

            while(left <= right){
                max = Math.max(nums[left], max);
                left++;
            }

            list.add(max);
            right++;
        }

        int []ans = new int[list.size()];
        for(int i =0; i<list.size();i++){
            ans[i]= list.get(i);
        }

        return ans;

    }

    public static void main(String[] args) {

        int[]arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        MaxInWindow max = new MaxInWindow();
        System.out.println(Arrays.toString(max.maxSlidingWindow(arr, k)));

    }
}
