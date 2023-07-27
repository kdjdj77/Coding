import java.io.*;
import java.util.*;

class Tree {
    int len;
    long[] tree;
    Tree(int s){tree = new long[len = s];}
    void update(int idx, long value) {while(idx < len) {tree[idx] += value; idx += (idx & -idx);}}
    long res(int idx){
        long sum = 0;
        while(idx > 0){
            sum += tree[idx];
            idx -= (idx & -idx);
        }
        return sum;
    }
}
public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Reader fr = new Reader();
        int N = fr.nextInt(), M = fr.nextInt(), K = fr.nextInt();
        long[] num = new long[N+1];
        Tree tree = new Tree(N+1);
        for(int i = 1; i <= N; i++) tree.update(i, num[i] = fr.nextLong());
        for(int i = 0, len = M+K; i < len; i++){
            int a = fr.nextInt(), b = fr.nextInt();
            if ((a & 1) == 1){
                long c = fr.nextLong(), dif = c - num[b];
                num[b] = c;
                tree.update(b, dif);
            } else sb.append(tree.res(fr.nextInt()) - tree.res(b-1)).append('\n');
        }
        System.out.print(sb);
    }
}
class Reader {
	BufferedReader br; StringTokenizer st;
    Reader(){br=new BufferedReader(new InputStreamReader(System.in));}
    String nextStr(){if(st==null||!st.hasMoreTokens())try{st=new StringTokenizer(br.readLine());}catch(IOException e){}return st.nextToken();}
    int nextInt(){return Integer.parseInt(nextStr());}
    long nextLong(){return Long.parseLong(nextStr());}
}