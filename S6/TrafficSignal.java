import java.util.*;
import java.util.concurrent.locks.*;
public  class TrafficSignal implements Runnable
{
        Random rand = new Random();
        String singles[] = {"RED","GREEN","YELLOW"};
        String car;

        static Lock lock = new ReentrantLock();

       public TrafficSignal(String str)
       {
        car=str;
       } 

        public  void run()
        {
            int flag =  0;
            lock.lock(); 
            try
            {
                int cnt = 0;
                while(flag != 1)
                {
                    int no = rand.nextInt(singles.length);
                    String signal = singles[no];
                    if(signal.equals("RED") && cnt == 0)
                    {
                        System.out.println("Current Signal : RED");
                        System.out.println(car +" Is Waiting....");
                        System.out.println();
                        cnt++;
                    }

                    if(signal.equals("YELLOW") && cnt<=1)
                    {
                        System.out.println("Current Signal : YELLOW");
                        System.out.println(car +" Wait For Few Seconds....");
                        System.out.println();
                        cnt++;
                    }

                    if(signal.equals("GREEN"))
                    {
                        System.out.println("Current Signal : GREEN");
                        System.out.println("Road are Empty "+car+" Are Going");    
                        System.out.println();
                        flag = 1;
                    }
                    Thread.sleep(5000);
                }
            }catch(Exception e)
            {
                System.out.println(e);
            }
            finally
            {
                lock.unlock();
            }
        }
        public static void main(String[] args) {
            TrafficSignal car1 = new TrafficSignal("bike");
            TrafficSignal car2 = new TrafficSignal("car");
            TrafficSignal car3 = new TrafficSignal("truck");
            Thread t1 = new Thread(car1);
            Thread t2 = new Thread(car2);
            Thread t3 = new Thread(car3);
            t1.start();
            t2.start();
            t3.start();
        }
}

