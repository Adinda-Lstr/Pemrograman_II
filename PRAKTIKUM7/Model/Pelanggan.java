package application.PRAKTIKUM7.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;

public class Pelanggan {
	private IntegerProperty pelanggan_id;
	private StringProperty nama;
	private StringProperty email;
	private StringProperty telepon;
	
	
	public Pelanggan(int id, String nama, String email, String telepon) {
		this.pelanggan_id = new SimpleIntegerProperty(id);
		this.nama = new SimpleStringProperty(nama);
		this.email = new SimpleStringProperty(email);
		this.telepon = new SimpleStringProperty(telepon);
	}
	
	public Pelanggan(String nama, String email, String telepon) {
		this(0, nama, email, telepon);
	}
	
	public IntegerProperty pelanggan_idProperty() {
		return pelanggan_id;
	}
	public StringProperty namaProperty() {
		return nama;
	}
	public StringProperty emailProperty() {
		return email;
	}
	public StringProperty teleponProperty() {
		return telepon;
	}
	
	public int getPelanggan_id() {
		return pelanggan_id.get();
	}
	public String getNama() {
		return nama.get();
	}
	public String getEmail() {
		return email.get();
	}
	public String getTelepon() {
		return telepon.get();
	}
	
	public void setPelanggan_id(int id) {
		this.pelanggan_id.set(id);
	}
	public void setNama(String nama) {
		this.nama.set(nama);
	}
	public void setEmail(String email) {
		this.email.set(email);
	}
	public void setTelepon(String telepon) {
		this.telepon.set(telepon);
	}

}
