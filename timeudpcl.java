import java.io.*;
import java.util.*;
import java.net.*;

public class timeudpcl{
DatagramSocket ds;
DatagramPacket dp;
DatagramPacket dp1;
byte[] sendpackt=new byte[100];
byte[] recevpackt=new byte[100];
BufferedReader in;
InetAddress ip;
int port;
String str;
public timeudpcl()
{
try{
in=new BufferedReader(new InputStreamReader(System.in));
ip=InetAddress.getByName("localhost");
ds=new DatagramSocket();
while(true)
{

sendpackt=new byte[100];
System.out.println("client:");
str=in.readLine();
sendpackt=str.getBytes();
dp1=new DatagramPacket(sendpackt,sendpackt.length,ip,1456);
ds.send(dp1);

recevpackt=new byte[100];
dp=new DatagramPacket(recevpackt,recevpackt.length);
ds.receive(dp);
String data=new String(dp.getData(),0,dp.getLength());
System.out.println("Server:"+data);


if(str.equals("exit"))
System.exit(0);
}
}
catch(Exception e){
System.out.println(e);
}
}
public static void main(String args[]){
timeudpcl s=new timeudpcl();
}
}