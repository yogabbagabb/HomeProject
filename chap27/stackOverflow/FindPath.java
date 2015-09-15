package stackOverflow;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;

public class FindPath {

	public static void main (String[]args) throws IOException
	{
		Path path = Paths.get(".", "FA");
		FileVisitOption[] set = (FileVisitOption[]) EnumSet.of(FileVisitOption.FOLLOW_LINKS).toArray();
		Files.walk(path, 10, set);
		//http://tutorials.jenkov.com/java-nio/path.html
	}

}
