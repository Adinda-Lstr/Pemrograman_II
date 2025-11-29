package application.PRAKTIKUM7.DAO;

import application.PRAKTIKUM7.Model.Penjualan;
import java.util.List;

public interface PenjualanDAO {
	void addPenjualan(Penjualan penjualan) throws Exception;
	void editPenjualan(Penjualan penjualan) throws Exception;
	void deletePenjualan(int bukuId) throws Exception;
	List<Penjualan> findAllPenjualan() throws Exception;
	Penjualan findPenjualanById(int id) throws Exception;
	void deleteByPelangganId(int PelangganId) throws Exception;
	void deleteByBukuId(int id) throws Exception;

}
