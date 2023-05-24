import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Map<String, Float> map = new HashMap<>();
		map.put("A+", 4.5f); map.put("A0", 4f); map.put("B+", 3.5f); map.put("B0", 3f);
		map.put("C+", 2.5f); map.put("C0", 2f); map.put("D+", 1.5f); map.put("D0", 1f);
		map.put("F", 0f);
		float s = 0, d = 0;
		for(int i = 0; i < 20; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			float credit = Float.parseFloat(st.nextToken());
			String grade = st.nextToken();
			if (!"P".equals(grade)) { s += credit * map.get(grade); d += credit; }
		}
		System.out.print(s/d);
	}
}