package application.PRAKTIKUM7.Service;

import java.time.LocalDate;
import java.util.List;
import application.PRAKTIKUM7.DAO.PenjualanDAO;
import application.PRAKTIKUM7.DAO.Impl.PenjualanDAOImpl;
import application.PRAKTIKUM7.Model.Penjualan;
import application.PRAKTIKUM7.DAO.BukuDAO;
import application.PRAKTIKUM7.Service.BukuService;
import application.PRAKTIKUM7.Model.Buku;

public class PenjualanService {
	private final PenjualanDAO penjualanDao;
	private final BukuService bukuService;
	
	public PenjualanService(PenjualanDAO penjualanDao, BukuService bukuService) {
		this.penjualanDao = penjualanDao;
		this.bukuService = bukuService;
	}
	
	public List<Penjualan> getAllPenjualan() throws Exception {
		return penjualanDao.findAllPenjualan();
	}
	
	public void addPenjualan(Penjualan penjualan) throws Exception {
		validasiData(penjualan);
		
		int buku_id = penjualan.getBuku_id();
		int jumlahBeli = penjualan.getJumlah();
		
		Buku bukuStok = bukuService.findBukuById(buku_id);
		
		if (bukuStok == null) {
			throw new Exception("Buku dengan ID" + buku_id + " tidak ditemukan");
		}
		if (bukuStok.getStok() < jumlahBeli) {
			throw new Exception("Gagal: Stok buku tidak mencukupi! Tersedia: " + bukuStok.getStok());
		}
		
		int stokBaru = bukuStok.getStok() - jumlahBeli;
		double totalHarga = jumlahBeli * bukuStok.getHarga().doubleValue();
		penjualan.setTotalHarga(totalHarga);
		
		bukuStok.setStok(stokBaru);
		bukuService.editBuku(bukuStok);
		penjualanDao.addPenjualan(penjualan);
	}
	
	public void editPenjualan(Penjualan penjualan) throws Exception {
	    if (penjualan.getPenjualan_id() <= 0) {
	        throw new Exception("Gagal Edit: ID Penjualan tidak valid.");
	    }
	    validasiData(penjualan);
	    
	    Penjualan penjualanLama = penjualanDao.findPenjualanById(penjualan.getPenjualan_id());
	    if (penjualanLama == null) {
	    	throw new Exception("Data Penjualan lama tidak ditemukan.");
	    }
	    
	    int perbedaanJumlah = penjualan.getJumlah() - penjualanLama.getJumlah();
	    
	    Buku bukuStok = bukuService.findBukuById(penjualan.getBuku_id());
	    if (bukuStok == null) {
	    	throw new Exception("Buku tidak ditemukan.");
	    }
	    
	    if (perbedaanJumlah > 0 && bukuStok.getStok() < perbedaanJumlah) {
	    	throw new Exception("Gagal Mengedit: Stok tidak mencukupi untuk menambah " + perbedaanJumlah +" unit.");
	    }
	    
	    int stokBaru = bukuStok.getStok() - perbedaanJumlah;
	    
	    if (stokBaru < 0 ) {
	    	throw new Exception("Gagal Mengedit: Stok buku tidak boleh kurang dari nol.");
	    }
	    
	    double totalHargaBaru =  penjualan.getJumlah() * bukuStok.getHarga().doubleValue();
	    
	    bukuStok.setStok(stokBaru);
	    bukuService.editBuku(bukuStok);
	    
	    penjualan.setTotalHarga(totalHargaBaru);
	    penjualanDao.editPenjualan(penjualan);
	}
	
	public void deleteByBukuId(int bukuId) throws Exception {
		penjualanDao.deleteByBukuId(bukuId);
	}
	
	public void deletePenjualan(int id) throws Exception {
		if (id <= 0) {
			throw new Exception("Gagal Menghapus: ID tdak valid!.");
		}
		
		Penjualan penjualanDihapus = penjualanDao.findPenjualanById(id);
        if (penjualanDihapus == null) {
            throw new Exception("Data Penjualan tidak ditemukan.");
        }
        
        int bukuId = penjualanDihapus.getBuku_id();
        int jumlahDikembalikan = penjualanDihapus.getJumlah();
        
        Buku bukuStok = bukuService.findBukuById(bukuId);
        
        if (bukuStok != null) {
        	int stokBaru = bukuStok.getStok() + jumlahDikembalikan;
        	bukuStok.setStok(stokBaru);
            bukuService.editBuku(bukuStok);
        }
        
		penjualanDao.deletePenjualan(id);
	}
	
	public void validasiData(Penjualan penjualan) throws Exception {
		if (penjualan.getJumlah() <= 0) {
			throw new Exception("Jumlah penjualan harus lebih dari nol!.");
		}
		if (penjualan.getTotalHarga() < 0) {
			throw new Exception("Total harga tidak boleh negatif!");
		}
		if (penjualan.getTanggal() == null) {
			throw new Exception("Tanggal penjualan wajib diisi!");
		}
		if (penjualan.getTanggal().isAfter(LocalDate.now())) {
			throw new Exception("Tanggal penjualan tidak boleh di masa depan!");
		}
		
		if (penjualan.getPelanggan_id() <= 0) {
			throw new Exception("Pelanggan ID harus dipilih!");
		}
		if (penjualan.getBuku_id() <= 0 ) {
			throw new Exception("Buku ID harus dipilih!");
		}
	}

}
