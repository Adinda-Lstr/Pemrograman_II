package soal1;

import java.util.LinkedList;
import java.util.Scanner;

public class MainDadu {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		LinkedList<Dadu> daftarDadu = new LinkedList<>();
		
		
		int jumlah;
		while (true) {
			if (input.hasNextInt()) {
				jumlah = input.nextInt();
				if (jumlah <= 0 ) {
					System.out.print("Jumlah dadu harus lebih dari 0. ");
				} else if (jumlah > 6){
					System.out.print("Jumlah dadu harus kurang dari atau sama dengan 6. ");
				}else {
					break;
				}
			} else {
				System.out.print("Input harus berupa angka. ");
				input.next();
			}
		}
		for (int i = 0; i < jumlah; i++) {
			Dadu d = new Dadu();
			daftarDadu.add(d);
		}
		
		int total = 0;
		for (int i = 0; i < daftarDadu.size(); i++) {
			int nilai = daftarDadu.get(i).getNilai();
			System.out.println("Dadu ke-" + (i+1) + " bernilai " + nilai);
			total += nilai;
		}
		
		System.out.println("Total nilai dadu keseluruhan " + total);
		input.close();

	}

}
