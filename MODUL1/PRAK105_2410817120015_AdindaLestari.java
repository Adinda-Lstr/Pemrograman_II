package MODUL1;
import java.util.Scanner;
public class PRAK105_2410817120015_AdindaLestari {
	private static final double PHI = 3.14;

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		
		
		
			System.out.print("Masukkan jari-jari  :");
			double jariJari = keyboard.nextDouble();
			
			System.out.print("Masukkan Tinggi     :");
			double tinggi = keyboard.nextDouble();
			
			keyboard.close();
			
			double Volume = PHI * jariJari * jariJari * tinggi;
			
		
			System.out.printf("Volume tabung dengan jari-jari %.1f cm dan tinggi %.1f cm adalah %.3f m3\n", jariJari, tinggi, Volume );

	}

}
