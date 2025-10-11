package soal2;

import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedList;

public class MainNegara {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		
		HashMap<Integer, String> namaBulan = new HashMap<>();
        namaBulan.put(1, "Januari");
        namaBulan.put(2, "Februari");
        namaBulan.put(3, "Maret");
        namaBulan.put(4, "April");
        namaBulan.put(5, "Mei");
        namaBulan.put(6, "Juni");
        namaBulan.put(7, "Juli");
        namaBulan.put(8, "Agustus");
        namaBulan.put(9, "September");
        namaBulan.put(10, "Oktober");
        namaBulan.put(11, "November");
        namaBulan.put(12, "Desember");
        
        LinkedList<Negara> daftarNegara = new LinkedList<>();
        
        int jumlah = input.nextInt();
        input.nextLine();
        
        
        for(int i = 0; i < jumlah; i++){
        	String nama = input.nextLine();
        	String jenis = input.nextLine();
            String pemimpin = input.nextLine();
        	
        	
        	
        	if (jenis.equalsIgnoreCase("monarki")) {
        		Negara n = new Negara(nama, jenis, pemimpin);
        		daftarNegara.add(n);
        	} else {
        		int tanggal = input.nextInt();
        		
        		int bulan;
        		while (true) {
        			bulan = input.nextInt();
            		if (bulan < 1 || bulan > 12) {
            			System.out.println("Bulan harus antara 1-12! Silahkan input ulang");
        		}else {
        			break;
        		}
        		  } 
        		int tahun;
        	    while (true) {
        		tahun = input.nextInt();
        		if (tahun > 2025) {
        			System.out.println("Tahun tidak boleh lebih dari 2025! Silahkan input ulang");
        		}else {
        			break;
        		}
        		
        		}
        	    
        	    input.nextLine();
        		
        		Negara n = new Negara(nama, jenis, pemimpin, tanggal, bulan, tahun);
        		daftarNegara.add(n);
        		
        	}
        }
        
        for (Negara n : daftarNegara) {
        	String jenis = n.getJenisKepemimpinan();
        	String jabatan;
        	
        	if(jenis.equalsIgnoreCase("presiden")) {
        		jabatan = "Presiden";
        	} else if (jenis.equalsIgnoreCase("perdana menteri")) {
        		jabatan = "Perdana Menteri";
        	} else if (jenis.equalsIgnoreCase("monarki")) {
        		jabatan = "Raja";
        	} else {
        		jabatan = "Pemimpin";
        	}
        	
        	System.out.print("Negara " + n.getNama() + " mempunyai " + jabatan + " bernama " + n.getNamaPemimpin());
        	
        	if (! jenis.equalsIgnoreCase("monarki")) {
        		String bulanNama =  namaBulan.get(n.getBulanKemerdekaan());
        		System.out.print(" Deklarasi kemerdekaan pada Tanggal " + n.getTanggalKemerdekaan() + " " + bulanNama + " " +n.getTahunKemerdekaan());
        	}
        	System.out.println("\n");
        }
        input.close();
	}  
	}



