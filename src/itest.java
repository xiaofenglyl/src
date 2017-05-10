/**
 * Created by asus-Iabx on 2017/4/9.
 */
class ListNode {
    int val;
    listNode next;
    ListNode(int x) { val = x; }
}
public class itest
{
    public static void main(String[] args)
    {
        listNode ls=new listNode(5);
        ls.next.val=4;
        ls=ls.next;
        ls.next.val=3;



    }
}
