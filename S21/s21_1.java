import java.util.*;
import java.io.*;

public class s21_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> list = new LinkedList<Integer>();
		System.out.print("Enter the number of integers: ");
		int n = sc.nextInt();
		System.out.println("Enter " + n + " integers:");
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			list.add(num);
		}
		Iterator itr = list.iterator();
		if (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}