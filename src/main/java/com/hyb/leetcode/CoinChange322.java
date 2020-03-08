package com.hyb.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 零钱兑换
 * 贪心算法+dfs
 * 每次获取可用的最大值
 * @Author : hongyb
 * @Description
 * @Date Created  in 17:57 2020/3/8
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CoinChange322 {
    int totalCount = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        //先进行排序，
        Arrays.sort(coins);
        coinChange(coins.length-1, coins, amount, 0);
        return totalCount == Integer.MAX_VALUE? -1:totalCount;
    }

    private void coinChange(int index, int[] coins, int amount, int needCount) {
      if(amount == 0){
          //取最小的数
          totalCount = Math.min(totalCount,needCount);
          return;
      }
      if(index <=-1){
          return;
      }
      int c = amount/coins[index];
      //c值为index硬币最大使用次数，如果使用c个index不行则回退转换小硬币
      for(int k = c ; k>=0&&needCount+k<totalCount; k--){
          int left = amount - k*coins[index];
          coinChange(index-1,coins,left,needCount+k);
      }
    }
    @Test
    public void test(){
        int[] coins ={1,2,5};
        int count = coinChange(coins,11);
        System.out.println(count);
    }
}

