package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Day1 {

	public static void main(String[] args) throws IOException{
		System.out.println(gorivo("input/day1.txt", "output/day1_out1.txt"));
		System.out.println(gorivoZaGorivo("input/day1.txt", "output/day1_out2.txt"));

	}
	//Prvi del
	public static int gorivo(String inputFile, String outputFile) throws IOException {
		BufferedReader vhod = new BufferedReader(new FileReader(inputFile));
        PrintWriter izhod = new PrintWriter(new FileWriter(outputFile));
        double gorivo = 0;
        while (vhod.ready()) {
        	int masa = Integer.parseInt(vhod.readLine().trim());
        	gorivo += Math.floor(masa / 3) - 2;
        }
        izhod.println(gorivo);
        vhod.close();
        izhod.close();
        return (int) gorivo;
	}
	
	//Drugi del
	public static int gorivoZaGorivo(String inputFile, String outputFile) throws IOException {
		BufferedReader vhod = new BufferedReader(new FileReader(inputFile));
        PrintWriter izhod = new PrintWriter(new FileWriter(outputFile));
        int gorivo = 0;
        while (vhod.ready()) {
        	
        	int masa = Integer.parseInt(vhod.readLine().trim());
        	
        	while (masa > 6) {
        		int novaMasa = (int) Math.floor(masa / 3) - 2;
        		gorivo += novaMasa;
        		masa = novaMasa;
        	}
        }
        izhod.println(gorivo);
        vhod.close();
        izhod.close();
        return gorivo;
	}
	
}
