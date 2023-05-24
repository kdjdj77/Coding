import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		String res;
		if (A+B+C != 180) res = "Error";
		else if (A == B && A == C) res = "Equilateral";
		else res = A == B || B == C || C == A ? "Isosceles" : "Scalene";
		System.out.print(res);
	}
}