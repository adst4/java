import java.io.*;
import java.util.*;

class s17_1 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TreeSet ts = new TreeSet();
		int i, n, no, choice;
		System.out.println("Enter How many numbers :");
		n = Integer.parseInt(br.readLine());
		System.out.println("Enter the numbers :");
		for (i = 0; i < n; i++) {
			no = Integer.parseInt(br.readLine());
			ts.add(no);
		}
		do {
			System.out.println("1)Search fo number:");
			System.out.println("2)dispaly all");
			System.out.println("3)exit");
			System.out.println("Enter you choice:");
			choice = Integer.parseInt(br.readLine());
			switch (choice) {
				case 1:
					System.out.println("Enter th no to be searched ");
					n = Integer.parseInt(br.readLine());
					if (ts.contains(n)) {
						System.out.println("Elemnt present:\t" + n);
					} else
						System.out.println("Not Present \t" + n);
					break;
				case 2:
					System.out.println(ts);
					break;
				case 3:
					return;
			}
		} while (choice != 3);
	}
}