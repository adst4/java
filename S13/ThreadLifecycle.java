public class ThreadLifecycle {
    public static void main(String[] args) {
      // Create and start 5 threads
      for (int i = 0; i < 5; i++) {
        Thread t = new MyThread("Thread-" + i);
        t.start();
      }
    }
  }
  
  class MyThread extends Thread {
    private static final int MAX_SLEEP_TIME = 4999;
  
    public MyThread(String name) {
      super(name);
    }
  
    public void run() {
      // Generate a random sleep time
      int sleepTime = (int) (Math.random() * MAX_SLEEP_TIME);
  
      // Print the name of the thread and the sleep time
      System.out.println(getName() + " is sleeping for " + sleepTime + " milliseconds.");
  
      try {
        // Sleep for the specified amount of time
        Thread.sleep(sleepTime);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
  
      // Print the name of the thread and indicate that it is dead
      System.out.println(getName() + " is dead.");
    }
  }