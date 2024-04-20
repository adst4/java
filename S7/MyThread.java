import java.util.*;
class Thread1 extends Thread
{
    public int num;
    public Thread1(int n)
    {
        this.num = n;
    }
    public void run()
    {
        System.out.println("Thread 2 : Square of "+num +" is "+(num*num));
    }
}

class Thread2 extends Thread
{
    public int num;
    public Thread2(int n)
    {
        this.num = n;
    }
    public void run()
    {
        System.out.println("Thread 3 : Cube of "+num +" is "+(num*num*num));
    }
}


public class MyThread extends Thread
{
    Random rand = new Random();
    public void run()
    {
        try
        {   
            while(true) 
            {
                int num = rand.nextInt(10);
                if(num%2==0)
                {
                    Thread1 t1 = new Thread1(num);
                    t1.start();
                }
                else
                {
                    Thread2 t2 = new Thread2(num);
                    t2.start();
                }
                Thread.sleep(1000);
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}
