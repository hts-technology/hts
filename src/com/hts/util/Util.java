package com.hts.util;

public class Util {
	
	public static int gcd(int m,int n){        
		int k=m>n?n:m;  
        int s = 1;  
        for(int i = 2;i <=k;i ++){  
            for(int j = 2;j <= i;j++){  
                if(m % j == 0 && n % j == 0){  
                    m = m / j;  
                    n = n / j;  
                    s = s * j;  
                }  
            }     
        }  
        return s;           
    }  
	public static void main(String[] args) {
		String str1="abc";
		String str2="abc";
		System.out.println(str1.getBytes());
		System.out.println(str2.getBytes());
	}
}
