package com.lib.model;

public class Student{
	
	public static int x[]=new int [3];
	public  int uid,balance;
	private  String dept;
	public Student(){}
	public  Student (int uid,String dept,int balance){
	this.uid=uid;
	this.dept=dept;
	this.balance=balance;
}
		
}