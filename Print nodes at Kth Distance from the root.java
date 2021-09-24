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
