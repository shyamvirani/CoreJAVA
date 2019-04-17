package com.lib.controller;
import com.lib.model.*;


class BookNotAvailableException extends Exception{
	BookNotAvailableException(String string){
		super(string);
		}
}

public class LibController{
	
	public void issueBook(int uId,int bId,int t){
		 int i,j;
		
			for(j=0;j<DAO.b.length;j++){
			if(DAO.b[j].bid==bId)
					break;
		}
		try{
			if(j==DAO.b.length){
			throw new BookNotAvailableException("book is not available");
			}
		}catch(BookNotAvailableException be){
			System.out.println(be.getMessage());
		}
			if(DAO.b[j].status==0)
			System.out.println("\t Current status of book is zero");
		
		if(t==1){
			for(i=0;i<DAO.s.length;i++){
				if(DAO.s[i].uid==uId)
					
				break;
			}
			if(i==DAO.s.length) 
				System.out.println("\t Invalid user id");
			if(DAO.s[i].balance<=0)
				System.out.println("\t Your balance is low");
		
			
			DAO.s[i].x[3-DAO.s[i].balance]=DAO.b[j].bid;
			DAO.s[i].balance--;
			DAO.b[j].status--;
			DAO.b[j].issueBy=uId;
			System.out.println("Book issueby Userid"+DAO.b[j].issueBy);
			
			
			System.out.println("\t Book is successfully issued");
			}
		
		
		if(t==2){
			for(i=0;i<DAO.st.length;i++){
				if(DAO.st[i].uid==uId)
					
					break;
			}
			if(i==DAO.st.length)
				System.out.println("\t Invalid user id");
			if(DAO.st[i].balance==0)
				System.out.println("\t Your balance is low");
			DAO.st[i].y[5-DAO.st[i].balance]=DAO.b[j].bid;
			DAO.st[i].balance--;
			DAO.b[j].status--;
			DAO.b[j].issueBy=uId;
			System.out.println("Book issueby Userid"+DAO.b[j].issueBy);
			
				System.out.println("\t Book is successfully issued");
		}
		
	}
	



	
	public void  returnBook(int uId,int bId,int t){
		int i,j,k;
		
	for(j=0;j<DAO.b.length;j++){
			if(DAO.b[j].bid==bId && DAO.b[j].issueBy==uId)				
				break;
		}
		
		try{
			if( j==DAO.b.length){
			throw new BookNotAvailableException("book is not available for you");
			}
		}catch(BookNotAvailableException be){
			System.out.println(be.getMessage());
		}
					
		if(t==1){
			for(i=0;i<DAO.s.length;i++){
				if(DAO.s[i].uid==uId )
					break;
			}
			if(i==DAO.s.length) 
				System.out.println("\t Invalid user id");
			if(DAO.s[i].balance==3)
				System.out.println("\t Any book is not issued by you");
			for( k=0,i=0;k<3;k++){
				if(DAO.s[i].x[k]==bId){
					DAO.s[i].x[k]=0;
				}
		}
			
				DAO.s[i].balance++;
				DAO.b[j].status++;
				DAO.b[j].issueBy=0;
		
		System.out.println("\t Book is successfully returned");
		}
		
		if(t==2){
			for(i=0;i<DAO.st.length;i++){
				if(DAO.st[i].uid==uId )
					break;
			}
			if(i==DAO.st.length)
				System.out.println("\tInvalid user id");
			if(DAO.s[i].balance==5)
				System.out.println( "\t Any book is not issued by you");
			

			DAO.st[i].balance++;
			DAO.b[j].status++;
			DAO.b[j].issueBy=0;
			
				System.out.println( "\t Book is successfully returned");
			
			}
		}	
	
	
		
		
		
		
	 public int checkBalance(int uId,int t){
		int i;
		if(t==1){
			for(i=0;i<DAO.s.length;i++){
				if(DAO.s[i].uid==uId)
					break;
			}
			if(i==DAO.s.length){ 
				System.out.println("\t Invalid user id");
				return -1;
			}
			System.out.println("your book balance is ");
			return DAO.s[i].balance;
		}
		if(t==2){
			for(i=0;i<DAO.st.length;i++){
				if(DAO.st[i].uid==uId)
					break;
			}
			if(i==DAO.st.length){
				System.out.println("\t Invalid user id");
				return -1;
			}
			System.out.println("your book balance is ");
			return DAO.st[i].balance;
		}
		return 0;
	}

		public void show(int uId,int t){
			int i=0;
			System.out.println("Book id of issued book ");
			if(t==1){
			for( i=0;i<DAO.s.length;i++){
				if(DAO.s[i].uid==uId)
					break;
			}
			if( i==DAO.s.length) 
				System.out.println("Invalid user id");
			for(  i=0;i<3;i++)
				System.out.println(DAO.s[i].x[i]);
		}
			
		if(t==2){
			for( i=0;i<DAO.st.length;i++){
				if(DAO.st[i].uid==uId)
					break;
			}
			if( i==DAO.st.length) 
				System.out.println("Invalid user id");
			for(  i=0;i<3;i++)
				System.out.println(DAO.st[i].y[i]);
		}
		}
}
