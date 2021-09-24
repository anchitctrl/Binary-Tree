boolean printAncestors(Node node, int target)
	{
		if (node == null)
			return false;
		if (node.data == target)
			return true;
		if (printAncestors(node.left, target)
				|| printAncestors(node.right, target))
		{
			System.out.print(node.data + " ");
			return true;
		}
		return false;
	}
