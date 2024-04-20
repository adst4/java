import java.util.*;
public class MyHashFriend {
    public static void main(String[] args) {
        HashSet hs = new HashSet();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter How May Student : ");
        int n = sc.nextInt();

        System.out.println("Enter Student Name : ");
        for(int i=0;i<n;i++)
        {
            hs.add(sc.next());
        }

        TreeSet<String> ts = new TreeSet<String>(hs);

        System.out.println("\naStudents : ");
        for(String str : ts)
        {
            System.out.println(str);
        }
    }
}





