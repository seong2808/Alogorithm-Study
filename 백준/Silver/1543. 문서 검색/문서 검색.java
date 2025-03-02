import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String s2 = br.readLine();
        
		int size = s.length();
		int size2 = s2.length();
		
		s = s.replace(s2, "");
		System.out.println((size - s.length()) / size2);
	}
}