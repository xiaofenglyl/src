import java.io.*;
import java.util.*;

/**
 * Created by asus-Iabx on 2017/4/30.
 */


public class sort {
    /* START 开始状态; INASSIGN 赋值状态; INRANGE 下标范围状态;          */
    /* INNUM 数字状态; INID 标识符状态; END 完成状态;                   */
    /* INCHAR 字符状态;INCOMMENT 注释状态;    FUHAO 单分解符状态; DENGHAO 等号状态;                            */
    /* ERROR 出错状态;                                                   */
    private static String[] stable = { "ZERO","ONE","INID","THREE","INNUM","FIVE","FUHAO","SEVEN","DENGHAO","NINE",
            "INASSIGN","ERROR","TWELVE","INRANGE","END","FIFTEEN","SIXTEEN","INCHAR" };
    private static char[] singledelimiter = {'+','-','*','/','(',')',',',';','[',']','<'};
    private static int[] statelist = {0,1,2,3,4,5,6,7,8,9,10,11,12};
    private static int T[][] = {{1,3,5,7,9,12,15,11},
            {1,1,2,2,2,2,2,2},
            {0,0,0,0,0,0,0,0},
            {4,3,4,4,4,4,4,4},
            {0,0,0,0,0,0,0,0},
            {6,6,6,6,6,6,6,6},
            {0,0,0,0,0,0,0,0},
            {8,8,8,8,8,8,8,8},
            {0,0,0,0,0,0,0,0},
            {11,11,11,10,11,11,11,11},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {14,14,14,14,14,13,14,14},
            {0,0,0,0,0,0,0,0},
            {999,999,999,999,999,999,999,999},
            {16,16,11,11,11,11,11,11},
            {11,11,11,11,11,11,17,11},
            {0,0,0,0,0,0,0,0}};
    //HashMap<String,Integer> rw = new HashMap<String,Integer>();
    static String[] rwtable = {"program","type","var","procedure","begin","end","array","of","record","if","then","else",
            "fi","while","do","endwh","read","write","return","integer","char"};

    public static String singleDivide(String singledevide)
    {
        String singleword = null;
        switch (singledevide)
        {
            case "+": singleword = "plus";
                break;
            case "-": singleword = "minus";
                break;
            case "*": singleword = "times";
                break;
            case "/": singleword = "over";
                break;
            case "(": singleword = "lparen";
                break;
            case ")": singleword = "rparen";
                break;
            case ".": singleword = "dot";
                break;
            case "[": singleword = "lmidparen";
                break;
            case "]": singleword = "rmidparen";
                break;
            case ";": singleword = "semi";
                break;
            case ":": singleword = "colon";
                break;
            case ",": singleword = "comma";
                break;
            case "<": singleword = "lt";
                break;
            case "=": singleword = "eq";
                break;
        }
        return singleword;
    }

    public static LinkedList<String> readFileByChars(String fileName) {
        LinkedList<String> list = new LinkedList<>();

        HashSet<String> rwset = new HashSet<String>();
        for(String rw : rwtable) {
            rwset.add(rw);
        }
        HashSet<Character> set = new HashSet<Character>();
        for(Character ct : singledelimiter) {
            set.add(ct);
        }

        File file = new File(fileName);
        int  state = 0;
        Reader reader = null;
        int COLUMNNUM = 0;
        try {
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            StringBuilder sb = new StringBuilder();
            boolean save = true;
            while (true) {
                tempchar = reader.read();

                //去除掉注释部分 不进行存储
                if(((char) tempchar) == '{') {
                    save = false;
                }
                else if(((char) tempchar) == '}') {
                    state = 0;
                    save = true;
                }
                else if(((char) tempchar) == '\n' && !save) {
                    COLUMNNUM++;

                }

                //存储部分
                if(save) {
                    boolean isSave = false;

                    int ch = 0;
                    //判断是字符状态
                    if ((char) tempchar >= 'a' && (char) tempchar <= 'z' || (char) tempchar >= 'A' && (char) tempchar <= 'Z') {
                        ch = statelist[0];
                        state = T[state][ch];
                        isSave = true;

                    }
                    //判断是数字状态
                    else if ( tempchar > 47 &&  tempchar < 58) {
                        ch = statelist[1];
                        state = T[state][ch];
                        isSave = true;
                    }
                    //回车
                    else if (((char) tempchar) == '\n') {
                        COLUMNNUM++;
                        state = 0;
                    }
                    //判断是单分界符
                    else if(set.contains((char) tempchar)) {
                        ch = statelist[2];
                        state = T[state][ch];
                        //System.out.println((char) tempchar);
                        isSave = true;
                    }
                    //判断是不是 ：
                    else if(((char) tempchar) == ':') {
                        ch = statelist[4];
                        state = T[state][ch];
                        isSave = true;
                    }
                    //判断是不是 =
                    else if(((char) tempchar) == '=') {
                        ch = statelist[3];
                        state = T[state][ch];
                        isSave = true;
                    }
                    //判断是不是.
                    else if(((char) tempchar) == '.') {
                        ch = statelist[5];
                        state = T[state][ch];
                        isSave = true;
                    }
                    //判断是不是 '
                    else if( tempchar == 39 ) {
                        ch = statelist[6];
                        state = T[state][ch];
                        isSave = true;
                    }
                    //其他字符
                    else {
                        if((char) tempchar == '}')
                            continue;
                        ch = statelist[7];
                        state = T[state][ch];
                    }


                    //判断是标示符
                    if (stable[state] == "INID"){
                        if (rwset.contains(sb.toString())) {
                            list.add(String.valueOf(COLUMNNUM));
                            list.add(sb.toString().toUpperCase());
                            list.add("ε");                            //list.add("RESERVED WORD");
                        }
                        else {
                            list.add(String.valueOf(COLUMNNUM));
                            list.add("ID");
                            System.out.println(sb.toString());
                            list.add(sb.toString());
                        }
                        sb = new StringBuilder();
                        state = 0;
                        if(isSave){
                            state = T[state][ch];
                        }
                        //continue;
                    }
                    //判断是数字
                    else if (stable[state] == "INNUM") {
                        list.add(String.valueOf(COLUMNNUM));
                        list.add("INIC");
                        list.add(sb.toString());
                        sb = new StringBuilder();
                        state = 0;
                        if(isSave){
                            state = T[state][ch];
                        }
                        //continue;
                    }
                    else if (stable[state] == "INASSIGN")         //赋值符
                    {
                        sb = new StringBuilder();
                        state = 0;
                        list.add(String.valueOf(COLUMNNUM));
                        list.add(":=");
                        list.add("ε");
                        continue;
                    }
                    else if (stable[state] == "DENGHAO")         //等号
                    {
                        //System.out.print(stable[state] + " : ");
                        state = 0;
                        list.add(String.valueOf(COLUMNNUM));
                        list.add("=");
                        list.add("ε");
                        if(isSave){
                            state = T[state][ch];
                        }
                        sb = new StringBuilder();
                        //continue;
                    }
                    else if (stable[state] == "INRANGE")         //数组下标
                    {
                        sb = new StringBuilder();
                        state = 0;
                        list.add(String.valueOf(COLUMNNUM));
                        list.add("..");
                        list.add("ε");
                        continue;
                    }
                    else if (stable[state] == "INCHAR")         //字符
                    {
                        sb = new StringBuilder();
                        state = 0;
                        list.add(String.valueOf(COLUMNNUM));
                        list.add("'");
                        list.add("ε");
                        continue;
                    }
                    else if (stable[state] == "ERROR")         //错误
                    {
                        if(tempchar == -1)
                            break;
                        if((char) tempchar != ' ' && (char) tempchar != '\n' && (char) tempchar != '\r') {
                            sb = new StringBuilder();
                            state = 0;
                            list.add(String.valueOf(COLUMNNUM));
                            list.add("ERROR");
                            list.add("ε");
                            if(isSave){
                                state = T[state][ch];
                            }
                            continue;
                        }

                        sb = new StringBuilder();
                    }

                    else if (stable[state] == "FUHAO")         //字符
                    {
                        list.add(String.valueOf(COLUMNNUM));
                        //list.add(singleDivide(sb.toString()));
                        list.add(sb.toString());
                        list.add("ε");
                        sb = new StringBuilder();
                        state = 0;

                        if(isSave){
                            state = T[state][ch];
                        }
                        /*
                        if((char)tempchar != '\n' && (char)tempchar != '\r' && (char)tempchar != ' ')
                            sb.append((char) tempchar);
                        continue;
                        */
                    }

                    else if (stable[state] == "END")         //结束
                    {
                        list.add(String.valueOf(COLUMNNUM));
                        list.add(".");
                        list.add("ε");
                        sb = new StringBuilder();
                        state = 0;
                        if(isSave){
                            state = T[state][ch];
                        }
                        //break;

                    }
                    //如果当前空格状态清零
                    if (((char) tempchar == ' ')) {
                        state = 0;
                    }
                    if (T[state][ch] != 0) {
                        if (((char) tempchar) != '\n' && (char) tempchar != '\r' && (char) tempchar != ' ') {
                            sb.append((char) tempchar);
                        }
                    }
                }
            }
            list.add(String.valueOf(COLUMNNUM));
            list.add("EOF");
            list.add("ε");
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list = readFileByChars("D:\\Users\\asus\\IdeaProjects\\jd\\src\\c5.txt");
        //List<String> list = new ArrayList<Integer>();
        Iterator<String> iterator = list.iterator();
        File writename = new File("D:\\Users\\asus\\IdeaProjects\\jd\\src\\output.txt");
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            while (iterator.hasNext()) {
                out.write(iterator.next()+" ");
                out.write(iterator.next()+" ");
                out.write(iterator.next()+"\r");
            }
            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}