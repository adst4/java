public class ThreadInfo {
    public static void main(String[] args) {
      Thread t = new MyThread();
      System.out.println("Name: " + t.getName());
      System.out.println("Priority: " + t.getPriority());
    }
  }
  
  class MyThread extends Thread {
    public MyThread() {
      // Set the name and priority of the thread
      setName("MyThread");
      setPriority(MAX_PRIORITY);
    }
  
    public void run() {
      // The thread does not do anything
    }
  }