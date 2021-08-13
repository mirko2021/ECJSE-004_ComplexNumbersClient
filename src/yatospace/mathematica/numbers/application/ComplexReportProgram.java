package yatospace.mathematica.numbers.application;

import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;

public class ComplexReportProgram {
	public static final String INPUT_PATH  = "C:\\Users\\VM\\eclipse-workspace\\004_ComplexNumbersClient\\IFolder\\input.txt"; 
	public static final String OUTPUT_PATH = "C:\\Users\\VM\\eclipse-workspace\\004_ComplexNumbersClient\\OFolder\\output.txt"; 
	
	public static void main(String ... args) {
		try (
			FileInputStream fis = new FileInputStream(new File(INPUT_PATH)); 
			FileOutputStream fos =  new FileOutputStream(new File(OUTPUT_PATH)); 
			Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999); 
			PrintWriter xosPw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			BufferedReader xisScanner = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8")); 
		){
			System.out.println("Pocetak ocitavanja izvora.");
			byte[] input = fis.readAllBytes(); 
			System.out.println("Prosledjivanje podataka na izvrsavanje server procesu.");
			Scanner scanner = new Scanner(new String(input, "UTF-8"));
			String textA = scanner.nextLine(); 
			String textB = scanner.nextLine(); 
			xosPw.println(textA);
			xosPw.println(textB);
			scanner.close();
			System.out.println("Ocitavanje rezultata.");
			String result = ""; 
			result += xisScanner.readLine()+"\n"; 
			result += xisScanner.readLine()+"\n"; 
			result += xisScanner.readLine()+"\n"; 
			result += xisScanner.readLine()+"\n"; 
			result += xisScanner.readLine()+"\n"; 
			result += xisScanner.readLine()+"\n"; 
			result += xisScanner.readLine()+"\n"; 
			result += xisScanner.readLine()+"\n"; 
			result += xisScanner.readLine()+"\n"; 
			result += xisScanner.readLine()+"\n"; 
			result += xisScanner.readLine()+"\n"; 
			result += xisScanner.readLine()+"\n"; 
			result += xisScanner.readLine()+"\n"; 
			result += xisScanner.readLine()+"\n"; 
			result += xisScanner.readLine()+"\n"; 
			result += xisScanner.readLine()+"\n"; 
			result += xisScanner.readLine()+"\n"; 
			result += xisScanner.readLine()+"\n"; 
			byte[] output = result.getBytes("UTF-8");
			System.out.println("Zapisivanje rezultata.");
			fos.write(output);
			System.out.println("Zapisivanje rezultata zavrseno.");
			System.out.println("Izvrsavanje distribuirane aplikacije zavrseno.");
		}catch(Exception ex) {
			System.out.println("Dogodila se greska.");
		}
	}
}
