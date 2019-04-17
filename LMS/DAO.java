package com.lib.model;

public class DAO{
	public static Book b[]=new Book[5];
	public static Student s[]=new Student[3];
	public static Staff st[]=new Staff[3];

	
	public static void initData(){
		
	 b[0]=new Book("Balaguru","c++","techmax",600,1010,4,0);
	 b[1]=new Book("Coreman","ADA","tech",700,2010,3,0);
	 b[2]=new Book("Gaokar","MPI","SRV",400,3010,2,0);
	 b[3]=new Book("Bratley","ADA","McGrow",400,4010,4,0);
	 b[4]=new Book("Dhamdhire","SP","tech",400,5010,4,0);
	 
	 s[0]=new Student(1,"comp",3);
	 s[1]=new Student(2,"nano",3);
	 s[2]=new Student(3,"ec",3);
	 
	 st[0]=new Staff(11,"it",5);
	 st[1]=new Staff(12,"comp",5);
	 st[2]=new Staff(13,"nano",5);
	
}
}