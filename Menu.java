package com.prak;

import java.io.IOException;

public class Menu extends Babershop {
    @Override
    public void menuUtama() throws IOException{
        super.menuUtama();
        pilih = member.readLine();
        if(pilih.equals("1")){
            subMenuMember();
        } else if (pilih.equals("2")){
            hitung();
            totalAkhirCustomer(totalHargaNonMember);
            menuUtama();
        } else if (pilih.equals("3")) {
            System.out.println(0);
        }
        System.out.println("");
    }

    @Override
    public void subMenuMember() throws IOException {
        super.subMenuMember();
        System.out.println("1. Buat data member baru");
        System.out.println("2. Tampilkan semua data member");
        System.out.println("3. Transaksi Member");
        System.out.println("4. Kembali");
        System.out.println("masukkan pilihan : ");
        pilihSubMenu = member.readLine();
        if (pilihSubMenu.equals("1")) {
            inputDataMember(namaMember, kodeMember, jenisKelaminMember, alamatMember, noTelponMember);
        } else if (pilihSubMenu.equals("2")){
            tampilkanDataMember();
        } else if (pilihSubMenu.equals("3")){
            do {
                caridataMember();
                System.out.println("Apakah data benar ? [y/t] ");
                konfirmMember = member.readLine();
            } while (konfirmMember.equals("t"));
            hitung();
            totalAkhirCustomer(totalHargaMember, diskonHargaMember);
            menuUtama();
        } else if (pilihSubMenu.equals("4")) {
            menuUtama();
        }
    }
}
