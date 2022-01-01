package Backtracking;
import java.util.*;
public class _377_CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        int count = helper(nums, target, new HashMap<Integer, Integer>());
        return count;
    }

    private int helper(int[] nums, int remain, HashMap<Integer, Integer> map) {
        map.forEach((k, v) -> System.out.printf("(%d, %d)", k, v));
        System.out.printf("%n");
        if (remain == 0) return 1;
        if (remain < 0) return 0;
        if (map.containsKey(remain)) return map.get(remain);

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += helper(nums, remain - nums[i], map);
        }
        map.put(remain, count);
        return count;
    }

    public static void main(String[] args) {
        _377_CombinationSum4 cs4 = new _377_CombinationSum4();
        System.out.println(cs4.combinationSum4(new int[]{10,20,30,40,50,60,70,80,90,100,110,120,130,140,150,160,170,180,190,200,210,220,230,240,250,260,270,280,290,300,310,320,330,340,350,360,370,380,390,400,410,420,430,440,450,460,470,480,490,500,510,520,530,540,550,560,570,580,590,600,610,620,630,640,650,660,670,680,690,700,710,720,730,740,750,760,770,780,790,800,810,820,830,840,850,860,870,880,890,900,910,920,930,940,950,960,970,980,990,111}, 999));
    }

}
