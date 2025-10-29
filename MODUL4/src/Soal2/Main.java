package Soal2;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Pilih jenis hewan yang ingin diinputkan:");
        System.out.println("1 = Kucing");
        System.out.println("2 = Anjing");
        System.out.print("Masukkan pilihan: ");
        int pilih = input.nextInt();
        input.nextLine();

        System.out.print("Nama hewan peliharaan: ");
        String nama = input.nextLine();
        System.out.print("Ras: ");
        String ras = input.nextLine();

        if (pilih == 1) {
            System.out.print("Warna bulu: ");
            String warna = input.nextLine();

            Kucing k = new Kucing(nama, ras, warna);
            k.displayDetailKucing();

        } else if (pilih == 2) {
            System.out.print("Warna bulu: ");
            String warna = input.nextLine();

            System.out.print("Masukkan kemampuan: ");
            String[] kemampuan = input.nextLine().split(",");

            Anjing a = new Anjing(nama, ras, warna, kemampuan);
            a.displayDetailAnjing();
        } else {
            System.out.println("Pilihan tidak valid.");
        }

        input.close();
	}

}
