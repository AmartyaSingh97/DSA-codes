package com.company;
import java.util.*;
import java.util.LinkedList;

public class Trees {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }}

    static class BinaryTree{
        static int idx=-1;

        // To build a tree
        public static Node BuildTree(int[] nodes){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left= BuildTree(nodes);
            newNode.right= BuildTree(nodes);

            return newNode;
        }

        // Recursive Method for first three traversals. - DFS
        // Pre-Order Traversal -- O(n)
        public static void PreOrder(Node root){
            if(root==null){
                return;
            }
            System.out.print(root.data + " ");
            PreOrder(root.left);
            PreOrder(root.right);
        }

        // Iterative pre-order traversal
        public static void PreOrder_2(Node root){
            if(root==null){
                System.out.println("empty tree");
            }
            Stack<Node> s = new Stack<>();
            s.push(root);
            while(!s.isEmpty()){
                Node curr = s.pop();
                System.out.print(curr.data + "");
                if(curr.right!=null){
                    s.push(curr.right);}
                if (curr.left != null) {
                    s.push(curr.left);}}}

        // In-Order Traversal -- O(n)
        public static void InOrder(Node root){
            if(root==null){
                return;
            }
            InOrder(root.left);
            System.out.print(root.data + " ");
            InOrder(root.right);
        }

        // Iterative In-Order traversal
        public static void InOrder_2(Node root){
            Stack<Node> stack = new Stack<>();
            Node curr = root;
            while(curr!=null || !stack.isEmpty()){
                while(curr!=null){
                    stack.push(curr);
                    curr=curr.left;
                }
                curr=stack.pop();
                System.out.print(curr.data + " " );
                curr=curr.right;
            }
        }

        // Post-Order Traversal -- O(n)
        public static void PostOrder(Node root){
            if(root==null){
                return;
            }
            PostOrder(root.left);
            PostOrder(root.right);
            System.out.print(root.data + " ");
        }

        // Iterative post-order traversal
        public static void PostOrder_2(Node root){
            if(root==null){
                System.out.println("empty tree");
            }
            Stack<Node> s = new Stack<>();
            s.push(root);
            while(!s.isEmpty()){
                Node curr = s.pop();
                System.out.print(curr.data + " ");
                if(curr.left!=null){
                    s.push(curr.left);}
                if (curr.right != null) {
                    s.push(curr.right);}}}

        // **************************************************************************************
        // LEVEL-ORDER TRAVERSAL -- Iteration + Queue - BFS -- O(n)
        public static void LevelOrder(Node root){
            if(root==null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node curr = q.remove();
                if(curr==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    } else {
                        q.add(null);}}
                else{
                    System.out.print(curr.data+" ");
                    if(curr.left!=null){
                        q.add(curr.left);
                    }
                    if(curr.right!=null){
                        q.add(curr.right);
                    }
                    }}}

        public static List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> ans = new LinkedList<>();
            if(root==null){
                return ans;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                LinkedList<Integer> dummy = new LinkedList<>();
                int n = q.size();
                for(int i=0;i<n;i++){
                    Node node = q.poll();
                    dummy.add(node.data);
                    if(node.left!=null){
                        q.add(node.left);
                    }
                    if(node.right!=null){
                        q.add(node.right);
                    }
                }
                ans.add(dummy);
            }
            return ans;
        }

        // Count number of nodes
        public static int Count(Node root){
            if(root==null){
                return 0;
            }
            int left= Count(root.left);
            int right= Count(root.right);

            return left+right+1;
        }

        // Sum of all the nodes
        public static int Sum(Node root){
            if(root==null){
                return 0;
            }
            int left_sum = Sum(root.left);
            int right_sum = Sum(root.right);

            return left_sum+right_sum+root.data;
        }

        // Height of tree
        public static int Height(Node root){
            if(root==null){
                return 0;
            }
            int left_height = Height(root.left);
            int right_height = Height(root.right);

            return Math.max(left_height,right_height)+1;
        }

        // To calculate diameter of tree.
        // Diameter will be max height which can either be in left subtree or right subtree or will go through node.

        // O(n^2) approach.
        public static int diameter(Node root){
            if(root==null){
                return 0;
            }
            int diam1 = diameter(root.left);
            int diam2 = diameter(root.right);
            int diam3 = Height(root.left)+Height(root.right)+1;

            return Math.max(diam3,Math.max(diam1,diam2));
        }

        // O(n) approach.
        static class TreeInfo{
            int ht,dim;
            TreeInfo(int ht,int dim){
                this.ht = ht;
                this.dim = dim;
            }}

        public static TreeInfo diameter2(Node root){
            if(root==null){
                return new TreeInfo(0,0);
            }
            TreeInfo left = diameter2(root.left);
            TreeInfo right = diameter2(root.right);

            int myHeight = Math.max(left.ht,right.ht)+1;

            int diam1= left.dim;
            int diam2= right.dim;
            int diam3= left.ht+ right.ht+1;
            int myDiam = Math.max(diam3,Math.max(diam1,diam2));

            return new TreeInfo(myHeight,myDiam);
            // myTree.dim to get diameter.
        }

        // To check whether a tree is a subtree of other tree or not
        static class check{
            public static boolean isSubtree(Node root,Node subRoot){
                if(subRoot==null){
                    return true;}
                if(root==null){
                    return false;}
                if(root.data==subRoot.data){
                    isIdentical(root,subRoot);
                }
                return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
            }

            public static boolean isIdentical(Node root,Node subRoot){
                if(root==null && subRoot==null){
                    return true;
                }
                if(root==null || subRoot==null){
                    return false;
                }
                if(root.data==subRoot.data){
                    return isIdentical(root.left,subRoot) && isIdentical(root.right,subRoot);
                }
                return false;
            }
        }

        // Sum of Nodes at Kth level
        public static int sumAtK(Node root,int k){
          if(root==null){
            return 0;
          }
          int count=0,sum=0;
          Queue<Node> q = new LinkedList<>();
          q.add(root);
          q.add(null);

          while(!q.isEmpty()){
              Node curr=q.remove();
              if(curr==null){
                  if(q.isEmpty()){
                      break;
                  }
                  else{
                      q.add(null);
                      count++;
                  }}
              else{
                  if(curr.left!=null){
                  q.add(curr.left);
                  if(count==k){
                      sum+= curr.left.data;
                  }
                  }
                  if(curr.right!=null){
                      q.add(curr.right);
                      if(count==k){
                          sum+= curr.right.data;
                      }}}}
          return sum;
        }

        //*****************************************//
        // Morris Traversal. - O(1) space and O(n) time.
        /* It changes the structure of tree for example: - In a pre-order traversal of a binary tree,
           each vertex is processed in (node, left, right) order.
           This means that the entire left subtree could be placed between the node and its right subtree.*/
        class tNode {
            int data;
            tNode left, right;

            tNode(int item)
            {
                data = item;
                left = right = null;
            }
        }

        class BinaryTree2 {
            tNode root;

            /* Function to traverse a
               binary tree without recursion
               and without stack */
            void MorrisTraversal(tNode root)
            {
                tNode current, pre;

                if (root == null)
                    return;

                current = root;
                while (current != null)
                {
                    if (current.left == null)
                    {
                        System.out.print(current.data + " ");
                        current = current.right;
                    }
                    else {
                /* Find the inorder
                    predecessor of current
                 */
                        pre = current.left;
                        while (pre.right != null
                                && pre.right != current)
                            pre = pre.right;

                /* Make current as right
                   child of its
                 * inorder predecessor */
                        if (pre.right == null) {
                            pre.right = current;
                            current = current.left;
                        }

                /* Revert the changes made
                   in the 'if' part
                   to restore the original
                   tree i.e., fix
                   the right child of predecessor*/
                        else
                        {
                            pre.right = null;
                            System.out.print(current.data + " ");
                            current = current.right;
                        } /* End of if condition pre->right == NULL
                         */

                    } /* End of if condition current->left == NULL*/

                } /* End of while */
            }}

            // To check whether given two trees are same trees.
            public static boolean sameTree(Node p,Node q){
            if(p==q){return true;}
            if(p==null||q==null||p.data!=q.data){return false;}
            return sameTree(p.left,q.left) && sameTree(p.right,q.right);
            }

            // To check whether given tree is symmetric
            public boolean isSymmetric(Node root) {
                return isMirror(root,root);
            }

            public static boolean isMirror(Node root1,Node root2){
            if(root1==null&&root2==null){
                return true;
            }
            if(root1!=null && root2!=null && root1.data==root2.data){
                return isMirror(root1.left,root2.right)&&isMirror(root1.right,root2.left);
            }
            return false;
            }


            

    }}
