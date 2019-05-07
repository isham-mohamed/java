import java.io.*;
import java.net.*;

public class tcpclient
{
public static void main(String args[])throws IOException
{
System.out.println("TCP CLIENT");
System.out.println("Ener the host name to connect: ");
DataInputStream inp= new DataInputStream(System.in);
String str=inp.readLine();
Socket clientsoc= new Socket(str,9);
PrintWriter out = new PrintWriter(clientsoc.getOutputStream(),true);
BufferedReader in = new BufferedReader(new InputStreamReader(clientsoc.getInputStream()));
String userinput;
BufferedReader stdin= new BufferedReader(new InputStreamReader(System.in));
try
{
 while(true)
 {
System.out.println("server says: "+in.readLine());
 userinput=stdin.readLine();
out.println(userinput);
}
}
catch(Exception e)
{
 System.exit(0);
}
}
}   