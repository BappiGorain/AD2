class buildBST
{
    static class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static Node create(Node root ,int data)
    {
        Node newNode = new Node(data);
        if(root == null)
        {
            root = newNode;
            return root;
        }
        else if(root.data > data)
        {
            root.left = create(root.left, data);
        }
        else
        {
            root.right = create(root.right, data);
        }
        return root;
    }
    
    static Node buildBSTree(int arr[])
    {
        Node root = null;
        for(int element : arr)
        {
            root = create(root, element);
        }
        return root;
    }

    static void inOrder(Node root)
    {
        if(root == null)
        {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }



    public static void main(String args[])
    {
        int arr[] = {30,10,20,50,40};
        Node root = buildBSTree(arr);
        inOrder(root);
    }
}
