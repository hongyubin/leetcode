package com.hyb.leetcode;

/**
 * @Author : hongyb
 * @Description
 * @Date Created  in 21:15 2020/3/9
 * 121. 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 暴力求解
 */
public class MaxProfit121 {
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int maxValue = Integer.MIN_VALUE;

        //第i天买入
        for(int i=0;i<prices.length;i++){
            //第j天卖出
            for(int j=i;j<prices.length;j++){
                int value = prices[j]-prices[i];
                if(maxValue<value){
                    maxValue = value;
                }
            }
        }
        return maxValue;
    }
}
