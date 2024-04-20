import java.io.*;
public class FileSearch implements Runnable
{
    public File f;
    public String str;

    public FileSearch(File file,String str)
    {
        this.f = file;
        this.str=str;
    }

    public void run()
    {
        try{
            String line;
            int cnt = 0;
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            while((line = br.readLine())!=null)
            {
                cnt++;
                if(line.contains(str))
                {
                    System.out.println("File Name : "+f.getName() +"\tLine Number :"+cnt);
                }
            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static void main(String[] args) 
    {

        String str = "Thread";

        File files = new File(".");
        File[] allfiles = files.listFiles();

        for(File f : allfiles)
        {
            Thread t = new Thread(new FileSearch(f,str));
            t.start();
        }

    }
}