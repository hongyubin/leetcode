package com.hyb.leetcode;

/**
 * 1071. 字符串的最大公因子
 *
 * @Author : hongyb
 * @Description
 * @Date Created  in 21:16 2020/3/12
 * 辗转相除法取余数
 * （a,b）=(a,ka+b)
 * (84,15)->(9,15)->(9,6)->(3,6)->(3,0) 所以最大公约数为3
 */
public class GcdOfStrings1071 {
    public String gcdOfStrings(String str1, String str2) {
        //一时间真没想到字符串存在最大公约数的话str1+str2 = str2+str1
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }


        //存在最大公约数只需求两个字符串长度的最大公约数，此时用辗转相除法
        return str1.substring(0,gcd(str1.length(),str2.length()));



    }
    private int gcd(int a,int b){
        if(a%b == 0 ){
            return b;
        }
        return gcd(b,a%b);
    }
}
