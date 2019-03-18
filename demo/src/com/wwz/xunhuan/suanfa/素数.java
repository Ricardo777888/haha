package com.wwz.xunhuan.suanfa;



public class 素数 {
      public static void main(String[] args) {
          boolean ex;

          for (int i = 2; i <= 100; i++) {
              // if(i == 1 || (i % 2 == 0 && i != 2 ) )  continue;
              ex = true;
              for (int j = 2; j <= Math.sqrt(i); j++) {
                  if (i % j == 0) {
                      ex = false;
                      break;
                  }
              }
              if (ex) {
                  System.out.print(i+" ");
              }
          }
      }
}


