public int height(TreeNode root){
        if(root==null) return 0;
        
        int lheight=height(root.left);
        int rheight=height(root.right);
        
        if(lheight>rheight) return (lheight+1);
        else return (rheight+1);
    }
