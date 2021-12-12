import java.io.*;
import java.net.*;
import java.util.*;
public class SocketStuff {
	public static void main(String[] args) {
		System.out.println(args[0]);
		String user;
		String host;
		if((args.length == 1) && (args[0].contains("@"))){
			StringTokenizer split = new StringTokenizer(args[0], "@");
			user = split.nextToken();
			host = split.nextToken();
		}else {
			System.out.println("didnt work");
			return;
		}
		
		try( Socket digit = new Socket(host, 79); 
				BufferedReader in = new BufferedReader(
						new InputStreamReader(digit.getInputStream()));
		){
			digit.setSoTimeout(20000);
			PrintStream out = new PrintStream(digit.getOutputStream());
			out.print(user + "\015\012");
			
			boolean eof = false;
			while(!eof) {
				String line = in.readLine();
				if( line != null) {
					System.out.println(line);
				}else {
					eof = true;
				}
			}
			digit.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
	}
}
