package application.PRAKTIKUM7.DAO.Impl;

import application.PRAKTIKUM7.DAO.PelangganDAO;
import application.PRAKTIKUM7.Model.Pelanggan;
import application.PRAKTIKUM7.Util.Koneksi;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PelangganDAOImpl implements PelangganDAO {
	private static final String INSERT_SQL = "INSERT INTO Pelanggan (nama, email, telepon) VALUES (?, ?, ?)";
	private static final String SELECT_ALL_SQL = "SELECT pelanggan_id, nama, email, telepon FROM Pelanggan";
    private static final String UPDATE_SQL = "UPDATE Pelanggan SET nama = ?, email = ?, telepon = ? WHERE pelanggan_id = ?";
    private static final String DELETE_SQL = "DELETE FROM Pelanggan WHERE pelanggan_id = ?";
    private static final String SELECT_BY_ID_SQL = "SELECT pelanggan_id, nama, email, telepon FROM Pelanggan WHERE pelanggan_id = ?";
    
    @Override
    public void addPelanggan(Pelanggan pelanggan) throws SQLException {
    	try (Connection conn = Koneksi.getConnection();
    			PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)){
    	
    		pstmt.setString(1,  pelanggan.getNama());
    		pstmt.setString(2,  pelanggan.getEmail());
    		pstmt.setString(3,  pelanggan.getTelepon());
    		pstmt.executeUpdate();
    		
    		try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
    			if (generatedKeys.next()) {
    				pelanggan.setPelanggan_id(generatedKeys.getInt(1));
    			}
    		}
    	}
    }
    
    @Override
    public List<Pelanggan> findAllPelanggan() throws SQLException {
    	List<Pelanggan> list = new ArrayList<>();
    	try (Connection conn = Koneksi.getConnection();
    			Statement stmt = conn.createStatement();
    			ResultSet rs = stmt.executeQuery(SELECT_ALL_SQL)) {
    		
    		while (rs.next()) {
    			list.add(new Pelanggan(
    					rs.getInt("pelanggan_id"),
    					rs.getString("nama"),
    					rs.getString("email"),
    					rs.getString("telepon")
    					));
    							
    		}
    	}
    	return list;
    }
    
    @Override
    public void editPelanggan(Pelanggan pelanggan) throws SQLException {
    	try (Connection conn = Koneksi.getConnection();
    			PreparedStatement pstmt = conn.prepareStatement(UPDATE_SQL)) {
    		pstmt.setString(1,  pelanggan.getNama());
    		pstmt.setString(2,  pelanggan.getEmail());
    		pstmt.setString(3,  pelanggan.getTelepon());
    		pstmt.setInt(4,  pelanggan.getPelanggan_id());
    		pstmt.executeUpdate();
    	}
    }
    
    @Override
    public void deletePelanggan(int id) throws SQLException {
    	try (Connection conn = Koneksi.getConnection();
    			PreparedStatement pstmt = conn.prepareStatement(DELETE_SQL)) {
    		pstmt.setInt(1, id);
    		pstmt.executeUpdate();
    	}
    }
    
    @Override
    public Pelanggan findPelangganById(int id) throws Exception {
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Pelanggan(
                        rs.getInt("pelanggan_id"),
                        rs.getString("nama"),
                        rs.getString("email"),
                        rs.getString("telepon")
                    );
                }
            }
        }
        return null;
    }

}
