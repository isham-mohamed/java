import java.io.*;
import java.net.*;

 class brcli
{

  int i=0;
  Socket s;

  BufferedReader br,br1;
  String str,msg,str2;
  PrintStream out;
  
  brcli()
  {
  try
   {

   s=new Socket("localhost",8000);
   br=new BufferedReader(new InputStreamReader(s.getInputStream()));
   br1=new BufferedReader(new InputStreamReader(System.in));
   out=new PrintStream(s.getOutputStream(),true);
   
   System.out.println("Enter file name to be read: ");
   str=br1.readLine();
   out.println(str);
  System.out.println("Enter the file name to write: ");
  str2=br1.readLine();
  FileOutputStream fout= new FileOutputStream(str2);

   while(true)
    {
   try
    {

    msg=br.readLine();
    System.out.println(msg);
    byte b[]=msg.getBytes(); 
    fout.write(b);
   
    }catch(Exception e){}
   }
  }catch(Exception e){}
}
 public static void main(String args[])
  {
   brcli f=new brcli();
  }

}

