package Soal1;
import java.util.Scanner;
public class HewanPeliharaan {
	private String nama;
	private String ras;
	
	public HewanPeliharaan(String n, String r) {
		this.nama = n;
		this.ras = r;
	}
	 public String getNama() {
	        return nama;
	}

	    public void setNama(String nama) {
	        this.nama = nama;
	}

	    public String getRas() {
	        return ras;
    }

	    public void setRas(String ras) {
	        this.ras = ras;
	}
	
	public static HewanPeliharaan inputData() {
		Scanner input = new Scanner(System.in);
		System.out.print("Nama Hewan Peliharaan: ");
		String nama = input.nextLine();
		System.out.print("Ras: ");
		String ras = input.nextLine();
		return new HewanPeliharaan(nama, ras);
	}
	
	public void display() {
		System.out.println("\nDetail Hewan Peliharaan: ");
		System.out.println("Nama hewan peliharaanku adalah: " + nama);
		System.out.println("Dengan ras: " + ras);
	}

}