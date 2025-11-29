package application.PRAKTIKUM7.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;

import java.time.LocalDate;

public class Penjualan {
	private IntegerProperty penjualan_id;
	private IntegerProperty jumlah;
	private DoubleProperty totalHarga;
	private ObjectProperty<LocalDate> tanggal;
	private IntegerProperty pelanggan_id;
	private IntegerProperty buku_id;
	
	
	public Penjualan(int penjualan_id, int jumlah, Double totalHarga, LocalDate tanggal,int pelanggan_id, int buku_id) {
		this.penjualan_id = new SimpleIntegerProperty(penjualan_id);
		this.jumlah = new SimpleIntegerProperty(jumlah);
		this.totalHarga = new SimpleDoubleProperty(totalHarga);
		this.tanggal = new SimpleObjectProperty(tanggal);
		this.pelanggan_id = new SimpleIntegerProperty(pelanggan_id);
		this.buku_id = new SimpleIntegerProperty(buku_id);
	}
	
	public Penjualan(int jumlah, double totalHarga, LocalDate tanggal, int pelanggan_id, int buku_id) {
		this(0, jumlah, totalHarga, tanggal, pelanggan_id, buku_id);
	}
	
	public IntegerProperty penjualan_idProperty() {
		return penjualan_id;
	}
	public IntegerProperty jumlahProperty() {
		return jumlah;
	}
	public DoubleProperty totalHargaProperty() {
		return totalHarga;
	}
	public ObjectProperty<LocalDate> tanggalProperty(){
		return tanggal;
	}
	public IntegerProperty pelanggan_idProperty() {
		return pelanggan_id;
	}
	public IntegerProperty buku_idProperty() {
		return buku_id;
	}
	
	public int getPenjualan_id() {
		return penjualan_id.get();
    }
	public int getJumlah() {
		return jumlah.get();
	}
	public Double getTotalHarga() {
		return totalHarga.get();
	}
	public LocalDate getTanggal() {
		return tanggal.get();
	}
	public int getPelanggan_id() {
		return pelanggan_id.get();
	}
	public int getBuku_id() {
		return buku_id.get();
	}
	
	public void setPenjualan_id(int penjualan_id) {
		this.penjualan_id.set(penjualan_id);
	}
	public void setJumlah(int jumlah) {
		this.jumlah.set(jumlah);
	}
	public void setTotalHarga(Double totalHarga) {
		this.totalHarga.set(totalHarga);
	}
	public void setTanggal(LocalDate tanggal) {
		this.tanggal.set(tanggal);
	}
	public void setPelanggan_id(int pelanggan_id) {
		this.pelanggan_id.set(pelanggan_id);
	}
	public void setBuku_id(int buku_id) {
		this.buku_id.set(buku_id);
	}
}
