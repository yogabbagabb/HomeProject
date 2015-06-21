package chap14;

import java.io.File;
import java.util.Arrays;

public class PaddingEx_28 {
	
	
	public static void goDeep(File file)
	{
		String path = file.getPath();
		String relativePath = path.substring(path.lastIndexOf("/") + 1);
		String remainder = path.substring(0,path.lastIndexOf("/") + 1);
		
		System.out.println(path);
		System.out.println(relativePath);
		System.out.println(remainder);
		System.out.println();
		
		if (relativePath.contains("Exercise"))
		{
			int underscoreIndex = relativePath.indexOf("_");
			
			String remaining = relativePath.substring(underscoreIndex - 1);
			
			File secondFile = new File(remainder + "Exercise" + "0" + remaining);
			secondFile.mkdirs();
			
			file.renameTo(secondFile);
			
		}
		
		
		String [] list = file.list();
		System.out.println(Arrays.toString(list));
		
		
		if (list != null)
		{
			for (String item: list)
			{
				goDeep(new File (file.getPath() + "//" + item));
			}
		}
	}
	
	public static void main (String[]args)
	{
		goDeep(new File ("Exercise04_28"));
	}

}
