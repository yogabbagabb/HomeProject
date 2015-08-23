package myBinaryTree;

public class IntegerTreeNode extends GenericTreeNode<Integer> 
{

	public IntegerTreeNode(Integer e) 
	{
		this.element = e;
	}

	protected static Integer add(Integer o1, Integer o2) 
	{
		return o1 + o2;
	}

	@Override
	public Integer add(Integer another) {
		return this.element + another;
	}

}
