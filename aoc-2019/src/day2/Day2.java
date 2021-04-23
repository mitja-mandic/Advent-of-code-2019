package day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Day2 {

	public static void main(String[] args) throws IOException {
		//System.out.println(preberi("input/day2.txt", "output/day2.out"));
		System.out.println(druga("input/day2.txt", "output/day2.out"));
//		int[] tab = preberiDatoteko("input/day2.txt");
//		System.out.println(izracunaj(tab));
		
	}

	public static int izracunaj(int[] tabela) {
		int i = 0;
		int sestej = 1;
		int zmnozi = 2;
		while (tabela[i] != 99) {
			int ukaz = tabela[i];
			int prvi = tabela[tabela[i+1]];
			int drugi = tabela[tabela[i+2]];
			int pozicija = tabela[i+3];
			
			if(ukaz == sestej) tabela[pozicija] = prvi + drugi;
			else if (tabela[i] == zmnozi) tabela[pozicija] = prvi * drugi;
			i+=4;
		}
		return tabela[0];
	}

	public static int[] preberiDatoteko(String input) throws IOException {
		BufferedReader vhod = new BufferedReader(new FileReader(input));
		int [] tabela = {};
        while(vhod.ready()) {
        	String[] vrstica = vhod.readLine().trim().split(",");
        	tabela = new int[vrstica.length];
        	for (int i = 0; i<vrstica.length; i++) tabela[i] = Integer.parseInt(vrstica[i]);
        }
        vhod.close();
        return tabela;
	}
	public static int preberi(String inputFile, String outputFile) throws IOException {
        PrintWriter izhod = new PrintWriter(new FileWriter(outputFile));
        //int[] tabela = {};
        int rezultat = 0;
        int[] tabela = preberiDatoteko(inputFile);
    	tabela[1] = 12;
    	tabela[2] = 2;
    	rezultat = izracunaj(tabela);
 
        izhod.println(rezultat);
        izhod.close();
        return rezultat;
	}
	//Drugi del
	public static int druga(String inputFile, String outputFile) throws IOException {
        PrintWriter izhod = new PrintWriter(new FileWriter(outputFile));
        int st = 0;
        for(int i = 0; i<100;i++) {
        	for(int j = 0; j<100;j++){
        		int[] tabela = preberiDatoteko(inputFile);
        		
        		tabela[1] = i;
        		
        		tabela[2] = j;
        		
        		if(izracunaj(tabela) == 19690720) st = 100 * i + j;
        	}
        }
        izhod.println(st);
        izhod.close();
        
        return st;
        }
	
}
