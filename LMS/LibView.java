package com.lib.view;
import java.util.Scanner;
import com.lib.controller.*;
import  com.lib.model.*;
import java.util.*;



 public class LibView{

public static void main(String args[]){
		DAO d=new DAO();
		d.initData();
		LibController l=new LibController();
		 int uId,bId,t,x=0;
		while(true){
		System.out.println("Library Management System");
		System.out.println("Press 1 to issue a book");
		System.out.println("Press 2 to return a book");
		System.out.println("Press 3 to check book balance");
		System.out.println("Press 4 to show issued book list of student");
		System.out.println("Press 5 to exit");
		Scanner sc=new Scanner(System.in);
		System.out.println("enter your choice");
		int c=sc.nextInt();
		
			switch (c) {
			case 1:	System.out.println("enter uid");
					
					uId=sc.nextInt();
					System.out.println("enter book id");
					bId=sc.nextInt();
					System.out.println("eneter your type 1 or 2");
					t=sc.nextInt();
					l.issueBook(uId,bId,t);
						break;
			case 2:System.out.println("enter uid ");		
					uId=sc.nextInt();
					System.out.println("enter book id");
					bId=sc.nextInt();
					System.out.println("enter your type  1 or 2");
					t=sc.nextInt();
					l.returnBook(uId,bId,t);
					break;
			case 3:System.out.println("enter uid");
					uId=sc.nextInt();
					System.out.println("enter your type 1 or 2");
					t=sc.nextInt();
					x=l.checkBalance(uId,t);
					System.out.println(x);
					break;
			case 4:System.out.println("enter uid");
					uId=sc.nextInt();
					System.out.println("enter type 1 or 2");
					t=sc.nextInt();
					l.show(uId,t);
					break;
			case 5: 
					System.exit(0);

			default:
				System.out.println("Invalid input");
				break;
			}
		
		}
}
}
