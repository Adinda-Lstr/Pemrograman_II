package praktikum2.soal3;

// baris ini terjadi error karena nama class tidak sama denga nama file.
//file bernama Pegawai.java tapi class bernama Employee.
//public class Employee {    
public class Pegawai {
	
public String nama;  

// pada baris ini terjadi error karena tipe data asal seharusnya string, bukan char.
// public char asal;  
public String asal;

public String jabatan; 
public int umur; 

public String getNama() { 
    return nama; 
} 

public String getAsal() { 
    return asal; 
} 

// Pada baris ini terjadi error karena parameter 'j' tidak dideklarasikan.
//harus menambahkan parameter pada method setJabatan.
//public void setJabatan() { 
  //  this.jabatan = j; 
//}    

public void setJabatan(String j) {
	this.jabatan = j;
	
	// baris ini ditambahkan agar umur yang tercetak tidak 0
	this.umur = 17;
  }
} 

