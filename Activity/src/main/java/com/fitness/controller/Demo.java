package com.fitness.controller;

public class Demo {
	
	public static void main(String[] args) {
		
	  	
		  String s="3902";
		
		 String[] split = s.split("");
		 
		 boolean flag= splitString(split);
		 
	  System.out.println(flag);
		 
		 
		 
		
	}
	
	  
	static boolean splitString(String[] split) {
		StringBuilder strnew  = new StringBuilder();
		 for (int i = 0; i < split.length-1; i++) {
			  int int1 = Integer.parseInt(split[i]);
			  int int2 = Integer.parseInt(split[i+1]);
			  strnew.append((int1+ int2) % 10);
		 }
		 
		 if(strnew.length()==2) {
			  return strnew.charAt(0)==strnew.charAt(1);
		 }else {
			 return splitString(strnew.toString().split(""));
		 }
	}

}
