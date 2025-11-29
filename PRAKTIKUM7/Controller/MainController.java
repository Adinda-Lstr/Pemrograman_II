package application.PRAKTIKUM7.Controller;

import application.PRAKTIKUM7.Model.*;
import application.PRAKTIKUM7.Service.*;
import application.PRAKTIKUM7.DAO.Impl.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.List;
import java.sql.SQLException;

public class MainController {
	
    //Service injection
	
	private final PelangganDAOImpl pelangganDAOImpl = new PelangganDAOImpl(); 
	private final BukuDAOImpl bukuDAOImpl = new BukuDAOImpl();
	private final PenjualanDAOImpl penjualanDAOImpl = new PenjualanDAOImpl(); 
	private final PelangganService pelangganService = new PelangganService(pelangganDAOImpl, penjualanDAOImpl); 

	private final BukuService bukuService = new BukuService(bukuDAOImpl); 
	private final PenjualanService penjualanService = new PenjualanService(penjualanDAOImpl, bukuService);
    
    // Data list & deklarasi fxml
    
    // Data list untuk TableView
    private ObservableList<Pelanggan> dataPelanggan = FXCollections.observableArrayList();
    private ObservableList<Buku> dataBuku = FXCollections.observableArrayList();
    private ObservableList<Penjualan> dataPenjualan = FXCollections.observableArrayList();
    
    // FXML DEKLARASI PELANGGAN 
    @FXML private TextField txtNamaPelanggan;
    @FXML private TextField txtEmailPelanggan;
    @FXML private TextField txtTeleponPelanggan;
    @FXML private TableView<Pelanggan> tblPelanggan;
    @FXML private TableColumn<Pelanggan, String> colNamaPelanggan;
    @FXML private TableColumn<Pelanggan, String> colEmailPelanggan;
    @FXML private TableColumn<Pelanggan, String> colTeleponPelanggan;
    
    // FXML DEKLARASI BUKU 
    @FXML private TextField txtJudulBuku;
    @FXML private TextField txtPenulisBuku;
    @FXML private TextField txtHargaBuku;
    @FXML private TextField txtStokBuku; 
    @FXML private TableView<Buku> tblBuku;
    @FXML private TableColumn<Buku, String> colJudulBuku;
    @FXML private TableColumn<Buku, String> colPenulisBuku;
    @FXML private TableColumn<Buku, Double> colHargaBuku;
    @FXML private TableColumn<Buku, Integer> colStokBuku;
    
    // FXML DEKLARASI PENJUALAN 
    @FXML private TextField txtIdPelangganPenjualan;
    @FXML private TextField txtIdBukuPenjualan;
    @FXML private TextField txtJumlahPenjualan;
    @FXML private DatePicker dpTanggalPenjualan;
    @FXML private TableView<Penjualan> tblPenjualan;
    @FXML private TableColumn<Penjualan, Integer> colIdPelangganPenjualan;
    @FXML private TableColumn<Penjualan, Integer> colIdBukuPenjualan;
    @FXML private TableColumn<Penjualan, Integer> colJumlahPenjualan;
    @FXML private TableColumn<Penjualan, Double> colTotalHargaPenjualan;
    @FXML private TableColumn<Penjualan, LocalDate> colTanggalPenjualan;
    
    
    
    // INITIALIZE METHOD & SETUP TABLE BINDING
    @FXML
    public void initialize() {
    	
    	// Setup Kolom Pelanggan
    	colNamaPelanggan.setCellValueFactory(cellData -> cellData.getValue().namaProperty());
    	colEmailPelanggan.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
    	colTeleponPelanggan.setCellValueFactory(cellData -> cellData.getValue().teleponProperty());
    	
    	// Setup Kolom Buku
    	colJudulBuku.setCellValueFactory(cellData -> cellData.getValue().judulProperty());
    	colPenulisBuku.setCellValueFactory(cellData -> cellData.getValue().penulisProperty());
    	colHargaBuku.setCellValueFactory(cellData -> cellData.getValue().hargaProperty().asObject());
    	colStokBuku.setCellValueFactory(cellData -> cellData.getValue().stokProperty().asObject());
    	
    	// Setup Kolom Penjualan 
    	colIdPelangganPenjualan.setCellValueFactory(cellData -> cellData.getValue().pelanggan_idProperty().asObject());
    	colIdBukuPenjualan.setCellValueFactory(cellData -> cellData.getValue().buku_idProperty().asObject());
    	colJumlahPenjualan.setCellValueFactory(cellData -> cellData.getValue().jumlahProperty().asObject());
    	colTotalHargaPenjualan.setCellValueFactory(cellData -> cellData.getValue().totalHargaProperty().asObject());
    	colTanggalPenjualan.setCellValueFactory(cellData -> cellData.getValue().tanggalProperty());
        
        loadAllData();
        setupTableListeners(); 
    }
    

    // HELPER METHODS (LOAD DATA, VALIDASI, VIEW)
    private void loadAllData() {
        try {
            dataPelanggan.setAll(pelangganService.getAllPelanggan());
            tblPelanggan.setItems(dataPelanggan);
            
            dataBuku.setAll(bukuService.getAllBuku());
            tblBuku.setItems(dataBuku);
            
            dataPenjualan.setAll(penjualanService.getAllPenjualan());
            tblPenjualan.setItems(dataPenjualan);
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error Database", "Gagal memuat data: " + e.getMessage());
        }
    }
    
    private void setupTableListeners() {
        tblPelanggan.getSelectionModel().selectedItemProperty().addListener(
            (obs, oldSelection, newSelection) -> showPelangganDetails(newSelection));
        
        
        tblBuku.getSelectionModel().selectedItemProperty().addListener(
            (obs, oldSelection, newSelection) -> showBukuDetails(newSelection));
        
        tblPenjualan.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> showPenjualanDetails(newSelection));
    }

    private double hitungTotalHarga(int bukuId, int jumlah) throws Exception {
        
        Buku buku = bukuService.findBukuById(bukuId); 
        
        if (buku == null) {
            throw new Exception("Buku dengan ID " + bukuId + " tidak ditemukan.");
        }
        
        return jumlah * buku.getHarga().doubleValue(); 
    }
    
    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    private void clearPelangganFields() {
        txtNamaPelanggan.setText("");
        txtEmailPelanggan.setText("");
        txtTeleponPelanggan.setText("");
    }
    
    private void showPelangganDetails(Pelanggan pelanggan) {
        if (pelanggan != null) {
            txtNamaPelanggan.setText(pelanggan.getNama());
            txtEmailPelanggan.setText(pelanggan.getEmail());
            txtTeleponPelanggan.setText(String.valueOf(pelanggan.getTelepon()));
        } else {
            clearPelangganFields();
        }
    }
    
    private void clearBukuFields() {
        txtJudulBuku.setText("");
        txtPenulisBuku.setText("");
        txtHargaBuku.setText("");
        txtStokBuku.setText("");
    }

    private void showBukuDetails(Buku buku) {
        if (buku != null) {
            txtJudulBuku.setText(buku.getJudul());
            txtPenulisBuku.setText(buku.getPenulis());
            txtHargaBuku.setText(String.valueOf(buku.getHarga()));
            txtStokBuku.setText(String.valueOf(buku.getStok()));
        } else {
            clearBukuFields();
        }
    }
    
    private void showPenjualanDetails(Penjualan penjualan) {
        if (penjualan != null) {
            txtIdPelangganPenjualan.setText(String.valueOf(penjualan.getPelanggan_id()));
            txtIdBukuPenjualan.setText(String.valueOf(penjualan.getBuku_id()));
            txtJumlahPenjualan.setText(String.valueOf(penjualan.getJumlah()));
            dpTanggalPenjualan.setValue(penjualan.getTanggal());
        } else {
            clearPenjualanFields();
        }
    }
    
    private void clearPenjualanFields() {
        txtIdPelangganPenjualan.setText("");
        txtIdBukuPenjualan.setText("");
        txtJumlahPenjualan.setText("");
        dpTanggalPenjualan.setValue(null);
    }
    


    
    // HANDLER CRUD (PELANGGAN)
    @FXML
    private void onAddPelanggan() {
        try {
            String nama = txtNamaPelanggan.getText();
            String email = txtEmailPelanggan.getText();
            String telepon = txtTeleponPelanggan.getText();

            Pelanggan newPelanggan = new Pelanggan(nama, email, telepon);
            pelangganService.addPelanggan(newPelanggan);
            
            dataPelanggan.add(newPelanggan);
            clearPelangganFields();
            showAlert(Alert.AlertType.INFORMATION, "Sukses", "Data Pelanggan berhasil ditambahkan.");

        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.WARNING, "Input Invalid", "Umur harus berupa angka.");
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Validasi/Database Error", e.getMessage());
        }
    }
    
    @FXML
    private void onEditPelanggan() {
        Pelanggan selected = tblPelanggan.getSelectionModel().getSelectedItem();
        if (selected != null) {
            try {
                selected.setNama(txtNamaPelanggan.getText());
                selected.setEmail(txtEmailPelanggan.getText());
                selected.setTelepon(txtTeleponPelanggan.getText());
                
                pelangganService.editPelanggan(selected);
                tblPelanggan.refresh();
                showAlert(Alert.AlertType.INFORMATION, "Sukses", "Data Pelanggan berhasil diubah.");
            } catch (Exception e) {
                 showAlert(Alert.AlertType.ERROR, "Validasi/Database Error", e.getMessage());
            }
        } else {
            showAlert(Alert.AlertType.WARNING, "Pilih Data", "Pilih data di tabel untuk diedit.");
        }
    }
    
    @FXML
    private void onDeletePelanggan() {
        Pelanggan selected = tblPelanggan.getSelectionModel().getSelectedItem();
        if (selected != null) {
            try {
                pelangganService.deletePelanggan(selected.getPelanggan_id());
                dataPelanggan.remove(selected);
                showAlert(Alert.AlertType.INFORMATION, "Sukses", "Data Pelanggan berhasil dihapus.");
            } catch (Exception e) {
                showAlert(Alert.AlertType.ERROR, "Database Error", e.getMessage());
            }
        } else {
            showAlert(Alert.AlertType.WARNING, "Pilih Data", "Pilih data di tabel untuk dihapus.");
        }
    }

    
    // HANDLER CRUD (BUKU)
    @FXML
    private void onAddBuku() {
        try {
            String judul = txtJudulBuku.getText();
            String penulis = txtPenulisBuku.getText();
            double harga = Double.parseDouble(txtHargaBuku.getText());
            int stok = Integer.parseInt(txtStokBuku.getText()); 

            Buku newBuku = new Buku(judul, penulis, harga, stok);
            bukuService.addBuku(newBuku);

            dataBuku.add(newBuku);
            clearBukuFields();
            showAlert(Alert.AlertType.INFORMATION, "Sukses", "Data Buku berhasil ditambahkan.");

        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.WARNING, "Input Invalid", "Harga dan Stok harus berupa angka.");
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Validasi/Database Error", e.getMessage());
        }
    }

    @FXML
    private void onEditBuku() {
        Buku selected = tblBuku.getSelectionModel().getSelectedItem();
        if (selected != null) {
            try {
                selected.setJudul(txtJudulBuku.getText());
                selected.setPenulis(txtPenulisBuku.getText());
                selected.setHarga(Double.parseDouble(txtHargaBuku.getText()));
                selected.setStok(Integer.parseInt(txtStokBuku.getText())); 

                bukuService.editBuku(selected);
                tblBuku.refresh();
                showAlert(Alert.AlertType.INFORMATION, "Sukses", "Data Buku berhasil diubah.");
            } catch (Exception e) {
                 showAlert(Alert.AlertType.ERROR, "Validasi/Database Error", e.getMessage());
            }
        } else {
            showAlert(Alert.AlertType.WARNING, "Pilih Data", "Pilih data buku di tabel untuk diedit.");
        }
    }

    @FXML
    private void onDeleteBuku() {
        Buku selected = tblBuku.getSelectionModel().getSelectedItem();
        if (selected != null) {
            try {
                int bukuId = selected.getBuku_id();
               
                penjualanService.deleteByBukuId(bukuId);
                bukuService.deleteBuku(selected);
                dataBuku.remove(selected);
                showAlert(Alert.AlertType.INFORMATION, "Sukses", "Data Buku berhasil dihapus.");
            } catch (Exception e) {
                showAlert(Alert.AlertType.ERROR, "Database Error", e.getMessage());
            }
        } else {
            showAlert(Alert.AlertType.WARNING, "Pilih Data", "Pilih data buku di tabel untuk dihapus.");
        }
    }
    
    
    // HANDLER CRUD (PENJUALAN)
    @FXML
    private void onAddPenjualan() {
        try {
            int pelangganId = Integer.parseInt(txtIdPelangganPenjualan.getText());
            int bukuId = Integer.parseInt(txtIdBukuPenjualan.getText());
            int jumlah = Integer.parseInt(txtJumlahPenjualan.getText());
            LocalDate tanggal = dpTanggalPenjualan.getValue();
            

            Penjualan newPenjualan = new Penjualan(jumlah, 0.0, tanggal, pelangganId, bukuId);
            penjualanService.addPenjualan(newPenjualan);
            loadAllData();

            clearPenjualanFields();
            showAlert(Alert.AlertType.INFORMATION, "Sukses", "Transaksi Penjualan berhasil dicatat.");

        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.WARNING, "Input Invalid", "ID Pelanggan, ID Buku, dan Jumlah harus berupa angka.");
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Validasi/Database Error", e.getMessage());
        }
    }

    @FXML
    private void onEditPenjualan() {
        Penjualan selected = tblPenjualan.getSelectionModel().getSelectedItem();
        if (selected != null) {
            try {
                int newPelangganId = Integer.parseInt(txtIdPelangganPenjualan.getText());
                int newBukuId = Integer.parseInt(txtIdBukuPenjualan.getText());
                int newJumlah = Integer.parseInt(txtJumlahPenjualan.getText());
                LocalDate newTanggal = dpTanggalPenjualan.getValue();
                
                selected.setPelanggan_id(newPelangganId);
                selected.setBuku_id(newBukuId);
                selected.setJumlah(newJumlah);
                selected.setTanggal(newTanggal);

                penjualanService.editPenjualan(selected);
                loadAllData();
                showAlert(Alert.AlertType.INFORMATION, "Sukses", "Data Penjualan berhasil diubah.");

            } catch (Exception e) {
                 showAlert(Alert.AlertType.ERROR, "Validasi/Database Error", e.getMessage());
            }
        } else {
            showAlert(Alert.AlertType.WARNING, "Pilih Data", "Pilih data penjualan di tabel untuk diedit.");
        }
    }

    @FXML
    private void onDeletePenjualan() {
        Penjualan selected = tblPenjualan.getSelectionModel().getSelectedItem();
        if (selected != null) {
            try {
                penjualanService.deletePenjualan(selected.getPenjualan_id()); 
                loadAllData();
                showAlert(Alert.AlertType.INFORMATION, "Sukses", "Data Penjualan berhasil dihapus.");
            } catch (Exception e) {
                showAlert(Alert.AlertType.ERROR, "Database Error", e.getMessage());
            }
        } else {
            showAlert(Alert.AlertType.WARNING, "Pilih Data", "Pilih data penjualan di tabel untuk dihapus.");
        }
    }
}