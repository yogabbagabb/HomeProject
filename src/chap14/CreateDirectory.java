package chap14;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateDirectory {

	String file;
	
	public CreateDirectory(String file)
	{
		this.file = file;
	}
	
	public void makeFolders() throws IOException
	{
		for (int i = 0 ; i < (int)(Math.random() * 5 + 5); i++)
		{
			File folderFile = new File (file + "//" + i);
			folderFile.mkdirs();
			System.out.println(folderFile.getAbsolutePath());
			System.out.println("____");
			makeJavaFiles(folderFile);
		}
	}
	
	public void makeJavaFiles(File files) throws IOException
	{
		for (int i = 0 ; i < (int)(Math.random() * 5 + 5); i++)
		{
			File javaFile = new File (files,i + ".java");
			PrintWriter output = new PrintWriter (javaFile);
			output.print("public static void main (String[]args)");
			System.out.println(javaFile.getAbsolutePath());
			output.close();
		}
	}
	
	
	public static void main (String[]args) 
	{
		try
		{
			CreateDirectory master = new CreateDirectory ("14_18");
			master.makeFolders();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
