package rudy.dsa.StackQueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement1 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int n = nums2.length;
        Stack<Integer>stack = new Stack<>();
        int[] nge = new int[n];
        Map<Integer,Integer> map = new HashMap<>();

        nge[n-1]= -1;
        stack.push(nums2[n-1]);
        map.put(nums2[n-1],nge[n-1]);
        for(int i = n-2; i>=0;i--){
            int currentElement = nums2[i];
            int top = stack.peek();
            if(currentElement<top){
                nge[i]=top;
            }
            else{
                while(!stack.isEmpty()&&currentElement>stack.peek()){
                    stack.pop();
                }

                if(stack.isEmpty()){
                    nge[i] = -1;
                }

                else{

                    nge[i]= stack.peek();
                }


            }
            stack.push(currentElement);
            map.put(currentElement , nge[i]);
        }

        int[] ans = new int[nums1.length];
        for(int i =0;i< ans.length;i++){
            int key = nums1[i];
            ans[i]= map.get(key);
        }


        return ans;

    }

    public static void main(String[] args) {
        int[]a ={2,4};
        int[] b ={1,2,3,4};

        NextGreaterElement1 obj = new NextGreaterElement1();
        System.out.println(Arrays.toString(obj.nextGreaterElement(a,b)));
    }
}
