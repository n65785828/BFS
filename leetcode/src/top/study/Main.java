package top.study;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    private static final int[] nums = {1,3,5,7,10};
    private static final int target = 6;

    public static void main(String[] args) {
       Integer a  = 200;
       Integer b = 200;
        System.out.println(a==b);
    }

    public static String longestPalindrome(String s) {
        LocalDateTime now = LocalDateTime.now();
        char[] chars = s.toCharArray();
        String res = "";
        for (int i = 0; i < chars.length; i++) {
            for (int j = i+1; j <=chars.length; j++) {
//                if((j-i)<=res.length()){
//                    continue;
//                }
                String str = new String(chars,i,(j-i));
                if(str.equals(revertString(str))){
                    res = str.length()>res.length()?str:res;
                }
            }
        }
        System.out.println(Duration.between(now,LocalDateTime.now()).toMillis());
        return res;
    }

    public static int reverse(int x) {
        int flag = 1;
        long y = x;
        if(x<0){
            y=-y;
            flag=-1;
        }
        String str = revertString((y + ""));
        long l = Long.parseLong(str);
        if(l>Integer.MAX_VALUE||l<Integer.MIN_VALUE){
            return 0;
        }
        return Integer.parseInt(str)*flag;
    }

    class Solution {
        public int reverse(int x) {
            int rev = 0;
            while (x != 0) {
                if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                    return 0;
                }
                int digit = x % 10;
                x /= 10;
                rev = rev * 10 + digit;
            }
            return rev;
        }
    }
    public static String revertString(String s){
        if(s.length()<=1){
            return s;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length/2; i++) {
            char flag = chars[i];
            chars[i] = chars[chars.length-i-1];
            chars[chars.length-i-1] = flag;
        }
        return new String(chars);
    }



    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length+nums2.length;
        if(length==0){
            return 0;
        }
        int[] num = new int[length];
        for(int i =0;i<nums1.length;i++){
            num[i]=nums1[i];
        }
        for(int i=nums1.length;i<length;i++){
            num[i]=nums2[i-nums1.length];
        }
        Arrays.sort(num);
        if(length==2){
            return (num[0]+num[1])/2d;
        }
        if(length%2==0){
            int flag = length/2;
            return (num[flag-1]+num[flag])/2d;
        }else{
          int flag = length/2;
          return num[flag];
        }
    }
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }
    //i: nums1的起始位置 j: nums2的起始位置
    public int findKth(int[] nums1, int i, int[] nums2, int j, int k){
        if( i >= nums1.length) return nums2[j + k - 1];//nums1为空数组
        if( j >= nums2.length) return nums1[i + k - 1];//nums2为空数组
        if(k == 1){
            return Math.min(nums1[i], nums2[j]);
        }
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if(midVal1 < midVal2){
            return findKth(nums1, i + k / 2, nums2, j , k - k / 2);
        }else{
            return findKth(nums1, i, nums2, j + k / 2 , k - k / 2);
        }
    }



    public int[] test(){
        int[] indexs = new int[2];
        // 建立k-v ，一一对应的哈希表
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
        }
        return indexs;
    }


        public int lengthOfLongestSubstring2(String s) {
            TreeSet<Integer> treeSet = new TreeSet<>();
            char[] chars = s.toCharArray();
            int result = s.length()>0?1:0;
            for (int i = 0; i < chars.length; i++) {
                treeSet.add((int) chars[i]);
                for (int j = i+1; j < chars.length; j++) {
                    if(!treeSet.add((int) chars[j])){
                        break;
                    }
                }
                result = Math.max(result,treeSet.size());
                treeSet=new TreeSet<>();
            }
            return result;
        }
    }



