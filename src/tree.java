import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by asus-Iabx on 2017/4/24.
 */
class treeNode {
    int data;
    treeNode childnode;
    treeNode rightbrothernode;
    public treeNode(int data)
    {
        this.data=data;
    }
}
public class tree
{
    public static String layersearch(treeNode lnode)
    {
        StringBuilder a=new StringBuilder();
        if(lnode!=null)
        {
            String ndata=String.valueOf(lnode.data);
            a.append(ndata);
        }
        LinkedList<treeNode> queue =new LinkedList<treeNode>();
            queue.add(lnode);


        while(!queue.isEmpty())
        {
            treeNode node = queue.poll();
            if(node.childnode!=null) {
                queue.add(node.childnode);
                String data = String.valueOf(node.childnode.data);
                a.append(data);
                if(node.childnode.rightbrothernode!=null)
                {
                    queue.add(node.childnode.rightbrothernode);
                    String rdata=String.valueOf(node.childnode.rightbrothernode.data);
                    a.append(rdata);
                }
            }



        }
        return a.toString();
    }
    public static void main(String[] args)
    {
        treeNode f=new treeNode(9);
        treeNode a=new treeNode(4);
        treeNode b=new treeNode(5);
        treeNode c=new treeNode(6);
        treeNode d=new treeNode(7);
        treeNode e=new treeNode(8);
        a.childnode=b;
        b.rightbrothernode=c;
        b.childnode=d;
        d.rightbrothernode=e;
        d.childnode=null;
        e.childnode=null;
        c.childnode=f;
        f.childnode=null;
        String ll=layersearch(a);
        System.out.print(ll);

    }
}