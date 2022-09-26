package SnowFlake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortedArrangmentsBestSol {
   public static long minimumOperations(List<Integer> numbers) {
// Write your code here
      long sum = 0;
      List<Integer> currList = new ArrayList<>();
      for(int num : numbers){
         sum += insertInto(currList, num);
      }
      return sum;
   }

   public static long insertInto(List<Integer> curList, int num){
      if(curList.size() == 0){
         curList.add(0, num);
         return 1;
      }
      else {
         int Left = findFirst(curList, num);
         int Right = findLast(curList, num);
         System.out.println(Left + ", " + Right);
         if(Left < curList.size() - Right){
            curList.add(Left, num);
            return 2 * Left + 1;
         }
         else{
            curList.add(Right, num);
            return 2 * (curList.size() - Right - 1) + 1;
         }
      }
   }

   public static int findFirst(List<Integer> curList, int num){
      int start = 0, end = curList.size()-1;
      while(start <= end){
         int mid = start + (end-start)/2;
         if(curList.get(mid) >= num){
            end = mid - 1;
         }
         else{
            start = mid + 1;
         }
      }
      return start;
   }

   public static int findLast(List<Integer> curList, int num){
      int start = 0, end = curList.size()-1;
      while(start <= end){
         int mid = start + (end-start)/2;
         if(curList.get(mid) <= num){
            start = mid + 1;
         }
         else{
            end = mid - 1;
         }
      }
      return start;
   }

   public static void main(String[] args) {
      System.out.println(minimumOperations(Arrays.asList(new Integer[]{1,9,5,3,8,2,7,3})));
   }
}
