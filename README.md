# Binary-Tree

### Table of Contents:

![Binary Tree meme](![image](https://user-images.githubusercontent.com/70264806/134221937-a01cce49-57a3-4f9a-ba5b-8be1b75839eb.png)
)

* [Implementation of a Binary Tree](#implementation-of-a-binary-tree)
* [Pre Order Traversal Using Recursion](#pre-order-traversal-using-recursion)
* [In Order Traversal Using Recursion](#in-order-traversal-using-recursion)
* [Post Order Traversal Using Recursion](#post-order-traversal-using-recursion)
* [Pre Order Traversal Using Iteration](#pre-order-traversal-using-iteration)
* [In Order Traversal Using Iteration](#in-order-traversal-using-iteration)
* [Post Order Traversal Using Iteration](#post-order-traversal-using-iteration)
* [Height of Binary Tree](#height-of-binary-tree)
* [Level Order of Binary Tree](#level-order-of-binary-tree)
* [Diameter of a Binary Tree](#diameter-of-a-binary-tree)
* [Print nodes at Kth Distance from the root](#print-nodes-at-kth-distance-from-the-root)
* [Print all the Ancestors of a given Key](#print-all-the-ancestors-of-a-given-key)
* [Check if a gievn tree is a subtree of another Binary Tree](#check-if-a-gievn-tree-is-a-subtree-of-another-binary-tree)

<a name="implementation-of-a-binary-tree"></a>
### Implementation of a Binary Tree

```java
public class BinaryTree {
	
	private TreeNode root;
	
	private class TreeNode {
		private TreeNode left;
		private TreeNode right;
		private int data; // Can be any generic type
		
		public TreeNode(int data) {
			this.data = data;
		}
	}
	
	public void createBinaryTree() {
		TreeNode first = new TreeNode(1);
		TreeNode second = new TreeNode(2);
		TreeNode third = new TreeNode(3);
		TreeNode fourth = new TreeNode(4);
		TreeNode fifth = new TreeNode(5);
		
		root = first; // root ---> first
		first.left = second;
		first.right = third; // second <--- root ---> third
		
		second.left = fourth;
		second.right = fifth;
	}
}
```

<a name="pre-order-traversal-using-recursion"></a>
### Pre Order Traversal Using Recursion

```java
public void preOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
```

<a name="in-order-traversal-using-recursion"></a>
### In Order Traversal Using Recursion

```java
public void inOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
```

<a name="post-order-traversal-using-recursion"></a>
### Post Order Traversal Using Recursion

```java
public void postOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}
```

<a name="pre-order-traversal-using-iteration"></a>
### Pre Order Traversal Using Iteration

```java
public void preOrder() {
		if(root == null) {
			return;
		}
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			System.out.print(temp.data + " ");
			if(temp.right != null) {
				stack.push(temp.right);
			}
			if(temp.left != null) {
				stack.push(temp.left);
			}
		}
	}
```

<a name="in-order-traversal-using-iteration"></a>
### In Order Traversal Using Iteration

```java
public void inOrder() {
		if(root == null) {
			return;
		}
		
		Stack<TreeNode> stack = new Stack<>();
		TreeNode temp = root;
		
		while(!stack.isEmpty() || temp != null) {
			if(temp != null) {
				stack.push(temp);
				temp = temp.left;
			} else {
				temp = stack.pop();
				System.out.print(temp.data + " ");
				temp = temp.right;
			}
		}
	}
```

<a name="post-order-traversal-using-iteration"></a>
### Post Order Traversal Using Iteration

```java
public void postOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		
		TreeNode current = root;
		Stack<TreeNode> stack = new Stack<>();
		while(current != null || !stack.isEmpty()){
		     if(current != null) {
		          stack.push(current);
			   current = current.left;	
		     } else {
		           TreeNode temp = stack.peek().right;	        	    
		           if(temp == null) {
		                temp = stack.pop();
		                System.out.print(temp.data + " ");
		                while(!stack.isEmpty() && temp == stack.peek().right) {
		                	temp = stack.pop();
		                	System.out.print(temp.data + " "); 
		                }     
		          } else {
			    	   current = temp;
		          }
		     }
		}
```

<a name="height-of-binary-tree"></a>
### Height of Binary Tree

```java
public int height(TreeNode root){
        if(root==null) return 0;
        
        int lheight=height(root.left);
        int rheight=height(root.right);
        
        if(lheight>rheight) return (lheight+1);
        else return (rheight+1);
    }
```

<a name="level-order-of-binary-tree"></a>
### Level Order of Binary Tree

```java
class Solution {
    
    public List<List<Integer>> list=new ArrayList<List<Integer>>();
    
    public int height(TreeNode root){
        if(root==null) return 0;
        
        int lheight=height(root.left);
        int rheight=height(root.right);
        
        if(lheight>rheight) return (lheight+1);
        else return (rheight+1);
    }
    
    public List<Integer> printCurrentLevel(TreeNode root, int level,List<Integer> temp){
        if(root==null){
            return null;
        }
        if(level==1){
            temp.add(root.val);
        }
        else if(level>1){
            printCurrentLevel(root.left,level-1,temp);
            printCurrentLevel(root.right,level-1,temp);
        }
        return temp;
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        int h=height(root);
        for(int i=1;i<=h;i++){
            List<Integer> temp=new ArrayList<Integer>();
            list.add(printCurrentLevel(root,i,temp));
        }
        return list;
    }
}
```

<a name="diameter-of-a-binary-tree"></a>
### Diameter of a Binary Tree

```java
int diameter(Node root)
	{
		if (root == null)
			return 0;
		int lheight = height(root.left);
		int rheight = height(root.right);
      
		int ldiameter = diameter(root.left);
		int rdiameter = diameter(root.right);
		return Math.max(lheight + rheight + 1,
						Math.max(ldiameter, rdiameter));
	}
```

<a name="print-nodes-at-kth-distance-from-the-root"></a>
### Print nodes at Kth Distance from the root

```java
void printKDistant(Node node, int k)
    {
        if (node == null|| k < 0 )
              //Base case
            return;
        if (k == 0)
        {
            System.out.print(node.data + " ");
            return;
        }
       //recursively traversing
            printKDistant(node.left, k - 1);
            printKDistant(node.right, k - 1);
         
    }
```

<a name="print-all-the-ancestors-of-a-given-key"></a>
### Print all the Ancestors of a given Key

```java
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
```

<a name="check-if-a-gievn-tree-is-a-subtree-of-another-binary-tree"></a>
### Check if a gievn tree is a subtree of another Binary Tree

```java
boolean areIdentical(Node root1, Node root2)
	{
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		return (root1.data == root2.data
				&& areIdentical(root1.left, root2.left)
				&& areIdentical(root1.right, root2.right));
	}
	boolean isSubtree(Node T, Node S)
	{
		if (S == null)
			return true;
		if (T == null)
			return false;
		if (areIdentical(T, S))
			return true;
		return isSubtree(T.left, S)
				|| isSubtree(T.right, S);
	}
```
