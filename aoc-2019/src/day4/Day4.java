package day4;

public class Day4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(druga(172930,683082));

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
	public static int druga(int spodnja, int zgornja) {
		int stevilo = 0;
		for(int geslo = spodnja; geslo<=zgornja; geslo++) {
			int zadnji = 10; 
			int enaki = 0;
			boolean narasca = true;
			boolean dvojne = false;
			int ponovitve = 1;
			int x = geslo;
			while(x > 0) {
				int trenutni = x % 10;
				if(trenutni == zadnji) {
					enaki += 1;
					ponovitve += 1;
				}
				else {
					if (zadnji<trenutni) {
						narasca = false;
						break;
					}
					if(ponovitve == 2) dvojne = true;
					ponovitve = 1;
				}
				zadnji = trenutni;
				x /= 10;
			}
			if(ponovitve == 2) dvojne = true;
			
			if(enaki>=1 && narasca && dvojne) stevilo +=1;
		}
		return stevilo;
	}
}
