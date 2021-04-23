package day4;

public class Day4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(steviloGesel(172930,683082));

	}
	public static int steviloGesel(int spodnja, int zgornja) {
		int stevilo = 0;
		for(int geslo = spodnja; geslo<=zgornja; geslo++) {
			int zadnji = 10; 
			int enaki = 0;
			boolean narasca = true;
			int x = geslo;
			while(x > 0) {
				int trenutni = x % 10;
				if(trenutni == zadnji) enaki += 1;
				else if (zadnji<trenutni) {
					narasca = false;
					break;
				}
				zadnji = trenutni;
				x /= 10;
			}
			if(enaki>=1 && narasca) stevilo +=1;
		}
		return stevilo;
	}
}
