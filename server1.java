//server two way communication
import java.io.*;
import java.net.*;
class server1
{
	ServerSocket ss;
	Socket cs;
	BufferedReader in,in1;
	PrintWriter out1;
	String str,str1;
	public server1()
	{
		try
		{
		ss=new ServerSocket(5000);
		cs=ss.accept();
		in=new BufferedReader(new InputStreamReader(cs.getInputStream()));
		in1=new BufferedReader(new InputStreamReader(System.in));
		out1=new PrintWriter(cs.getOutputStream(),true);
		while(true)
		{
		str=in.readLine();
		System.out.println("client said:"+str);
		System.out.println("say:");
		str1=in1.readLine();
		out1.println(str1);
		if(str.equals("exit"))
		{
		System.exit(0);
		}
		if(str1.equals("exit"))
		{
		System.exit(0);
		}
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}
	public static void main(String args[])
	{
	server1 s=new server1();
	}
}