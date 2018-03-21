
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main 
{

	public static void main(String[] args) 
	{
	
		String data[][]= new String[6][3];
		int n=3;
		Scanner input=new Scanner(System.in);
		
		for(int i=0;i<n;i++) 
		{
			System.out.println("\nStudent Number "+ (i+1) +"\n");
			System.out.println("Name:\t");
			String name = input.nextLine();
			
			data[i][0]=name;
			
			
			System.out.println("Registration Number:\t");
			String reg_no = input.nextLine();
			
			int reg=Integer.parseInt(reg_no);
			
			Boolean unique =false;
			
			while(!unique) 
			{
				int j;
				Boolean found=false;
				
				for(j=0;j<i;j++) 
				{
					if(reg==Integer.parseInt(data[j][1]))
					{
						found=true;
						break;
					}
				}
				
				if(!found)
					unique=true;
				else 
				{
					System.out.println("Registration NUmber Already Exists,\n Enter Again:\t");
					reg_no = input.nextLine();
					reg=Integer.parseInt(reg_no);
				}
			}
			
			
			System.out.println("CGPA:\t");
			String cgpa = input.nextLine();
			float c=Float.parseFloat(cgpa);
			
			while(c<0 || c>4) 
			{
				System.out.println("Invalid CGPA");
				System.out.println("\n Enter Again");
				
				cgpa = input.nextLine();
				c=Float.parseFloat(cgpa);
			}
			
			
			data[i][1]=reg_no;
			data[i][2]=cgpa;
		}
		
		List<Float> list = new ArrayList<Float>();
		float sum=0;
		
		for(int i=0;i<n;i++) 
		{
			sum+=Float.parseFloat(data[i][2]);
			list.add(Float.parseFloat(data[i][2]));
		}
		
		float average=sum/n;
		float minimum = Collections.min(list);
		float maximum= Collections.max(list);
		
		System.out.println("Average CGPA is : "+average+"\n");
		System.out.println("Minimum CGPA is : "+minimum+"\n");
		System.out.println("Maximum CGPA is : "+maximum+"\n");
		
		
		System.out.println("\n\tSTUDENTS WITH LESS THAN AVERAGE CGPA ARE\n");
		
		for(int i=0;i<n;i++) 
		{
			if(Float.parseFloat(data[i][2])<average) 
			{
				System.out.println(data[i][0]+"\n");
			}
		}
		
		
		
		int i=1;
		System.out.println("\n SEACRH STUDENT");
		
		System.out.println("\nChoose: (1)Name \n (2)Registration Number\n");
		int choice=input.nextInt();
		while(i==1) 
		{
			
			
			
			Boolean found=false;
			
			if(choice==1) 
			{
				System.out.println("Enter Name:\n");
				input.skip("[\r\n]+");
				
				String sname=input.nextLine();
				
				for(int j=0;j<n;j++) 
				{
					if(data[j][0].equals(sname))
					{
						System.out.println("Student Found\n");
						System.out.println("Name :"+ data[j][0]+"\n Reg No : "+data[j][1]+"\n CGPA  : "+data[j][2]+"\n");
						found=true;
						break;
					}
				}
			}
			
			else if(choice==2) 
			{
				System.out.println("Registration Number\n");
				int reg=input.nextInt();
				for(int j=0;j<n;j++) 
				{
					if(reg==Integer.parseInt(data[j][1]))
					{
						System.out.println("Student Found\n");
						System.out.println("Name :"+ data[j][0]+"\n Reg No : "+data[j][1]+"\n CGPA  : "+data[j][2]+"\n");
						found=true;
						break;
					}
				}
			}
			else 
			{
				System.out.println("\nENTER VALID QUERY\n");
			}
			
			if(!found) 
			{
				System.out.println("STUDENT NOT PRESENT\n");
			}
			System.out.println("\n SEACRH STUDENT");
			
			System.out.println("\nChoose: (1)Name \n (2)Registration Number\n");
			choice=input.nextInt();
		}
		
	}

}



