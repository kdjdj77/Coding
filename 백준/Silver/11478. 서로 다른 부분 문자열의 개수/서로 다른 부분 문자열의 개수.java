import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        HashSet<String> set = new HashSet<>();
        
        int len = text.length();
        for(int i = 1; i <= len; i++)
        	for(int j = 0; j <= len - i; j++)
        		set.add(text.substring(j, j + i));
        System.out.println(set.size());
	}
}