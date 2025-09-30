package MODUL1;

import java.util.Scanner;

public class PRAK101_2410817120015_AdindaLestari {

	public static void main(String[] args) {
String Nama, TempatLahir;
int TanggalLahir, BulanLahir, TahunLahir, TinggiBadan;
float BeratBadan;

Scanner input = new Scanner(System.in);

System.out.print("Masukkan Nama Lengkap               :");
Nama = input.nextLine();
System.out.print("Masukkan Tempat Lahir               :");
TempatLahir = input.nextLine();
System.out.print("Masukkan Tanggal Lahir              :");
TanggalLahir = Integer.parseInt(input.nextLine());
System.out.print("Masukkan Bulan Lahir                :");
BulanLahir = Integer.parseInt(input.nextLine());
System.out.print("Masukkan Tahun Lahir                :");
TahunLahir = Integer.parseInt(input.nextLine());
System.out.print("Masukkan Tinggi Badan               :");
TinggiBadan = Integer.parseInt(input.nextLine());
System.out.print("Masukkan Berat Badan                :");
BeratBadan = Float.parseFloat(input.nextLine());


String bulan = "";
switch (BulanLahir) {

case 1 -> bulan = "Januari";
case 2 -> bulan = "Februari";
case 3 -> bulan = "Maret";
case 4 -> bulan = "April";
case 5 -> bulan = "Mei";
case 6 -> bulan = "Juni";
case 7 -> bulan = "Jali";
case 8 -> bulan = "Agustus";
case 9 -> bulan = "September";
case 10 -> bulan = "Oktober";
case 11 -> bulan = "November";
case 12 -> bulan = "Desember";
default -> System.out.println("Pilihan tidak tersedia");

}


System.out.print("Nama Lengkap " + Nama + ",");
System.out.print("Lahir di " + TempatLahir);
System.out.print(" Pada Tanggal " + TanggalLahir);
System.out.print(" " + bulan + " ");
System.out.print(TahunLahir + " ");
System.out.print("Tinggi Badan " + TinggiBadan + " cm");
System.out.print(" dan berat badan " + BeratBadan + " kilogram");

	}

}
