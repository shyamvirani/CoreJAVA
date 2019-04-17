package com.lib.model;

public class Book{
	public  String author,title,publication;
	public int bid,status;
	private int price;
	public  int issueBy; 
	public  Book(){}
	public  Book(String author,String title,String publication,int price,int bid,int status,int issueBy){
	this.author=author;
	this.title=title;
	this.publication=publication;
	this.price=price;
	this.bid=bid;
	this.status=status;
	this.issueBy=issueBy;
	
	
	}
}