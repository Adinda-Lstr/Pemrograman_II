package application.PRAKTIKUM7.DAO.Impl;

import application.PRAKTIKUM7.DAO.PenjualanDAO;
import application.PRAKTIKUM7.Model.Penjualan;
import application.PRAKTIKUM7.Util.Koneksi;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PenjualanDAOImpl implements PenjualanDAO {
	private static final String INSERT_SQL = "INSERT INTO Penjualan (jumlah, total_harga, tanggal, pelanggan_id, buku_id) VALUES (?, ?, ?, ?, ?)";
	private static final String SELECT_ALL_SQL = "SELECT penjualan_id, jumlah, total_harga, tanggal, pelanggan_id, buku_id FROM Penjualan";
	private static final String UPDATE_SQL = "UPDATE Penjualan SET jumlah = ?, total_harga = ?, tanggal = ?, pelanggan_id = ?, buku_id = ? WHERE penjualan_id = ?";
	private static final String DELETE_SQL = "DELETE FROM Penjualan WHERE penjualan_id = ?";
	private static final String SELECT_BY_ID_SQL = "SELECT penjualan_id, jumlah, total_harga, tanggal, pelanggan_id, buku_id FROM Penjualan WHERE penjualan_id = ?";
	private static final String DELETE_BY_BUKU_ID_SQL = "DELETE FROM Penjualan WHERE buku_id = ?";
	private static final String DELETE_BY_PELANGGAN_ID_SQL = "DELETE FROM Penjualan WHERE pelanggan_id = ?";
	    @Override
	    public void addPenjualan(Penjualan penjualan) throws SQLException {
	        try (Connection conn = Koneksi.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
	            
	            pstmt.setInt(1, penjualan.getJumlah());
	            pstmt.setDouble(2, penjualan.getTotalHarga());
	            pstmt.setDate(3, Date.valueOf(penjualan.getTanggal())); 
	            pstmt.setInt(4, penjualan.getPelanggan_id());
	            pstmt.setInt(5, penjualan.getBuku_id());
	            int affectedRows = pstmt.executeUpdate();
	            
	            if (affectedRows > 0) {
	                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
	                    if (generatedKeys.next()) {
	                        penjualan.setPenjualan_id(generatedKeys.getInt(1));
	                    }
	                }
	            }
	        }
	    }

	    @Override
	    public List<Penjualan> findAllPenjualan() throws SQLException {
	        List<Penjualan> list = new ArrayList<>();
	        try (Connection conn = Koneksi.getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(SELECT_ALL_SQL)) {
	            
	            while (rs.next()) {
	                list.add(new Penjualan(
	                    rs.getInt("penjualan_id"),
	                    rs.getInt("jumlah"),
	                    rs.getDouble("total_harga"),
	                    rs.getDate("tanggal").toLocalDate(), 
	                    rs.getInt("pelanggan_id"),
	                    rs.getInt("buku_id")
	                ));
	            }
	        }
	        return list;
	    }
	    
	    @Override
	    public void editPenjualan(Penjualan penjualan) throws SQLException {
	        try (Connection conn = Koneksi.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(UPDATE_SQL)) {
	            
	            pstmt.setInt(1, penjualan.getJumlah());
	            pstmt.setDouble(2, penjualan.getTotalHarga());
	            pstmt.setDate(3, Date.valueOf(penjualan.getTanggal()));
	            pstmt.setInt(4, penjualan.getPelanggan_id());
	            pstmt.setInt(5, penjualan.getBuku_id());
	            pstmt.setInt(6, penjualan.getPenjualan_id());
	            pstmt.executeUpdate();
	        }
	    }

	    @Override
	    public void deletePenjualan(int id) throws SQLException {
	        try (Connection conn = Koneksi.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(DELETE_SQL)) {
	            
	            pstmt.setInt(1, id);
	            pstmt.executeUpdate();
	        }
	    }
	   
	    
	    @Override
	    public void deleteByBukuId(int bukuId) throws SQLException {
	        try (Connection conn = Koneksi.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(DELETE_BY_BUKU_ID_SQL)) {
	            
	            pstmt.setInt(1, bukuId);
	            pstmt.executeUpdate();
	        }
	    }
	    @Override
		public void deleteByPelangganId(int PelangganId) throws Exception {
			try (Connection conn = Koneksi.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(DELETE_BY_PELANGGAN_ID_SQL)) {
				
				pstmt.setInt(1, PelangganId);
				pstmt.executeUpdate();
			}
			
		}

	    @Override
	    public Penjualan findPenjualanById(int id) throws SQLException {
	        try (Connection conn = Koneksi.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID_SQL)) {
	            pstmt.setInt(1, id);
	            try (ResultSet rs = pstmt.executeQuery()) {
	                if (rs.next()) {
	                    return new Penjualan(
	                        rs.getInt("penjualan_id"),
	                        rs.getInt("jumlah"),
	                        rs.getDouble("total_harga"),
	                        rs.getDate("tanggal").toLocalDate(), 
	                        rs.getInt("pelanggan_id"),
	                        rs.getInt("buku_id")
	                    );
	                }
	            }
	        }
	        
	        return null;
	    }

			
	
}
