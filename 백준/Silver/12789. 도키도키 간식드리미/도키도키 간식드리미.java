import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int next = 1; br.readLine();
		Stack<Integer> s = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			while(!s.isEmpty() && s.peek() == next) {s.pop(); next++;}
			s.push(Integer.parseInt(st.nextToken()));
			while(!s.isEmpty() && s.peek() == next) {s.pop(); next++;}
		}
		System.out.print(s.isEmpty() ? "Nice" : "Sad");
	}
}