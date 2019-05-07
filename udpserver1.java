import java.io.*;
import java.net.*;

class udpserver1
{
DatagramSocket ds;
DatagramPacket dp;
byte[] recevpackt;
BufferedReader in;
InetAddress ip;
int port;
String str;
public udpserver1()
{
 try
{
 
 ds= new DatagramSocket(1456);
 while(true)
{
recevpackt=new byte[100];
dp=new DatagramPacket(recevpackt,recevpackt.length);
ds.receive(dp);
String data = new String(dp.getData(),0,dp.getLength());
System.out.println("Client: "+data);

if (data.equals("exit"))
 System.exit(0);
}
}
catch(Exception e)
{

}
}

public static void main(String args[])
{
udpserver1 s = new udpserver1();
}
} 