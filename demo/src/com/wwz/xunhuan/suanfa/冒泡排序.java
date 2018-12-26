package com.wwz.xunhuan.suanfa;

import java.util.Arrays;

public class 冒泡排序 {
    public static void main(String[] args) {
        int[] ints ={5,6,88,1,66};
        a(ints);
        System.out.println(Arrays.toString(ints));
    }
    public static void a(int[] source){
    boolean ex;
    for (int i=source.length-1;i>0;i--){
        ex=true;
        for (int j=0;i>j;j++){
            if (source[j]>source[j+1]){
                int a=source[j+1];
                source[j+1]=source[j];
                source[j]=a;
                ex=false;
            }
        }
        if (ex)return;
    }
    }
}
