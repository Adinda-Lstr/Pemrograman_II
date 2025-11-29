package application.PRAKTIKUM7.Service;

import java.util.List;
import application.PRAKTIKUM7.DAO.BukuDAO;
import application.PRAKTIKUM7.DAO.Impl.BukuDAOImpl;
import application.PRAKTIKUM7.Model.Buku;


public class BukuService {
	
	private final BukuDAO bukuDao;
	
	
	public BukuService(BukuDAO bukuDao) {
		this.bukuDao = bukuDao;
	}
	
	public List<Buku> getAllBuku() throws Exception {
		return bukuDao.findAllBuku();
	}
	
	public void addBuku(Buku buku) throws Exception {
		validasiData(buku);
		bukuDao.addBuku(buku);
	}
	
	public Buku findBukuById(int id) throws Exception {
        return bukuDao.findBukuById(id); 
    }
	
	public void editBuku(Buku buku) throws Exception {
		if (buku.getBuku_id() <= 0) {
			throw new Exception("Gagal Mengedit: ID tidak valid!");
		}
		validasiData(buku);
		bukuDao.editBuku(buku);
	}
	
	public void deleteBuku(Buku buku) throws Exception {
		if (buku == null || buku.getBuku_id() <= 0) {
			throw new Exception("Gagal Mengahpus: ID tidak valid!");
		}
	
		bukuDao.deleteBuku(buku);
	}
	
	private void validasiData(Buku buku) throws Exception {
		if (buku.getJudul() == null || buku.getJudul().trim().isEmpty()) {
			throw  new Exception("Judul Buku harus diisi!");
		}
		if (buku.getPenulis() == null || buku.getPenulis().trim().isEmpty()) {
			throw new Exception("Penulis harus diisi!");
		}
		
		if (buku.getHarga() < 0) {
			throw new Exception("Harga buku tidak boleh negatif!");
		}
		if (buku.getHarga() == 0) {
			throw new Exception("Harga buku tidak boleh nol (0).");
		}
		if (buku.getStok() < 0) {
			throw new Exception("Stok buku tidak boleh negatif!");
		}
	}

}
