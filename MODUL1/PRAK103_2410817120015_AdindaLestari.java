package MODUL1;
import java.util.Scanner;
public class PRAK103_2410817120015_AdindaLestari {

	public static void main(String[] args) {
	 Scanner input = new Scanner(System.in);
	 
	 
for (int j = 0;j < 3;j++) {
	int deretN = input.nextInt();
	int angka = input.nextInt();
	int i = 0;
	
	do {
		if (angka % 2 == 1) {
			System.out.print(angka);
			if (i < deretN - 1) {
				System.out.print(", ");
			}
			i++;
		}
		angka++;
	}while (i < deretN);
	System.out.println();
}
input.close();
	}

}
