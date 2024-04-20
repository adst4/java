import java.util.Scanner;
import java.util.LinkedList;

public class s19_1 {
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
        System.out.println("Negative Integers:");
        for (int i : list) {
            if (i < 0) {
                System.out.println(i);
            }
        }
        sc.close(); // Close the scanner
    }
}
