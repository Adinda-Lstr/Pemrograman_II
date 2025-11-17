package application.PRAKTIKUM6.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import application.PRAKTIKUM6.Model.Mahasiswa;

public class MahasiswaViewController implements Initializable {
	
	@FXML
	private TableView<application.PRAKTIKUM6.Model.Mahasiswa> tableView;
	@FXML
	private TableColumn<Mahasiswa, String> nimCol;
	@FXML
	private TableColumn<Mahasiswa, String> namaCol;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		nimCol.setCellValueFactory(new PropertyValueFactory<>("nim"));
        namaCol.setCellValueFactory(new PropertyValueFactory<>("nama"));
        
        tableView.setItems(getMahasiswaList());
	}
	
	private ObservableList<Mahasiswa> getMahasiswaList() {
        ObservableList<Mahasiswa> data = FXCollections.observableArrayList(
                new Mahasiswa(1, "Jhon", "211001001"),
                new Mahasiswa(2, "Jhane", "211001002"),
                new Mahasiswa(3, "Jono", "211001003"),
                new Mahasiswa(4, "Agus", "211001004"),
                new Mahasiswa(5, "Luthfi", "211001005"),
                new Mahasiswa(6, "Tata", "211001006"),
                new Mahasiswa(7, "Amel", "211001007"),
                new Mahasiswa(8, "Dhea", "211001008"),
                new Mahasiswa(9, "Lisa", "211001009"),
                new Mahasiswa(10, "Dinda", "211001010")
        );
        return data;
	}
}
