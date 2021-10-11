import java.util.Scanner;

import com.student.management.DeleteStudent;
import com.student.management.DisplayStudent;
import com.student.management.InsertStudent;
import com.student.management.UpdateStudent;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		UpdateStudent us;
		String query;
		while (true) {
			System.out.println("Please Enter Your Choice");
			System.out.println("Press 1 to Insert into database");
			System.out.println("Press 2 to Update into database");
			System.out.println("Press 3 to Delete from database");
			System.out.println("Press 4 to Display all records");

			int choice = input.nextInt();
			switch (choice) {
			case 1:
				//Insert Operation
				System.out.println("Enter Your Roll No");
				int roll=input.nextInt();
				System.out.println("Enter Your Age");
				int age=input.nextInt();
				System.out.println("Enter Your Name");
				String name=input.next();
				System.out.println("Enter Your City");
				String city=input.next();
				System.out.println("Enter Your Phone Number");
				String phone=input.next();
				System.out.println("Enter Your Saction");
				String division=input.next();
				InsertStudent is=new InsertStudent();
				boolean answer=is.insertStudent(roll, age, name, city, phone, division);
				if(answer==true)
				{
					System.out.println("Student Added into database.......");
				}
				else 
				{
					System.out.println("Something Went Wrong Please Try Again.......");	
				}
				break;
			case 2:
				System.out.println("Enter Your Student ID");
				int sid=input.nextInt();
				System.out.println("What you want to updata?...");
				System.out.println("Press 1 to update Roll no");
				System.out.println("Press 2 to update Age");
				System.out.println("Press 3 to update Name");
				System.out.println("Press 4 to update City");
				System.out.println("Press 5 to update Phone");
				System.out.println("Press 6 to update Saction");
				System.out.println("Press 7 to update all except student id");
				System.out.println("Press 8 to cancel");
				int selection=input.nextInt();

				if(selection==1)
				{
					System.out.println("Enter new roll no");
					int newrollno=input.nextInt();
					//Roll number will type cast into string
					String rollno=Integer.toString(newrollno);
					query = "update student_manage set sroll=? where sid=?;";
					us=new UpdateStudent();
					boolean updaterollResult=us.updateStudent(sid,rollno,query);
					if(updaterollResult==true)
					{
						System.out.println("Roll no updated successfully");
					}
					else
					{
						System.out.println("Roll no not updated....");	
					}
				}

				else if (selection==2) 
				{
					System.out.println("Enter your new age");
					int newage = input.nextInt();
					String updatedAge=Integer.toString(newage);
					query="update student_manage set sage=? where sid=?;";
					us=new UpdateStudent();
					boolean updateAgeResult=us.updateStudent(sid, updatedAge, query);
					if(updateAgeResult==true)
					{
						System.out.println("Age updated successfully");
					}
					else 
					{
						System.out.println("Age not updated.......");
					}
				}
				else if (selection==3) 
				{
					System.out.println("Enter your new name");
					String newName=input.next();
					query= "update student_manage set sname=? where sid=?;";
					us=new UpdateStudent();
					boolean updatedNameResult=us.updateStudent(sid, newName, query);
					if(updatedNameResult)
					{
						System.out.println("Name updated successfully");
					}
					else 
					{
						System.out.println("Name not updated......");	
					}
				}

				else if (selection==4) 
				{
					System.out.println("Enter your new city");
					String newcity = input.next();
					query= "update student_manage set scity=? where sid=?;";
					us=new UpdateStudent();
					boolean updatedCityResult=us.updateStudent(sid, newcity, query);
					if(updatedCityResult)
					{
						System.out.println("City updated successfully");
					}
					else 
					{
						System.out.println("City not updated..........");	
					}
				}

				else if (selection==5) 
				{
					System.out.println("Enter your new phone number");
					String newPhone=input.next();
					query= "update student_manage set sphone=? where sid=?;";
					us=new UpdateStudent();
					boolean updatedPhoneResult=us.updateStudent(sid, newPhone, query);
					if(updatedPhoneResult)
					{
						System.out.println("Phone number updated successfully");
					}
					else 
					{
						System.out.println("Phone number not updated......");	
					}
				}

				else if (selection==6) 
				{
					System.out.println("Enter your new saction");
					String newDiv=input.next();
					query= "update student_manage set sdivision=? where sid=?;";
					us=new UpdateStudent();
					boolean updatedDivResult=us.updateStudent(sid, newDiv, query);
					if(updatedDivResult)
					{
						System.out.println("Saction updated successfully");
					}
					else 
					{
						System.out.println("Saction not updated......");	
					}
				}

				else if (selection==7) 
				{
					System.out.println("Enter your new roll number");
					int nroll_no=input.nextInt();
					System.out.println("Enter your new age");
					int nage=input.nextInt();
					System.out.println("Enter your new name");
					String new_Name=input.next();
					System.out.println("Enter your new city");
					String new_City=input.next();
					System.out.println("Enter your new phone");
					String new_Phone=input.next();
					System.out.println("Enter your new saction");
					String new_Div=input.next();
					us=new UpdateStudent();
					boolean updatedAllResult=us.updateAllRecordStudent(sid,nroll_no, nage, new_Name, new_City, new_Phone, new_Div);
					if(updatedAllResult)
					{
						System.out.println("All record updated successfully");
					}
					else 
					{
						System.out.println("Error in updating all record......");	
					}
				}
				else if (selection==8) {
					System.out.println("Invalid Entry");
					break;
				}
				break;

			case 3:
				System.out.println("Enter your student id");
				int stdid=input.nextInt();
				DeleteStudent ds = new DeleteStudent();
				boolean deleteResult=ds.deleteStudent(stdid);
				if(deleteResult)
				{
					System.out.println("Record delete for student id:"+stdid);
				}
				else 
				{
					System.out.println("Student id:"+stdid+ "is not deleted....");	
				}
				break;
			case 4:
				DisplayStudent dps=new DisplayStudent();
				dps.displayStudent();
				break;
			default:
				System.out.println("Please select the correct option");
				break;
			}

			System.out.println("Thanks for using my application.......");
		}
	}
}
