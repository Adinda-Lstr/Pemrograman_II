package MODUL1;
import java.util.Scanner;

public class PRAK102_24108171220015_AdindaLestari {
 
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		
	for (int j = 0; j <10; j++) {
		System.out.print(" ");
		int NilaiAwal = input.nextInt();
		
		
	
		int i = 0;
		while (i <= 10) {
			int NilaiSekarang;
			if (NilaiAwal %5 == 0) {
				NilaiSekarang = NilaiAwal / 5 - 1;
				
	} else {
		NilaiSekarang = NilaiAwal;
		
	}
		if (i ==0) {
			System.out.print(NilaiSekarang);
		}else {
			System.out.print(", " + NilaiSekarang);
		}
	NilaiAwal++;
	i++;
		}
		System.out.println();

	}
	}

}

