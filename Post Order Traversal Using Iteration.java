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
