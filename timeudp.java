import java.io.*;
import java.util.*;
import java.net.*;

public class timeudp{
DatagramSocket ds;
DatagramPacket dp;
DatagramPacket dp1;
byte[] recevpackt=new byte[100];
byte[] sendpackt=new byte[100];
BufferedReader in;
InetAddress ip,a;
int port,p;
String str;
public timeudp()
{
try{

ip=InetAddress.getByName("localhost");
in=new BufferedReader(new InputStreamReader(System.in));
ds=new DatagramSocket(1456);
while(true)
{

/*recevpackt=new byte[100];
dp=new DatagramPacket(recevpackt,recevpackt.length);
ds.receive(dp);
String data=new String(dp.getData(),0,dp.getLength());
System.out.println("client:"+data);
a=dp.getAddress();
p=dp.getPort();

 
sendpackt=new byte[100];
System.out.println("Server:");
str=in.readLine();
sendpackt=str.getBytes();
dp1=new DatagramPacket(sendpackt,sendpackt.length,a,p);
ds.send(dp1);*/

recevpackt=new byte[100];
dp=new DatagramPacket(recevpackt,recevpackt.length);
ds.receive(dp);
String data=new String(dp.getData(),0,dp.getLength());
a=dp.getAddress();
p=dp.getPort();
//dp1=new DatagramPacket();
if(data.equals("time"))
{
System.out.println("Recieved"+data);
Date d=new Date();
String time=d+"";
sendpackt=time.getBytes();
}
else
{
String str="Invalid Request";
sendpackt=str.getBytes();
}
dp1=new DatagramPacket(sendpackt,sendpackt.length,a,p);
ds.send(dp1);



if(data.equals("exit"))
System.exit(0);
}
}
catch(Exception e){
System.out.println(e);
}
}
public static void main(String args[]){
timeudp s=new timeudp();
}
}