import java.util.*;
import java.io.*;

class S16_1 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TreeSet ts = new TreeSet();
		int i, n, num;
		System.out.println("How many Integers :");
		n = Integer.parseInt(br.readLine());
		System.out.println("Enter the number :");
		for (i = 0; i < n; i++) {
			num = Integer.parseInt(br.readLine());
			ts.add(num);
		}
		System.out.println("The Integers are ->" + ts);
	}
}
