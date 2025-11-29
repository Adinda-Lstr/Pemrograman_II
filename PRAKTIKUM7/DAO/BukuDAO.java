package application.PRAKTIKUM7.DAO;

import application.PRAKTIKUM7.Model.Buku;
import java.util.List;

public interface BukuDAO {
	void addBuku(Buku buku) throws Exception;
	void editBuku(Buku buku) throws Exception;
	void deleteBuku(Buku buku) throws Exception;
	List<Buku> findAllBuku() throws Exception;
	Buku findBukuById(int id) throws Exception;
	
}
