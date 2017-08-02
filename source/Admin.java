






import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

class Admin{
	Scanner sc=new Scanner(System.in);
	ArrayList<StudentProfile> student=new ArrayList<StudentProfile>();
	FileInputStream fis;
	FileOutputStream fos;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	StudentProfile st=new StudentProfile();
	public void show(){
		try{
			fis=new FileInputStream("student.txt");
			ois=new ObjectInputStream(fis);
			ArrayList<StudentProfile> al=(ArrayList<StudentProfile>)ois.readObject();
			if(al.size()==0){
				System.out.println("\n*******************Result*****************\n");
				System.out.println("\tNo record Found");
				System.out.println("\n*******************Result*****************\n");
			}
			for(StudentProfile s:al){
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
			}
			
			
			try{
				fis.close();
			}
			catch(Exception e){
			}
			
		}
		catch(Exception e){
			System.out.println("\n*******************Result*****************\n");
			System.out.println("\tNo record Found");
			System.out.println("\n*******************Result*****************\n");
		}
	}
	public void showP(){
		System.out.println("Enter Registration number of Student : ");
		long reg=sc.nextLong();
		try{
			fis=new FileInputStream("student.txt");
			ois=new ObjectInputStream(fis);
			ArrayList<StudentProfile> al=(ArrayList<StudentProfile>)ois.readObject();
		
			for(StudentProfile s:al){
				if(s.getRegnumber()==reg){
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
				}
			}
			try{
				fis.close();
			}
			catch(Exception e){
			}
		}
		catch(Exception e){
			System.out.println("\n*******************Result*****************\n");
			System.out.println("\tNo record Found");
			System.out.println("\n*******************Result*****************\n");
		}
	}
	public void deleteP(){
		System.out.println("Enter username of Student : ");
		String user=sc.next();
		try{
			fis=new FileInputStream("login.txt");
			ois=new ObjectInputStream(fis);
			ArrayList<String> al=(ArrayList<String>)ois.readObject();
			for(String s:al){
				String a[]=s.split(" ");
				if(a[0].equals(user)){
					int index=al.indexOf(s);
					fis=new FileInputStream("student.txt");
					ois=new ObjectInputStream(fis);
					ArrayList<StudentProfile> aal=(ArrayList<StudentProfile>)ois.readObject();
					aal.remove(index);
					fos=new FileOutputStream("student.txt");
					oos=new ObjectOutputStream(fos);
					oos.writeObject(aal);
					fis=new FileInputStream("login.txt");
					ois=new ObjectInputStream(fis);
					ArrayList<String> all=(ArrayList<String>)ois.readObject();
					all.remove(index);
					fos=new FileOutputStream("login.txt");
					oos=new ObjectOutputStream(fos);
					oos.writeObject(all);
					System.out.println("\n**********Successfully Deleted**********\n");
					try{
						fis.close();
					}
					catch(Exception e){
					}
				}
				
			}
			
		}
		catch(Exception e){
			System.out.println("\n*******************Result*****************\n");
			System.out.println("\tSorry !!! please try again");
			System.out.println("\n*******************Result*****************\n");
		}
	}
	public void menu(){
		int c;
		boolean b=true;
		Admin ad=new Admin();
		while(b){
			System.out.println("1. Show All record");
			System.out.println("2. Show particular record ");
			System.out.println("3. Delete Record");
			System.out.println("4. Logout");
			System.out.println("Enter choice : ");
			c=sc.nextInt();
			switch(c){
				case 1: ad.show(); break;
				case 2: ad.showP();break;
				case 3: ad.deleteP();break;
				case 4: b=false;
						System.out.println("\n**********Successfully logout**********\n");
						break;
			}
		}
	}
}