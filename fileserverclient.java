import java.io.*;
import java.net.*;
import java.util.*;
class fileserverclient{
	PrintStream ps;
	FileOutputStream fout;

	fileserverclient(String str){
		try{
			Socket s=new Socket("localhost",5000);
			System.out.println("enter file name:");
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String str1=br.readLine();
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
			pw.println(str1);
			fout=new FileOutputStream(str); 
			BufferedReader br1=new BufferedReader(new InputStreamReader(s.getInputStream()));
			String mess=" ";
			
			while(true){
			mess=br1.readLine();
				byte b[]=mess.getBytes();
				fout.write(b);
				    
			}			
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public static void main(String args[]){
		fileserverclient f=new fileserverclient(args[0]);
	}
}
