import java.io.*;
import java.net.*;

 class brserv
{

 int i=0,j;
  ServerSocket ss;
  Thread t;
  Socket s[]=new Socket[10];
  PrintStream ps[]=new PrintStream[10];
  BufferedReader br;
  BufferedReader cin[]=new BufferedReader[10];;
  String str,fname;
  
  brserv()
  {
  try
   {
   
   ss=new ServerSocket(8000); 
   t=new Thread(new thread1());
   t.start();
   
  }
  catch(Exception e){}
 }

 public static void main(String args[])
  {
   brserv f=new brserv();
  }



class thread1 extends Thread
 {
 public void run()
{
while(true)
{
try{

s[i]=ss.accept();
ps[i]=new PrintStream(s[i].getOutputStream(),true);
cin[i]=new BufferedReader(new InputStreamReader(s[i].getInputStream())); 
j=i;
i++;

fname=cin[j].readLine();
    System.out.println(fname);
   File f=new File(fname);
   if(f.exists())
    {
     System.out.println("working.....");
     FileReader fr = new FileReader(f);
     BufferedReader fbr=new BufferedReader(fr);

     str=fbr.readLine();
     while(str!=null)
    {
      System.out.println(str);
     ps[j].println(str);
     str=fbr.readLine();
     }
    }
   else
      {
     System.out.println("File not found ");
      ps[j].println("0");
     // System.exit(0);
      }
  }
   catch(Exception e){}
}
}
}
}