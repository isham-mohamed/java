//client two way communication
import java.io.*;
import java.net.*;
class client1
{
	Socket cs;
	BufferedReader in1,in;
	PrintWriter out;
	String str,str1;
	public client1()
	{
	try
	{
	in1=new BufferedReader(new InputStreamReader(System.in));
	cs=new Socket("localhost",5000);
	out=new PrintWriter(cs.getOutputStream(),true);
	in=new BufferedReader(new InputStreamReader(cs.getInputStream()));
	while(true)
	{
	System.out.println("say:");
	str=in1.readLine();
	out.println(str);
	if(str.equals("exit"))
	{
	System.exit(0);
	}
	str1=in.readLine();
	if(str1.equals("exit"))
	{
	System.exit(0);
	}
	System.out.println("server said:"+str1);
	}
	}
	catch(Exception e)
	{
	System.out.println(e);
	}
	}
	public static void main(String args[])
	{
	client1 s=new client1();
	}
}