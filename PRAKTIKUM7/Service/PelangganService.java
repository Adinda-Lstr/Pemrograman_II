package application.PRAKTIKUM7.Service;

import java.util.List;
import application.PRAKTIKUM7.Model.Pelanggan;
import application.PRAKTIKUM7.DAO.PelangganDAO;
import application.PRAKTIKUM7.DAO.PenjualanDAO;
import application.PRAKTIKUM7.DAO.Impl.PelangganDAOImpl;

public class PelangganService {
	private final PelangganDAO pelangganDao;
	private final PenjualanDAO penjualanDao;
	
	public PelangganService(PelangganDAO pelangganDao, PenjualanDAO penjualanDao) {
		this.pelangganDao = pelangganDao;
		this.penjualanDao = penjualanDao;
	}
	
	public List<Pelanggan> getAllPelanggan() throws Exception {
		return pelangganDao.findAllPelanggan();
	}
	
	public void addPelanggan(Pelanggan pelanggan) throws Exception {
		validasiData(pelanggan);
		pelangganDao.addPelanggan(pelanggan);
	}
	
	public void editPelanggan(Pelanggan pelanggan) throws Exception {
		if (pelanggan.getPelanggan_id() <= 0) {
			throw new Exception("Gagal Mengedit: ID tidak valid!.");
		}
		validasiData(pelanggan);
		pelangganDao.editPelanggan(pelanggan);
	}
	
	public void deletePelanggan(int id) throws Exception {
		if (id <= 0) {
			throw new Exception("Gagal Menghapus: ID tidak valid.");
		}
		penjualanDao.deleteByPelangganId(id);
		pelangganDao.deletePelanggan(id);
	}
	
	private void validasiData(Pelanggan pelanggan) throws Exception {
		if (pelanggan.getNama() == null || pelanggan.getNama().trim().isEmpty()) {
			throw new Exception("Nama pelanggan harus diisi!");
		}
		if (pelanggan.getEmail() == null || pelanggan.getEmail().trim().isEmpty()) {
			throw new Exception("Email harus diisi!");
		}
		if (!pelanggan.getEmail().contains("@")) {
			throw new Exception("Format email harus menggunakan @.");
		}
		
		if (pelanggan.getTelepon() == null || pelanggan.getTelepon().trim().isEmpty()) {
			throw new Exception("Nomor telepon harus diisi!");
		}
		if (!pelanggan.getTelepon().matches("\\d+")) {
			throw new Exception("Nomor telepon harus berupa angka, tanpa spasi atau karakter lain.");
		}
		
	}

}
