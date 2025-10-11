package soal3;

import java.util.Scanner;
import java.util.ArrayList;

public class MainMahasiswa {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
		
		int pilihan;
		
		do {
			System.out.println("\nMenu");
			System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa berdasarkan NIM");
            System.out.println("3. Cari Mahasiswa berdasarkan NIM");
            System.out.println("4. Tampilkan Daftar Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            
            while (!input.hasNextInt()) {
            	System.out.println("Input tidak valid! Harus berupa angka");
            	System.out.print("Pilihan: ");
            	input.next();
            }
            
            pilihan = input.nextInt();
            input.nextLine();
            
            switch (pilihan) {
            case 1:
            	System.out.print("Masukkan Nama Mahasiswa: ");
            	String nama = input.nextLine().trim();
            	
            	
            	if (nama.isEmpty()) {
            		System.out.println("Nama tidak boleh Kosong!");
            		break;
            	}
            	System.out.print("Masukkan NIM Mahasiswa (harus unik): ");
            	String nim = input.nextLine().trim();
            	
            
            	if (nim.isEmpty()) {
            		System.out.println("NIM tidak boleh kosong!");
            		break;
            	}
            	
            	boolean nimSudahAda = false;
            	for (Mahasiswa m : daftarMahasiswa) {
            		if (m.getNim().equals(nim)) {
            			nimSudahAda = true;
            			break;
            		}
            	}
            	
            	if (nimSudahAda) {
            		System.out.println("NIM sudah ada! Gunakan NIM lain");
            		
            	}else {
            		daftarMahasiswa.add(new Mahasiswa(nama, nim));
            		System.out.println("Mahasiswa " + nama + " ditambahkan.");
            	}
            	 break;
            	 
            	 case 2:
            	    if (daftarMahasiswa.isEmpty()) {
            	    	System.out.println("Daftar mahasiswa ksosong, tidak ditemukan.");
            	    	break;
            	    }
            	    
            	    System.out.print("Masukkan NIM mahasiswa yang akan dihapus: ");
            	    String nimHapus = input.nextLine().trim();
            	    
            	    
            	    boolean ditemukan = false;
            	    for (int i = 0; i < daftarMahasiswa.size(); i++) {
            	    	if (daftarMahasiswa.get(i).getNim().equals(nimHapus)) {
            	    		daftarMahasiswa.remove(i);
            	    		System.out.println("Mahasiswa dengan NIM " + nimHapus + " dihapus.");
            	    		ditemukan = true;
            	    		break;
            	    	}
            	    }
            	    
            	    if (!ditemukan) {
            	    	System.out.println(" Mahasiswa dengan NIM " + nimHapus + " tidak ditemukan.");
            	    }
            	    break;
            	    
            	 case 3:
            		 if (daftarMahasiswa.isEmpty()) {
                         System.out.println("Daftar mahasiswa kosong, tidak ada yang bisa dicari.");
                         break;
                     }

                     System.out.print("Masukkan NIM Mahasiswa yang dicari: ");
                     String nimCari = input.nextLine().trim();

                     boolean ada = false;
                     for (Mahasiswa m : daftarMahasiswa) {
                         if (m.getNim().equals(nimCari)) {
                             System.out.println("Ditemukan!");
                             System.out.println("NIM: " + m.getNim() + ", Nama: " + m.getNama());
                             ada = true;
                             break;
                         }
                     }
                     if (!ada) {
                         System.out.println(" Mahasiswa dengan NIM " + nimCari + " tidak ditemukan.");
                     }
                     break;

                 case 4: 
                     if (daftarMahasiswa.isEmpty()) {
                         System.out.println("Daftar mahasiswa masih kosong.");
                     } else {
                         System.out.println("Daftar Mahasiswa:");
                         for (Mahasiswa m : daftarMahasiswa) {
                             System.out.println("NIM: " + m.getNim() + ", Nama: " + m.getNama());
                         }
                     }
                     break;

                 case 0: 
                     daftarMahasiswa.clear(); 
                     System.out.println("Terima kasih!");
                     break;

                 default:
                     System.out.println("Pilihan tidak valid. Silakan coba lagi.");
             }

         } while (pilihan != 0);

         input.close();
            	 
	}
	}


