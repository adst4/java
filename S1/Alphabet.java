class MyTread extends Thread
{
    public void run()
    {
        try{
            for(char i='A';i<'Z';i++)
            {
                System.out.println(i);
                Thread.sleep(2000);
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

public class Alphabet{
    public static void main(String[] args) {
        MyTread t = new MyTread();
        t.start();
    }
}
