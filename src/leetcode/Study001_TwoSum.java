package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangff
 * @date 2019/11/6 14:22
 */
public class Study001_TwoSum {

    /**
     *  给定一个数组和一个目标和，从数组中找两个数字相加等于目标和，输出这两个数字的下标。
     *  Example:
     *  Given nums=[2,7,11,15],target=9
     *  Because nums[0]+nums[1]=2+7=9
     *  return [0,1]
     */

    /**
     * 解法一
     * 暴力破解 两层for循环 时间复杂度O(n^2)
     * 简单粗暴些，两重循环，遍历所有情况看相加是否等于目标和，如果符合直接输出。
     * @return
     */
    public static int[] twoSum0(int[] nums,int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j]==target) {
                    return new int[]{0,1};
                }
            }
        }
        return new int[]{};
    }

    /**
     * 解法二  hash法 时间复杂度 O(n) 空间复杂度O(n)
     * 数组元素放置hashmap里  {元素:索引}
     * @return
     */
    public static int[] twoSum1(int[] nums,int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if (hashMap.containsKey(sub)) {
                return new int[]{i,hashMap.get(sub)};
            }
        }
        return new int[]{};
    }

    public static int[] twoSum2(int[] nums,int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if (hashMap.containsKey(sub)) {
                return new int[]{i,hashMap.get(sub)};
            }
            hashMap.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;


        int[] rlt0 = twoSum0(nums, target);
        System.out.println("方法一:");
        Arrays.stream(rlt0).forEach(
                value -> System.out.println(value)
        );

        int[] rlt1 = twoSum1(nums, target);
        System.out.println("方法二:");
        Arrays.stream(rlt1).forEach(
                value -> System.out.println(value)
        );

        int[] rlt2 = twoSum2(nums, target);
        System.out.println("方法三:");
        Arrays.stream(rlt2).forEach(
                value -> System.out.println(value)
        );
    }
}
