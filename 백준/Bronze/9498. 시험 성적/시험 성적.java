import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		char res;
		switch(a / 10) {
			case 10:
			case 9: res = 'A'; break;
			case 8: res = 'B'; break;
			case 7: res = 'C'; break;
			case 6: res = 'D'; break;
			default: res = 'F';
		}
		System.out.print(res);
	}
}