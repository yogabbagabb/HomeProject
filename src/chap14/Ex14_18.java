package chap14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class Ex14_18 {
	
	public static void goDeep(File file, String packageName) throws IOException
	{
		
			String[] pathNames = file.list();
			
			
			if (pathNames != null)
			{
							
				for (String end: pathNames)
				{
	
					File secondFile = new File (file.getPath() + "//" + end);
					goDeep(secondFile, end);
					
					String name = secondFile.getName();
					if (name.contains(".java"))
					{
						RandomAccessFile thirdFile = new RandomAccessFile (new File (file.getPath() + "//" + end),"rw");
						thirdFile.seek(0);
						thirdFile.writeUTF("package " + packageName + "\n\n");
						thirdFile.close();
					}
				}
				
			
			}
		
		
		
		
	}
	
	public static void main (String[]args)
	{
		try{
		File file = new File (args[0]);
		goDeep(file,null);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
