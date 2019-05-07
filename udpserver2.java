import java.io.*;
import java.net.*;

class udpserver2
{
DatagramSocket ds;
DatagramPacket dp;
byte[] recevpackt;
byte[] sendpackt;
BufferedReader in;
InetAddress ip,sa;
int port,sp;
String str;
public udpserver2()
{
 try
{
 
 ds= new DatagramSocket(1456);
 in=new BufferedReader(new InputStreamReader(System.in));
 ip=InetAddress.getByName("localhost");
 while(true)
{
recevpackt=new byte[100];
dp=new DatagramPacket(recevpackt,recevpackt.length);
ds.receive(dp);
String data = new String(dp.getData(),0,dp.getLength());
System.out.println("Client: "+data);
sa=dp.getAddress();
sp=dp.getPort();
if (data.equals("exit"))
 System.exit(0);

sendpackt=new byte[100];
System.out.print("Server: ");
str=in.readLine();
sendpackt=str.getBytes();
dp=new DatagramPacket(sendpackt,sendpackt.length,sa,sp);
ds.send(dp);
if (str.equals("exit"))
 System.exit(0);
}
}
catch(Exception e)
{

}
}

public static void main(String args[])
{
udpserver2 s = new udpserver2();
}
} 