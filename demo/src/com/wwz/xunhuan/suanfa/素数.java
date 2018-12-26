package com.wwz.xunhuan.suanfa;

public class 素数 {
      public static void main(String[] args) {
          boolean flag;
          for (int i = 100; i <= 200; i++) {
              flag=false;
              for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i%j==0){
                        flag=true;
                        break;
                    }
              }if (flag==false)
              System.out.println(i);
          }

      }
}

