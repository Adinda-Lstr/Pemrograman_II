package praktikum2.soal3;

public class Soal3Main {

	public static void main(String[] args) {
	Pegawai p1 = new Pegawai(); 
	
	// Pada baris ini terjadi error karena kurang titikkoma ';'diakhir baris.
	// p1.nama = "Roi"  
	p1.nama = "Roi";
	
	// Pada baris ini awalnya terjadi error karena tipe data di class Pegawai awalnya char namun sekarang sudah diubah menjadi string
	// jadi tandakutip ganda "" menajdi benar, dan tidak perlu diperbaiki.
    p1.asal = "Kingdom of Orvel";         
	p1.setJabatan("Assasin"); 
		 
        System.out.println("Nama Pegawai: " + p1.getNama());
        System.out.println("Asal: " + p1.getAsal()); 
        System.out.println("Jabatan: " + p1.jabatan); 
        
        // Pada baris ini awalnya hanya akan mencetak umur: 17, sedangkan output yang diminta adalah Umur: 17 tahun
        // jadi ditambahkan + " tahun" agar sesuai dengan output yang diminta
        // System.out.println("Umur: " + p1.umur)
        System.out.println("Umur: " + p1.umur + " tahun"); 

	}
}
