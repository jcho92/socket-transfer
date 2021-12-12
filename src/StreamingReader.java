import java.io.*;
public class StreamingReader {

	public static void main(String[] arguments) {
		try(FileInputStream file = new FileInputStream("data.txt");) {
			boolean eof = false;
			int count = 0;
					while(!eof) {
						int input = file.read();
						System.out.println(input + " ");
						if (input == -1) {
							eof = true;
						}else {
							count ++;
						}
					}
			System.out.println("the count is + " +  count);
		} catch (IOException e){
			System.out.println(e);
			
		}
		
	}
}
