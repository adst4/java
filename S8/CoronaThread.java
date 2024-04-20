class Thread1 extends Thread
{
    String str;
    int cnt;
    public Thread1(String str,int cnt)
    {
        this.str = str;
        this.cnt = cnt;
    }

    public void run()
    {
        try
        {
            for(int i=0;i<cnt;i++)
            {
                System.out.println(str);
                Thread.sleep(2000);
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}


public class CoronaThread 
{
    public static void main(String[] args) 
    {
        Thread1 t1 = new Thread1("COVID19",10);
        Thread1 t2 = new Thread1("LOCKDOWN2020",15);
        Thread1 t3 = new Thread1("VACCINATED2021",20);
        t1.start();
        t2.start();
        t3.start();
    }
}
