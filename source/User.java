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
class User{
	Scanner sc=new Scanner(System.in);
	File f=new File(".");
	ArrayList<StudentProfile> student=new ArrayList<StudentProfile>();
	FileInputStream fis;
	FileOutputStream fos;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	StudentProfile st=new StudentProfile();
	public void show(int index){
		try{
			fis=new FileInputStream("student.txt");
			ois=new ObjectInputStream(fis);
			ArrayList<StudentProfile> al=(ArrayList<StudentProfile>)ois.readObject();
			System.out.println(al.size());
			StudentProfile s=new StudentProfile();
			s=al.get(index);
			System.out.println("\n*******************Profile*****************\n");
			System.out.println("\tName = "+s.getName());
			System.out.println("\tRegistration Number = "+s.getRegnumber());
			System.out.println("\tBranch = "+s.getBranch());
			System.out.println("\tYear = "+s.getYear());
			System.out.println("\tGender = "+s.getGender());
			System.out.println("\tDate of birth = "+s.getDob());
			System.out.println("\tMother's name = "+s.getMname());
			System.out.println("\tFather's name = "+s.getFname());
			System.out.println("\n*******************Profile*****************\n");
			try{
				fis.close();
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
	public void changePass(int index){
		try{
			System.out.println("Enter new User name : ");
			String user=sc.next();
			System.out.println("Enter new 4 digit numeric password : ");
			int pass=sc.nextInt();
			fis=new FileInputStream("login.txt");
			ois=new ObjectInputStream(fis);
			ArrayList<String> al=(ArrayList<String>)ois.readObject();
			String result="";
			result=result.concat(user+" "+pass);
			String k=al.set(index,result);
			fos=new FileOutputStream("login.txt");
			oos=new ObjectOutputStream(fos);
			oos.writeObject(al);
			System.out.println("\n*******************Result*****************\n");
			System.out.println("\tPassword has been Changed");
			System.out.println("\n*******************Result*****************\n");
			try{
				fos.flush();
				fos.close();
				fis.close();
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
	public void updateP(int index){
		try{
			System.out.println("Enter Name : ");
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
			fis=new FileInputStream("student.txt");
			ois=new ObjectInputStream(fis);
			st.setName(name);
			st.setRegnumber(regnumber);
			st.setBranch(branch);
			st.setGender(gender);
			st.setYear(year);
			st.setDob(dob);
			st.setMname(mname);
			st.setFname(fname);
			ArrayList<StudentProfile> al=(ArrayList<StudentProfile>)ois.readObject();
			al.set(index,st);
			fos=new FileOutputStream("student.txt");
			oos=new ObjectOutputStream(fos);
			oos.writeObject(al);
			System.out.println("\n*******************Result*****************\n");
			System.out.println("\t profile is updated successfully");
			System.out.println("\n*******************Result*****************\n");
			try{
				fos.flush();
				fos.close();
				fis.close();
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
	public void delete(int index){
		try{
			
			fis=new FileInputStream("student.txt");
			ois=new ObjectInputStream(fis);
			ArrayList<StudentProfile> al=(ArrayList<StudentProfile>)ois.readObject();
			
			al.remove(index);
			
			fos=new FileOutputStream("student.txt");
			oos=new ObjectOutputStream(fos);
			oos.writeObject(al);
			fis=new FileInputStream("login.txt");
			ois=new ObjectInputStream(fis);
			ArrayList<String> all=(ArrayList<String>)ois.readObject();
			
			all.remove(index);
			
			fos=new FileOutputStream("login.txt");
			oos=new ObjectOutputStream(fos);
			oos.writeObject(all);
			try{
				fos.flush();
				fos.close();
				fis.close();
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
	public void menu(int index){
		
		int c;
		boolean b=true;
		while(b){
			System.out.println("1. Show Profile");
			System.out.println("2. Change Password and Username ");
			System.out.println("3. Update Profile");
			System.out.println("4. Delete Account");
			System.out.println("5. Logout");
			System.out.println("Enter choice : ");
			c=sc.nextInt();
			switch(c){
				case 1: new User().show(index); break;
				case 2: new User().changePass(index);break;
				case 3: new User().updateP(index);break;
				case 4: new User().delete(index);
						b=false;
						System.out.println("\n**********Successfully Deleted**********\n");
						break;
				case 5: b=false;
						System.out.println("\n**********Successfully logout**********\n");
						break;
			}
		}
	}
}