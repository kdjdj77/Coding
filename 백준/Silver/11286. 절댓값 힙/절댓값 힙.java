import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        PriorityQueue<Integer> PQ = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Integer a, Integer b){
                int x = Math.abs(a);
                int y = Math.abs(b);
                if(x == y) return a > b ? 1 : -1;
                else return x - y;
            }
        });
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
        	if (x != 0) PQ.add(x);
            else sb.append(PQ.size() == 0 ? 0 : PQ.poll()).append("\n");
        }
        System.out.print(sb);
    }
}