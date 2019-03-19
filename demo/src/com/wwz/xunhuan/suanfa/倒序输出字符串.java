package com.wwz.xunhuan.suanfa;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 倒序输出字符串 {
    public static void main(String[] args) {
        String hello = demo("hello");
    }

    public static String demo(String data) {
        StringBuffer stringBuffer = new StringBuffer(data);
        return stringBuffer.reverse().toString();
    }

    public static String reverseByStack(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        List list=new ArrayList();
        Stack<Character> strStack = new Stack<Character>();
        char[] chArray = str.toCharArray();
        for (Character ch : chArray) {
            strStack.push(ch);
        }
        int len = str.length();
        for (int i = 0; i < len; i++) {
            chArray[i] = strStack.pop();
        }
        return new String(chArray);
    }

}
