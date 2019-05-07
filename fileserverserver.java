import java.io.*;
import java.net.*;
class fileserverserver {
	String s=null;
	int i=0;
	ServerSocket ss;
	Thread t;
	Socket s1[]=new Socket[10];
	PrintStream ps[]=new PrintStream[10];
	BufferedReader br,br1;
	FileReader fr;
	File f;
	String str;
	fileserverserver(){
		try{
			
			ss=new ServerSocket(5000);
			t=new Thread(new thread());
			t.start();
				       		
		
		}
		catch(Exception e){
		}
	}
	public static void main(String args[])
	{
		fileserverserver f=new fileserverserver();
	}
	class thread extends Thread{
		public void run()
		{
			while(true){
				try{
					s1[i]=ss.accept();
					br=new BufferedReader(new InputStreamReader(s1[i].getInputStream()));
					s=br.readLine();
					f=new File(s);
					if(f.exists()){
						System.out.println("file exist");
						ps[i]=new PrintStream(s1[i].getOutputStream(),true);
						fr=new FileReader(f);
						br1=new BufferedReader(fr);
						while((str=br1.readLine())!=null)
						{
							System.out.println(str);
							ps[i].println(str);
						}
					}
						
					i++;
				}
				catch(Exception e){
				}
			}
		}
	}
}

