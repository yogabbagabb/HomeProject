package chap14;

import java.io.File;
import java.util.Arrays;

public class PlayAroundTwo {

	public static void main(String[] args) {

		File file = new File ("14_18");
		System.out.println(Arrays.toString(file.list()));
	
	}

}
