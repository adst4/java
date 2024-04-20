import java.util.*;
public class MySet {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        LinkedList l = new LinkedList();
        
        System.out.println("Enter How Many Integers : ");
        int n = sc.nextInt();
        
        System.out.println("Enter Elements : ");
        for(int i=0;i<n;i++)
        {
            l.add(sc.nextInt());
        }

        TreeSet t = new TreeSet(l);
        System.out.println("Elements in Sorted Order : "+t);

        System.out.println("Enter Element to search : ");
        int ele = sc.nextInt();

        Iterator itr = t.iterator();
        while(itr.hasNext())
        {
            if(itr.next().equals(ele))
            {
                System.out.println("Element is present In set");
                return;
            }
        }
        System.out.println("Element Not Found....");


    }
}
