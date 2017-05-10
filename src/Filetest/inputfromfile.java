package Filetest;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by asus-Iabx on 2017/5/2.
 */
public class inputfromfile {
    public static void main(String[] args)
    {
        try{
            StringBuffer str = new StringBuffer();
            char[] buf = new char[1024];
            FileReader f = new FileReader("D:\\Users\\asus\\IdeaProjects\\jd\\src\\Filetest\\file.txt");
            while(f.read(buf) > 0) {
                System.out.print(buf);
                System.out.print("*");
                str.append(buf);
            }
            //System.out.println(str.toString());
        }catch(IOException e){

        }
    }
}
