package a_tools;

import java.io.*;
import java.util.*;
// 빠른 입력 툴
class Reader {
	BufferedReader br; StringTokenizer st;
    Reader(){br=new BufferedReader(new InputStreamReader(System.in));}
    String ns(){if(st==null||!st.hasMoreTokens())try{st=new StringTokenizer(br.readLine());}catch(IOException e){}return st.nextToken();}
    int ni(){return Integer.parseInt(ns());}
    long nl(){return Long.parseLong(ns());}
    double nd(){return Double.parseDouble(ns());}
}