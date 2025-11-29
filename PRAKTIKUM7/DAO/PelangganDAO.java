package application.PRAKTIKUM7.DAO;

import application.PRAKTIKUM7.Model.Pelanggan;
import java.util.List;

public interface PelangganDAO {
	void addPelanggan(Pelanggan pelanggan) throws Exception;
	void editPelanggan(Pelanggan pelanggan) throws Exception;
	void deletePelanggan(int id) throws Exception;
	List<Pelanggan> findAllPelanggan() throws Exception;
	Pelanggan findPelangganById(int id) throws Exception;

}
