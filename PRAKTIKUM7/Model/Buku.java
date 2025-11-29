package application.PRAKTIKUM7.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.DoubleProperty;

public class Buku {
	private IntegerProperty buku_id;
	private StringProperty judul;
	private StringProperty penulis;
	private DoubleProperty harga;
	private IntegerProperty stok;
	
	public Buku(int buku_id, String judul, String penulis, double harga, int stok) {
		this.buku_id = new SimpleIntegerProperty(buku_id);
		this.judul = new SimpleStringProperty(judul);
		this.penulis = new SimpleStringProperty(penulis);
		this.harga = new SimpleDoubleProperty(harga);
		this.stok = new SimpleIntegerProperty(stok);
	}
	
	public Buku(String judul, String penulis, double harga, int stok) {
		this(0, judul, penulis, harga, stok);
		
	}
	
	public IntegerProperty buku_idProperty() {
		return buku_id;
	}
	public StringProperty judulProperty() {
		return judul;
	}
	public StringProperty penulisProperty() {
		return penulis;
	}
	public DoubleProperty hargaProperty() {
		return harga;
	}
	public IntegerProperty stokProperty() {
		return stok;
	}
	
	public int getBuku_id() {
		return buku_id.get();
	}
	public String getJudul() {
		return judul.get();
	}
	public String getPenulis() {
		return penulis.get();
	}
	public Double getHarga() {
		return harga.get();
	}
	public int getStok() {
		return stok.get();
	}
	
	public void setBuku_id(int buku_id) {
		this.buku_id.set(buku_id);
	}
	public void setJudul(String judul) {
		this.judul.set(judul);
	}
	public void setPenulis(String penulis) {
		this.penulis.set(penulis);
	}
	public void setHarga(Double harga) {
		this.harga.set(harga);
	}
	public void setStok(int stok) {
		this.stok.set(stok);
	}
}


