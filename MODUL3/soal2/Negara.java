package soal2;

public class Negara {
	private String Nama;
	private String jenisKepemimpinan;
	private  String namaPemimpin;
	private int tanggalKemerdekaan;
	private int bulanKemerdekaan;
	private int tahunKemerdekaan;
	
	public Negara(String nama, String jenisKepemimpinan, String namaPemimpin) {
		this.Nama = nama;
		this.jenisKepemimpinan = jenisKepemimpinan;
		this.namaPemimpin = namaPemimpin;
	}
	
	public Negara(String nama, String jenisKepemimpinan, String namaPemimpin, int tanggal, int bulan, int tahun) {
		this.Nama = nama;
		this.jenisKepemimpinan = jenisKepemimpinan;
		this.namaPemimpin = namaPemimpin;
		this.tanggalKemerdekaan = tanggal;
		this.bulanKemerdekaan = bulan;
		this.tahunKemerdekaan = tahun;
	}
	
	public String getNama() {
		return Nama;
	}
	
	public String getJenisKepemimpinan() {
		return jenisKepemimpinan;
	}
	
	public String getNamaPemimpin() {
		return namaPemimpin;
	}
	
	public int getTanggalKemerdekaan() {
		return tanggalKemerdekaan;
	}
	
	public int getBulanKemerdekaan() {
		return bulanKemerdekaan;
	}
	
	public int getTahunKemerdekaan() {
		return tahunKemerdekaan;
	}

}
