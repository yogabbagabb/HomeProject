package dfs_UNDI;

import java.util.Arrays;

/**
 * 
 * @author ahanagrawal
 *
 *	Takes an undirected graph and performs a dfs on it. Also 
 *	allows us to produce random graphs 
 */
public class dfs {
	
	
	public static int[][] createGraph(int vertexNumber)
	{
		int[][] array = new int[vertexNumber][vertexNumber];
		for (int i = 0; i < vertexNumber; i++)
		{
			for (int j = 0; j < vertexNumber; j++)
			{
				if (i == j)
					array[i][j] = 0;
				else
					array[i][j] = (int)Math.round(Math.random());
					
			}
		}
		
		return array;
	}
	
	public static void main (String[]args)
	{
		int[][] array = dfs.createGraph(5);
		for (int i = 0; i <  array.length; i++)
		{
			System.out.println(Arrays.toString(array[i]));
		}
		
	}
	
	

}
