import java.util.*;
public class Student {
    public static void main(String[] args) {
        Hashtable ht = new Hashtable();
        Scanner sc = new Scanner(System.in);
        System.out.print("How Many Students : ");
        int n = sc.nextInt();
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter Student Name :");
            String name = sc.next();
            System.out.println("Enter Mobile Number  :");
            long mn = sc.nextLong();
            ht.put(mn,name);
        }

        Enumeration e = ht.keys();
        System.out.println("Name\tMobile Number");
        while(e.hasMoreElements())
        {
            Object mn = e.nextElement();
            Object name = ht.get(mn);
            System.out.println( name +"\t" +mn);
        }
        
    }
}
