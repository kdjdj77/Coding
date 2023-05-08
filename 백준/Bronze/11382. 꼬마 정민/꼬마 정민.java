import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Long a = Long.parseLong(st.nextToken());
		Long b = Long.parseLong(st.nextToken());
		Long c = Long.parseLong(st.nextToken());
		System.out.print(a+b+c);
	}
}