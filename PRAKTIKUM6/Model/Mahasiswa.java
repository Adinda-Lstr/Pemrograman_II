package application.PRAKTIKUM6.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Mahasiswa {
	
	private final SimpleIntegerProperty id;
	private final SimpleStringProperty nama;
	private final SimpleStringProperty nim;
	
	public Mahasiswa(int id, String nama, String nim) {
		this.id = new SimpleIntegerProperty(id);
		this.nama = new SimpleStringProperty(nama);
		this.nim = new SimpleStringProperty(nim);
	}
	
	public int getId() {
		return id.get();
	}
	public String getNama() {
		return nama.get();
	}
	public String getNim() {
		return nim.get();
	}
	
	public void setId(int id) {
		this.id.set(id);
	}
	public void setNama(String nama) {
		this.nama.set(nama);
	}
	public void setNim(String nim) {
		this.nim.set(nim);
	}
	
	public SimpleIntegerProperty idProperty() {
		return id;
	}
	public SimpleStringProperty namaProperty() {
		return nama;
	}
	public SimpleStringProperty nimProperty() {
		return nim;
	}
}
