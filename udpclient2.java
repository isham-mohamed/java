import java.io.*;
import java.net.*;

class udpclient2
{
DatagramSocket ds;
DatagramPacket dp;
//DatagramSocket ds1;
//DatagramPacket dp1;
byte[] sendpackt;
byte[] recevpackt;
BufferedReader in;
InetAddress ip;
int port;
String str;
public udpclient2()
{
 try
{
 in=new BufferedReader(new InputStreamReader(System.in));
 ip=InetAddress.getByName("localhost");
 ds= new DatagramSocket();
 while(true)
{
sendpackt=new byte[100];
System.out.print("Client: ");
str=in.readLine();
sendpackt=str.getBytes();
dp=new DatagramPacket(sendpackt,sendpackt.length,ip,1456);
ds.send(dp);
if (str.equals("exit"))
 System.exit(0);

recevpackt=new byte[100];
dp=new DatagramPacket(recevpackt,recevpackt.length);
ds.receive(dp);
String data = new String(dp.getData(),0,dp.getLength());
System.out.println("Server: "+data);

if (data.equals("exit"))
 System.exit(0);
}
}
catch(Exception e)
{
System.out.println(e);
}
}

public static void main(String args[])
{
udpclient2 s = new udpclient2();
}
} 