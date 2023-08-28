import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        long n = Long.parseLong(new BufferedReader(new InputStreamReader(System.in)).readLine()), p=n;
		for(long i=2; i*i<=n; i++) {
			if (n%i==0) p-=p/i;
			while(n%i==0) n/=i;
		}
		System.out.print(n==1?p:p-p/n);
    }
}