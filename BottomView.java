
import java.util.*;
import java.util.Map.Entry;


class Node
{
    int data;
    int hd;
    Node left, right;


    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}


class Tree
{
    Node root;

     public Tree() {}


    public Tree(Node node)
    {
        root = node;
    }


    public void bottomView()
    {
        if (root == null)
            return;


        int hd = 0;


        Map<Integer, Integer> map = new TreeMap<>();


        Queue<Node> queue = new LinkedList<Node>();


        root.hd = hd;
        queue.add(root);


        while (!queue.isEmpty())
        {
            Node temp = queue.remove();


            hd = temp.hd;


            map.put(hd, temp.data);

            if (temp.left != null)
            {
                temp.left.hd = hd-1;
                queue.add(temp.left);
            }

            if (temp.right != null)
            {
                temp.right.hd = hd+1;
                queue.add(temp.right);
            }
        }

        Set<Entry<Integer, Integer>> set = map.entrySet();


        Iterator<Entry<Integer, Integer>> iterator = set.iterator();

      
        while (iterator.hasNext())
        {
            Map.Entry<Integer, Integer> me = iterator.next();
            System.out.print(me.getValue()+" ");
        }
    }
}

public class BottomView
{
    public static void main(String[] args)
    {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        Tree tree = new Tree(root);
        System.out.println("Bottom view of the given binary tree:");
        tree.bottomView();
    }
}