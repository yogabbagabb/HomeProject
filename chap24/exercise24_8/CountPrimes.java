package exercise24_8;
import java.io.*;

public class CountPrimes {

	public static void main(String[] args) {
		File file = new File ("chap19Material" + File.separator + "CountPrimes3.dat");
//		System.out.println(file.getParentFile().mkdirs());
//		try{
//		System.out.println("New file created: " + file.createNewFile());
//		}
//		catch(IOException e)
//		{
//			e.printStackTrace();
//		}
		
		CountPrimes.findPrimes(file, 1000);
		CountPrimes.nicelyPrint(file);
	}
	
	public static void findPrimes(File file, double last)
	{
		FileOutputStream out = null;
		FileInputStream in = null;
		if (file.exists())
		{
			
			try {
				out = new FileOutputStream(file);
				in = new FileInputStream(file);
				
				out.write(2);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
				catch(IOException e) {
					e.printStackTrace();
			}
		}
		
		else
		{
			System.out.println("File nonexistent");
			System.exit(0);
		}
		
		
		
		
		try{
			
		
				for (int i = 3; i <= (int)last; i++)
				{
					long[] array = new long[100000];
					boolean write = true;
					in = new FileInputStream(file);
					
					while(in.available() != 0)
					{
						System.out.println("Round: " + i + ", and in.available(): "
								+ in.available());
						int count = 0;
						int num = 0;
						while (count < array.length && (num = in.read()) != -1)
						{
							array[count] = num;
							count++;
						}
						
						for (int p = 0; p < array.length && array[p] != 0; p++)
						{
							if (i % array[p] == 0)
							{
								write = false;
								break;
							}
						}
					}
					
					if (write)
					{
						System.out.println("Being written: " + i);
						out.write(i);
					}
					
				}
		
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void nicelyPrint(File file)
	{
		FileInputStream in;
		
		try
		{
			in = new FileInputStream(file);
			while (in.available() != 0)
			{
				System.out.println(in.read());
			}
		}
		
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
	}

}
