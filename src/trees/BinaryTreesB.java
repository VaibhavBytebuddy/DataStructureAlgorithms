package trees;

import java.util.*;

public class BinaryTreesB {

    static class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data=data;
            this.left=null;
            this.right=null;

        }
    }


    static class BinaryTree{
        static int idx=-1;

        public static Node buildTree(int[] nodes)
        {
            idx++;
            if(nodes[idx]==-1)
            {
                return null;
            }
            Node newNode=new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);

            return newNode;

        }

        public static void preOrder(Node root)
        {
            if(root==null)
            {
                return;
            }
            System.out.print(root.data +"-->");
            preOrder(root.left);
            preOrder(root.right);


        }

        public static void inOrder(Node root)
        {
            if(root==null)
            {
                return;
            }

            inOrder(root.left);
            System.out.print(root.data+"-->");
            inOrder(root.right);

        }

        public static void postOrder(Node root)
        {
            if(root==null)
            {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+"-->");

        }

        public static void levelOrder(Node root)
        {
            if(root==null)
            {
                return;
            }

            Queue<Node> q=new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty())
            {
                Node curr=q.remove();
                if(curr==null)
                {
                    System.out.println();
                    if(q.isEmpty())
                    {
                        break;
                    }else
                    {
                        q.add(null);
                    }
                }else {
                    System.out.print(curr.data+"-->");
                    if(curr.left!=null)
                        q.add(curr.left);
                    if(curr.right!=null)
                        q.add(curr.right);
                }

            }

        }

        public static int heightOfTree(Node root)
        {
            if(root==null)
                return 0;

            int lh=heightOfTree(root.left);
            int rh=heightOfTree(root.right);
            return Math.max(lh,rh)+1;
        }

        public static int count(Node root)
        {
            if(root==null)
                return 0;
            int lc=count(root.left);
            int rc=count(root.right);
            return lc+rc+1;
        }

        public static int sumOfNodes(Node root)
        {
            if(root==null)
                return 0;

            int ls=sumOfNodes(root.left);
            int rs=sumOfNodes(root.right);
            return ls+rs+root.data;
        }


    }


    public static void main(String[] args) {
        int[] nodes={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree=new BinaryTree();
        Node root= BinaryTree.buildTree(nodes);

        System.out.println("Level Order");
        BinaryTree.levelOrder(root);

        System.out.println("Height of tree is :"+BinaryTree.heightOfTree(root));

        System.out.println("Count of all nodes in tree :"+BinaryTree.count(root));

        System.out.println("Sume of All nodes in tree is : "+BinaryTree.sumOfNodes(root));
//        System.out.println(root.right.data);

//        System.out.println("PreOrder traversal is :");
//        BinaryTree.preOrder(root);
//        System.out.print("null");
//
//        System.out.println(" \n InOrder traversal is :");
//        BinaryTree.inOrder(root);
//        System.out.print("null");
//
//        System.out.println(" \n PostOrder traversal is :");
//        BinaryTree.postOrder(root);
//        System.out.print("null");






    }
}
