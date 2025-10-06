package praktikum2.soal2;

public class Kopi {
	    String namaKopi;
	    String ukuran;
	    double harga;
	    private String pembeli;
	    
	    
	    public void info() {
	    	System.out.println("Nama Kopi: "+ namaKopi);
	    	System.out.println("Ukuran: "+ ukuran);
	    	System.out.println("Harga: "+ harga);
	    }
	    public void setPembeli(String pembeli) {
	    	this.pembeli = pembeli;
	    }
	    public String getPembeli() {
	    	return pembeli;
	    }
	    public double getPajak() {
	    	return harga * 0.11;

}
}
