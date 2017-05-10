import java.util.*;
public class Main {


    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] index=new int[n];
        int j=0;
        while(sc.hasNext())
        {
            String s=sc.nextLine();
            Set a=null;
            Set b=null;
            for(int i=0;i<n;i++)
            {
                if((s.charAt(i)!='X')&&(s.charAt(i)!='#'))
                {
                    index[j]=(int)(s.charAt(i));
                    j++;
                }
            }
            for(int k=0;k<j;k++)
            {
                int len=index[k]+index[k];
                if(len>n||len==n)
                    len=n;
                for(int l=index[k];l<len;l++)
                {
                    if(s.charAt(l)=='X')
                        a.add(l);
                }
            }
            StringBuilder ss=new StringBuilder(s);
            String sstr=ss.reverse().toString();
            for(int ik=0;ik<j;ik++)
            {
                int ilen=index[ik]+index[ik];
                if(ilen>n||ilen==n)
                    ilen=n;
                for(int il=index[ik];il<ilen;il++)
                {
                    if(s.charAt(il)=='X')
                        b.add(il);
                }
            }
            System.out.println(a.size()+b.size());

        }


    }
}