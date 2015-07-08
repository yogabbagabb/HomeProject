

/**
 * Offers the specified operations on integer matrices.
 */
public class MatrixManipulator
{
	/**
	 * Determines if (first + second) is defined where + indicates matrix addition.
	 * 
	 * @return true if matrix addition is defined, false otherwise.
	 */
	public static boolean addable(int[][] first, int[][] second)
	{
		
		if (first.length != second.length){
			return false;
		}
		
		if (first[0].length != second[0].length){
				return false;
		}
		
		return true;
	}
		
		
	

	/**
	 * Performs (first + second) where + indicates matrix addition. (Precondition: addable(first, second) returns true.)
	 * 
	 * @return the result of first + second.
	 * @throws IllegalArgumentException
	 *             if the precondition is not met.
	 */
	public static int[][] add(int[][] first, int[][] second)
	{
		int [][] sum = new int [first.length][second[0].length];

		if (addable(first,second)){
			
			for (int i = 0; i < sum.length; i++){
				for (int j = 0; j < sum[i].length; j++){
					sum[i][j] = first[i][j] + second [i][j];
				}
			}
			return sum;
		}
		
		else
			throw new IllegalArgumentException ();
	}

	/**
	 * Performs (scalar * matrix) where * indicates scalar multiplication of a matrix. (Precondition: matrix.length > 0 && matrix[0].length > 0)
	 * 
	 * @return the result of scalar * matrix.
	 * @throws IllegalArgumentException
	 *             if the precondition is not met.
	 */
	public static int[][] multiplyByScalar(int scalar, int[][] matrix)
	{
		int [][] product;
		
		if (atLeastOneByOne(matrix)){
			product = new int [matrix.length][matrix[0].length];
			
			for (int i = 0; i < product.length; i++){
				for (int j = 0; j < product[i].length; j++){
					product[i][j] = matrix[i][j] * scalar;
				}
			}
			return product;
		}
		else{
			throw new IllegalArgumentException ();
		}
	}

	/**
	 * Multiplies the specified row of first and the specified column of second. (Precondition: first[row].length > 0 && first[row].length == second.length)
	 * 
	 * @return the result of multipliying the specified row and column.
	 * @throws IllegalArgumentException
	 *             if the precondition is not met.
	 */
	public static int multiply(int[][] first, int row, int[][] second, int col)
	{
		int result = 0;
		
		if (atLeastOneByOne(first) && first[row].length == second.length){
			
			for (int i = 0; i < second.length; i++){
				result += first[row][i] * second[i][col];
			}
			return result;
		}
		else{
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Determines if (first * second) is defined where * indicates matrix multiplication.
	 * 
	 * @return true if matrix multiplication is defined, false otherwise.
	 */
	public static boolean multipliable(int[][] first, int[][] second)
	{	// consider adding oneByOne to first and second
		return (first[0].length == second.length);
	}

	/**
	 * Performs (first * second) where * indicates matrix multiplication. (Precondition: multipliable(first, second) returns true.)
	 * 
	 * @return the result of first * second.
	 * @throws IllegalArgumentException
	 *             if the precondition is not met.
	 */
	public static int[][] multiply(int[][] first, int[][] second)
	{
		int [][] product = null;
		if (multipliable(first,second)){
			
				
				 product = new int [first.length][second[0].length];
				
				 
				 for (int i = 0; i < product.length; i++ )
					 for (int j = 0; j < product[i].length; j++)	
						product[i][j] = multiply(first,i,second,j);
					
				
			}
			
			else{
		throw new IllegalArgumentException ();
		}
		
		return product;
	}

	private static boolean atLeastOneByOne(int[][] matrix)
	{
		return matrix != null && matrix.length > 0 && matrix[0].length > 0;
	}
}
