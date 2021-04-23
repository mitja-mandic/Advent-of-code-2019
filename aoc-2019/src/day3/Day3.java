package day3;

//import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
//import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.List;

public class Day3 {

	public static void main(String[] args) throws IOException{
		System.out.println(druga("input/day3.in", "output/day3_1.out"));
	}
    public static void izpis(String[] polinom) {
        System.out.print('{');
        for (int i = 0; i < polinom.length; ++i) {
            if (i > 0) System.out.print(", ");
            System.out.print(polinom[i]);
        }
        System.out.println("}");
    }
	public static String[][] preberi(String input) throws IOException {
		BufferedReader vhod = new BufferedReader(new FileReader(input));
		String[][] tabela = new String[2][];
        int i = 0;
		while(vhod.ready()) {
        	String[] vrstica = vhod.readLine().trim().split(",");
        	tabela[i] = vrstica;
        	i += 1;
        }
        vhod.close();
        return tabela;
	}
	public static List<Koordinate> zica(String[] ukazi) {
		char gor = 'U';
		char dol = 'D';
		char levo = 'L';
		char desno = 'R';
		
		List<Koordinate> seznam = new ArrayList<Koordinate>();

		for(String ukaz:ukazi) {
			char smer = ukaz.charAt(0);
			int stevilo = Integer.parseInt(ukaz.substring(1));
			
			for(int j=1; j<=stevilo;j++) {
				int trenutniX = 0;
				int trenutniY = 0;
				
				if(seznam.size()>0) {	
					Koordinate pozicija = seznam.get(seznam.size()-1);
					trenutniX = pozicija.getX();
					trenutniY = pozicija.getY();
					}
				
				if(smer==gor) seznam.add(new Koordinate(trenutniX, trenutniY+1));
				if(smer==dol) seznam.add(new Koordinate(trenutniX, trenutniY-1));
				if(smer==desno) seznam.add(new Koordinate(trenutniX+1, trenutniY));
				if (smer==levo) seznam.add(new Koordinate(trenutniX-1, trenutniY));
			}
		}
		 
		return seznam;
	}
	public static int najblizjePresecisce(List<Koordinate> zica1, List<Koordinate> zica2) {
		int trenutni = Integer.MAX_VALUE;
		for(Koordinate k1 : zica1) {
			for(Koordinate k2: zica2) {
				if(k1.equals(k2)) {
					int razdalja = Math.abs(k1.getX()) + Math.abs(k1.getY());
					if(razdalja > 0 && razdalja < trenutni) trenutni = razdalja;
				}
			}
		}
		return trenutni;
	}
	
	public static int prva(String input, String output) throws IOException {
		String[][] tabeli = preberi(input);
		PrintWriter izhod = new PrintWriter(new FileWriter(output));
		String[] tab1 = tabeli[0];
		String[] tab2 = tabeli[1];
		
		int presecisce = najblizjePresecisce(zica(tab1), zica(tab2));
		izhod.println(presecisce);
		izhod.close();
		return presecisce;
		}
	public static int druga(String input, String output) throws IOException{
		String[][] tabeli = preberi(input);
		PrintWriter izhod = new PrintWriter(new FileWriter(output));
		String[] tab1 = tabeli[0];
		String[] tab2 = tabeli[1];
		
		int trenutni = Integer.MAX_VALUE;
		List<Koordinate> zica1 = zica(tab1);
		List<Koordinate> zica2 = zica(tab2);
		int i = 0;
		for(Koordinate k1 : zica1) {
			int j = 0;
			i += 1;
			for(Koordinate k2: zica2) {
				j += 1;
				if(k1.equals(k2)) {
					int razdalja = i + j;
					if(razdalja < trenutni) trenutni = razdalja;
				}
			}
		}
		izhod.close();
		return trenutni;
	}
}
