import java.util.*;
public class MyList {
    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList<String>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do
        {
            System.out.println("1 : Add Element At The End.");
            System.out.println("2 : Delete First Element.");
            System.out.println("3 : Reverse Display.");
            System.out.println("4 : Exit");
            System.out.print("Enter Your Choice : ");
            choice = sc.nextInt();
            switch(choice)
            {
                case 1 :
                    System.out.print("\nEnter Element To Insert : ");
                    l.add(sc.next());
                    System.out.println("Element Add Successfully...\n");
                    break;

                case 2 :
                   l.remove(0);
                   break;

                case 3 : 
                    ListIterator litr = l.listIterator(l.size());
                    while(litr.hasPrevious())
                    {
                        System.out.println(litr.previous());
                    }
                    System.out.println();
                    break;

                case 4 :
                    System.out.println("Existing........!");
                    System.exit(0);

                default : System.out.println("\nInvalid Choice Try Again....!\n");

            }

        }while(choice!=4);
    }
}
