package praktikum2.soal1;

class Buah {
    private String nama;
    private double beratBuah;  
    private double hargaBuah;   
    private double jumlahBeli;
    
    
    public Buah(String nama, double beratBuah, double hargaBuah, double jumlahBeli) {
        this.nama = nama;
        this.beratBuah = beratBuah;
        this.hargaBuah = hargaBuah;
        this.jumlahBeli = jumlahBeli;
    }
 
    public double hitungHargaSebelumDiskon() {
        double banyakBuah = jumlahBeli / beratBuah; 
        return banyakBuah * hargaBuah;
    }
    
    public double hitungDiskon() {
        int discPerWeight = (int)(jumlahBeli / 4); 
        return discPerWeight * (4 * hargaBuah) * 0.02;
    }

    public double hitungHargaSetelahDiskon() {
        return hitungHargaSebelumDiskon() - hitungDiskon();
    }

    public void tampilkanInfo() {
        System.out.println("Nama Buah: " + nama);
        System.out.println("Berat: " + beratBuah);
        System.out.println("Harga: " + hargaBuah);
        System.out.println("Jumlah Beli: " + jumlahBeli + "kg");
        System.out.printf("Harga Sebelum Diskon: Rp%.2f%n", hitungHargaSebelumDiskon());
        System.out.printf("Total Diskon: Rp%.2f%n", hitungDiskon());
        System.out.printf("Harga Setelah Diskon: Rp%.2f%n", hitungHargaSetelahDiskon());
        System.out.println();
    }
}


public class Soal1 {

	public static void main(String[] args) {
		Buah apel    = new Buah("Apel",   0.4,  7000, 40.0);
        Buah mangga  = new Buah("Mangga", 0.2,  3500, 15.0);
        Buah alpukat = new Buah("Alpukat",0.25,10000, 12.0);

        apel.tampilkanInfo();
        mangga.tampilkanInfo();
        alpukat.tampilkanInfo();

	}

}
