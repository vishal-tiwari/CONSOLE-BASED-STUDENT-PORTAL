/************************************
For Admin :
user name = admin
password = 0

**************************************/





import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
class Main{
	Scanner sc=new Scanner(System.in);
	File f=new File(".");
	ArrayList<StudentProfile> student=new ArrayList<>();
	ArrayList<String> logpass=new ArrayList<>();
	FileInputStream fis;
	FileOutputStream fos;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	StudentProfile st=new StudentProfile();
	
	public void registration(){
		System.out.println("\n******************* Event *****************\n");
		System.out.println("\tUser Registration");
		System.out.println("\n******************* Event *****************\n");
		System.out.println("Enter Username(user name must be your Registration number): ");
		String username=sc.next();
		System.out.println("Enter your four digit Numeric Password : ");
		int password = sc.nextInt();
		System.out.println("Enter Name : ");
		sc.nextLine();
		String name=sc.nextLine();
		System.out.println("Enter Numeric Registration number : ");
		Long regnumber=sc.nextLong();
		System.out.println("Enter  Branch name : ");
		String branch=sc.next();
		System.out.println("Enter Your gender(Male/Female) : ");
		String gender=sc.next();
		System.out.println("Enter your current Academic year : ");
		int year=sc.nextInt();
		System.out.println("Enter your date of birth(day/month/year) : ");
		sc.nextLine();
		String dob=sc.nextLine();
		System.out.println("Enter your Mother's name : ");
		String mname =sc.nextLine();
		System.out.println("Enter Your Father's Name : ");
		String fname = sc.nextLine();
		st.setName(name);
		//st.setUsername(username);
		//st.setPassword(password);
		st.setRegnumber(regnumber);
		st.setBranch(branch);
		st.setGender(gender);
		st.setYear(year);
		st.setDob(dob);
		st.setMname(mname);
		st.setFname(fname);

		String login="";
		login=login.concat(username+" "+password);
		
		try{
			try{
				fis=new FileInputStream("student.txt");
				ois=new ObjectInputStream(fis);
				student=(ArrayList<StudentProfile>)ois.readObject();
				
			}
			catch(Exception e){
				
			}
			student.add(st);
			fos=new FileOutputStream("student.txt");
			oos=new ObjectOutputStream(fos);
			oos.writeObject(student);
			try{
				fis=new FileInputStream("login.txt");
				ois=new ObjectInputStream(fis);
				logpass=(ArrayList<String>)ois.readObject();
				
			}
			catch(Exception e){
				
			}
			logpass.add(login);
			fos=new FileOutputStream("login.txt");
			oos=new ObjectOutputStream(fos);
			oos.writeObject(logpass);
			System.out.println("\n*******************Result*****************\n");
			System.out.println("\tRegistration is Successful");
			System.out.println("\n*******************Result*****************\n");
			try{
				fos.flush();
				fos.close();
			}
			catch(Exception e){
				
			}
			
		}
		
		catch(Exception e){
			System.out.println("\n*******************Result*****************\n");
			System.out.println("\tSorry !!! please try again");
			System.out.println("\n*******************Result*****************\n");
		}
	}
	public void login(){
		System.out.println("\n******************* Event *****************\n");
		System.out.println("\tUser Login");
		System.out.println("\n******************* Event *****************\n");
		System.out.println("Enter your username : ");
		String username=sc.next();
		System.out.println("Enter your four digit Numeric password : ");
		int password=sc.nextInt();
		String st="";
		st=st.concat(username+" "+password);
		try{
			fis=new FileInputStream("login.txt");
			ois=new ObjectInputStream(fis);
			ArrayList<String> al=(ArrayList<String>)ois.readObject();
			try{
				fis.close();
			}
			catch(Exception e){
			}
			if(al.contains(st)){
				
				System.out.println("\n********* Welcome "+username+" ***********\n");
				new User().menu(al.indexOf(st));
			}
			else if(username.equals("admin") && password==0){
				System.out.println("\n*************** Welcome Admin ***************\n");
				new Admin().menu();
			}
			else{
				System.out.println("\n*******************Result*****************\n");
				System.out.println("\tWrong username or password");
				System.out.println("\n*******************Result*****************\n");
			}
		}
		catch(Exception e){
			
		}
	}
	public static void main(String ... args){
		int c;
		Scanner scn=new Scanner(System.in);
		boolean b=true;
		Main m=new Main();
		while(b){
			System.out.println("1. Registration");
			System.out.println("2. Login ");
			System.out.println("3. Exit");
			System.out.println("Enter choice : ");
			c=scn.nextInt();
			switch(c){
				case 1: m.registration(); break;
				case 2: m.login();break;
				case 3: b=false;
						System.out.println("\n**********Thanks**********\n");
						break;
			}
		}
	}
	
}