/**
 * Created by asus-Iabx on 2017/4/9.
 */


  class listNode {
      int val;
      listNode next;
      listNode(int x) { val = x; }
  }
/*
public class addtwonumber {
    public static listNode addTwoNumbers(listNode l1, listNode l2) {
        long numL1=0;
        long numL2=0;
        int i=0;
        while (l1!=null)
        {
         numL1 += l1.val * Math.pow(10, i);
         l1 = l1.next;
         i++;
        }
        i=0;
        System.out.println(numL1);
        while(l2!=null)
        {
            numL2 += l2.val * Math.pow(10, i);
            l2 = l2.next;
            i++;
        }
        System.out.println(numL2);
        long numL4=numL2+numL1;
        System.out.println("numL4="+numL4);
        int numL3=(int)numL4%10;
        System.out.println("numL3="+numL3);
        listNode L3=new listNode(numL3);
        listNode head=L3;
        numL3=(int)numL4/10;
        System.out.println(numL3);

        while(numL3>0)
        {
            listNode p=new listNode(numL3%10);
            head.next=p;
            head=p;
            numL3=numL3/10;
            System.out.println(numL3);
        }
        return L3;
    }
    public static void main(String[] args)
    {
        listNode l1=new listNode(9);
        //l1.next=new listNode(4);
        //l1.next.next=new listNode(3);
        listNode l2=new listNode(1);
        listNode head=l2;
        for(int ll=0;ll<9;ll++)
        {
            listNode pp=new listNode(9);
            head.next=pp;
            head=pp;
        }
        listNode l3=addtwonumber.addTwoNumbers(l1,l2);
        System.out.println(l3.val);
        System.out.println(l3.next.val);
        System.out.println(l3.next.next.val);
        System.out.println(l3.next.next.next.val);




    }
}
*/
public class addtwonumber {
    public static listNode addTwoNumbers(listNode l1, listNode l2) {
        listNode L3=new listNode(0);
        listNode head=L3;
        int temp=0;
        int sum=0;
        while(l1!=null||l2!=null||temp!=0)
        {
            listNode cur=new listNode(0);
            sum=((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + temp;
            cur.val=sum%10;
            head.next=cur;
            sum=sum/10;
            temp=sum;
            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
            head=cur;
        }
        return L3.next;
    }
    public static void main(String args[])
    {
        listNode l1=new listNode(9);
        //l1.next=new listNode(4);
        //l1.next.next=new listNode(3);
        listNode l2=new listNode(1);
        listNode head=l2;
        for(int ll=0;ll<9;ll++)
        {
            listNode pp=new listNode(9);
            head.next=pp;
            head=pp;
        }
        listNode l3=addtwonumber.addTwoNumbers(l1,l2);
        System.out.println(l3.val);
        System.out.println(l3.next.val);
        System.out.println(l3.next.next.val);
        System.out.println(l3.next.next.next.val);
    }
}