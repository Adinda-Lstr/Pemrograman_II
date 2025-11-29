package application.PRAKTIKUM7.DAO.Impl;

import application.PRAKTIKUM7.DAO.BukuDAO;
import application.PRAKTIKUM7.Model.Buku;
import application.PRAKTIKUM7.Model.Pelanggan;
import application.PRAKTIKUM7.Util.Koneksi;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BukuDAOImpl implements BukuDAO {
	private static final String INSERT_SQL = "INSERT INTO Buku (judul, penulis, harga, stok) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_SQL = "SELECT buku_id, judul, penulis, harga, stok FROM Buku";
    private static final String UPDATE_SQL = "UPDATE Buku SET judul = ?, penulis = ?, harga = ?, stok = ? WHERE buku_id = ?";
    private static final String DELETE_SQL = "DELETE FROM Buku WHERE buku_id = ?";
    private static final String SELECT_BY_ID_SQL = "SELECT buku_id, judul, penulis, harga, stok FROM Buku WHERE buku_id = ?";
    
	@Override
	public void addBuku(Buku buku) throws SQLException {
		try (Connection conn = Koneksi.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
			pstmt.setString(1,  buku.getJudul());
			pstmt.setString(2,  buku.getPenulis());
			pstmt.setDouble(3, buku.getHarga());
			pstmt.setInt(4,  buku.getStok());
			
			int affectedRows = pstmt.executeUpdate();
			
			if (affectedRows > 0) {
				try (ResultSet generatedKeys = pstmt.getGeneratedKeys()){
					if (generatedKeys.next()) {
						buku.setBuku_id(generatedKeys.getInt(1));
					}
				}
			}
		}
	}
	
	@Override
	public List<Buku> findAllBuku() throws SQLException {
		List<Buku> list = new ArrayList<>();
		try (Connection conn = Koneksi.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(SELECT_ALL_SQL)) {
			
			while (rs.next()) {
				list.add(new Buku(
						rs.getInt("buku_id"),
						rs.getString("judul"),
						rs.getString("penulis"),
						rs.getDouble("harga"),
						rs.getInt("stok")
						));
			}
		}
		return list;
	}
	
@Override
public void editBuku(Buku buku) throws SQLException {
	try (Connection conn = Koneksi.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(UPDATE_SQL)){
		pstmt.setString(1,  buku.getJudul());
		pstmt.setString(2, buku.getPenulis());
		pstmt.setDouble(3,  buku.getHarga());
		pstmt.setInt(4,  buku.getStok());
		pstmt.setInt(5, buku.getBuku_id());
		pstmt.executeUpdate();
	}
}

@Override
public void deleteBuku(Buku buku) throws SQLException {
	try (Connection conn = Koneksi.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(DELETE_SQL)){
		pstmt.setInt(1,  buku.getBuku_id());
		pstmt.executeUpdate();
	}
}

@Override
public Buku findBukuById(int id) throws Exception {
    try (Connection conn = Koneksi.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID_SQL)) {
        
        pstmt.setInt(1, id);
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return new Buku(
                    rs.getInt("buku_id"),
                    rs.getString("judul"),
                    rs.getString("penulis"),
                    rs.getDouble("harga"),
                    rs.getInt("stok")
                );
            }
        }
    }
    return null;
}
}


