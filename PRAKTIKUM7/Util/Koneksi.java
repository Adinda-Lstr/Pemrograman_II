package application.PRAKTIKUM7.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
	private static final String URL = "jdbc:mysql://localhost:3306/toko_buku";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL, USER, PASSWORD);
		}
		catch (ClassNotFoundException e) {
			throw new SQLException("Driver MySQL tidak ditemukan: " + e.getMessage());
		}
	}
	
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.err.println("Gagal menutup Koneksi: " + e.getMessage());
			}
		}
	}

}
