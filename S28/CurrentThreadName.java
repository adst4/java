
public class CurrentThreadName {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("Currently executing thread: " + t.getName());
    }
}
