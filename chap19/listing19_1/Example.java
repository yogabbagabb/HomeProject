package listing19_1;

import java.io.*;

public class Example {
	
	public static void main(String[] args) throws IOException {
		
		File file = new File ("chap19Material" + File.separator + "list19_1.dat");
		System.out.println(file.mkdirs());
		FileOutputStream out = null;
		FileInputStream in = null;
		
		try
		{
			 out = new FileOutputStream (file);
			 in = new FileInputStream (file);
			 
			 for (int i = 0; i< 10; i++)
			 {
				 out.write(i);
			 }
			 
			 int i = 20;
			 while (i > 0)
			 {
				 System.out.println(in.read());
				 i--;
			 }
			 
			 out.close();
			 in.close();
		}
		
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
//		
//		finally
//		{
//			
//			
//		}
		
		
		


	}

}
