package com.lib.model;

public class Staff{
	public static int y[]=new int [5];
	public int uid,balance;
	private  String dept;
	public  Staff(){}
	public  Staff(int uid,String dept,int balance){
	this.uid=uid;
	this.dept=dept;
	this.balance=balance;
}
}