package chap14;

import java.io.File;

public class Ex14_28 {
	
	
	private static void goDeep(File file, boolean deepen)
	{
		if (deepen)
		for (int i = 0; i < (int)(Math.random() * 5); i++)
		{
			File secondFile = new File (file.getPath() + "//Exercise" +
					          "" + (int)(Math.random() * 5) + "_" + (int)(Math.random() * 5));
			secondFile.mkdirs();
			goDeep(secondFile, getRandomBoolean());
		}
	}
	
	public static void main (String[]args)
	{
		goDeep(new File ("Exercise04_28"), true);
	}

	
	public static boolean getRandomBoolean() {
	       return Math.random() < 0.5;
	   }
}
