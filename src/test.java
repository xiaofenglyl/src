/**
 * Created by asus-Iabx on 2017/4/7.
 */
import java.util.*;
public class test {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n;
        n=sc.nextInt();
        while(sc.hasNext())
        {
            String s=sc.nextLine();
            String[] a=new String[n];
            a=s.split(" ");
            int b[]=new int[n];
            for(int i=0;i<n;i++)
            {
                b[i]=Integer.parseInt(a[i]);
                System.out.print(b[i]);
            }
        }




    }
}
