package com.prak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Babershop {
    StructMember[] daftar = new StructMember[100];
    int banyakData = 1;
    InputStreamReader data = new InputStreamReader(System.in);
    BufferedReader member = new BufferedReader(data);
    String lagi, kodeLayanan, tempBayar;
    double totalAkhir, total, totalHargaMember, totalHargaNonMember, dibayar, kembali, diskonHargaMember, totalBiayaNonMember;
    String pilih, kodeMember, pilihSubMenu, konfirmMember, namaMember, jenisKelaminMember, alamatMember, noTelponMember;

    public void tambahDataMember(String idMember, String name, String sex, String address, String phone){
        daftar[banyakData] = new StructMember();
        daftar[banyakData].kode = idMember;
        daftar[banyakData].setNama(name);
        daftar[banyakData].setJenisKelamin(sex);
        daftar[banyakData].setAlamat(address);
        daftar[banyakData].setNoTelepon(phone);
        banyakData++;
    }
    public void inputDataMember (String idMember, String namaMember, String jenisK, String alamat, String noTelpon) throws IOException {
        try {
            System.out.println("");
            System.out.print("Id Member   : ");
            idMember = member.readLine();
            System.out.print("Nama        : ");
            namaMember = member.readLine();
            System.out.print("jenis Kelamin : ");
            jenisK = member.readLine();
            System.out.print("Alamat      : ");
            alamat = member.readLine();
            System.out.print("No. Telpon  : ");
            noTelpon = member.readLine();
            if (idMember.equals("") || namaMember.equals("")) {
                throw new NullPointerException();
            }
            tambahDataMember(idMember, namaMember, jenisK, alamat, noTelpon);
            subMenuMember();
        } catch (NullPointerException npe){
            System.out.println("");
            System.out.println("ID ATAU NAMA TIDAK BOLEH KOSONG");
        }
        subMenuMember();
    }
    public void tampilkanDataMember() throws  IOException {
        System.out.println("");
        daftar[banyakData] = new StructMember();
        if (banyakData == 1){
            System.out.println("Data masih kosong");
        } else {
            for (int isi=1; isi<banyakData; isi++){
                System.out.println("Data ke "+isi);
                System.out.println("Id member     : "+daftar[isi].kode);
                System.out.println("Nama          : "+daftar[isi].getNama());
                System.out.println("Jenis Kelamin : "+daftar[isi].getJenisKelamin());
                System.out.println("Alamat        : "+daftar[isi].getAlamat());
                System.out.println("No. Telepon   : "+daftar[isi].getNoTelepon());
                System.out.println("");
            }
        }
        subMenuMember();
    }
    public String getNamaMember(String idMember){
        for (int isi=1; isi<banyakData; isi++){
            if (idMember.equals(daftar[isi].kode)) {
                return daftar[isi].getNama();
            }
        }
        return null;
    }
    public String getAlamatMember(String idMember){
        for (int isi=1; isi<banyakData; isi++){
            if (idMember.equals(daftar[isi].kode)){
                return daftar[isi].getAlamat();
            }
        }
        return null;
    }
    public void caridataMember() throws IOException{
        try{
            String kodeMemberCari;
            System.out.println("Masukkan Id Member : ");
            kodeMemberCari = member.readLine();
            if (kodeMemberCari.equals("")){
                throw new NullPointerException();
            }
            System.out.println("Data dari kode member "+ kodeMemberCari);
            System.out.println("Nama     : "+getNamaMember(kodeMemberCari));
            System.out.println("Alamat   : "+getAlamatMember(kodeMemberCari));
        } catch (NullPointerException ex) {
            System.out.println("Id Member harus di isi !");
        }
    }
    public void menuUtama() throws IOException {
        System.out.println("MENU APLIKASI BABERSHOP");
        System.out.println("1. Non Member");
        System.out.println("2. Member");
        System.out.println("3. Keluar");
        System.out.println("Masukkan pilihan : ");
    }
    public void subMenuMember() throws IOException{

    }
    StructLayanan[] info = new StructLayanan[25];
    int banyakLayanan = 1;

    public void tambahLayanan(String code, String nameOfService, double priceOfService) {
        info[banyakLayanan] = new StructLayanan();
        info[banyakLayanan].idLayanan = code;
        info[banyakLayanan].setNamaLayanan(nameOfService);
        info[banyakLayanan].setHarga(priceOfService);
        banyakLayanan++;
    }
    public void display(){
        for (int i=1; i<banyakLayanan; i++){
            System.out.println("Id layanan : "+info[i].idLayanan);
            System.out.println("Layanan    : "+info[i].getNamaLayanan());
            System.out.println("Harga      : "+info[i].getPrice());
            System.out.println("");
        }
    }
    public void hitung() throws IOException{
        System.out.println("");
        display();
        total = 0;
        do {
            System.out.println("Masukkan pilihan : ");
            kodeLayanan = member.readLine();
            for (int lay=1; lay<banyakLayanan; lay++){
                if(kodeLayanan.equals(info[lay].idLayanan)){
                    System.out.println("Nama  : "+info[lay].getNamaLayanan());
                    System.out.println("Harga : "+info[lay].getPrice());
                    total = total + info[lay].getPrice();
                    lay = lay+1;
                }
            }
            System.out.print("Apakah lagi ? [y/t]");
            lagi = member.readLine();
        } while (lagi.equals("y"));
    }
    public void totalAkhirCustomer(double totalHarga, double hargaDiskon) throws IOException{
        try {
            hargaDiskon = 0.1 * total;
            totalHarga = total - hargaDiskon;
            System.out.println("Total biaya : "+ totalHarga);
            System.out.print("Dibayar       : ");
            tempBayar = member.readLine();
            if (tempBayar.equals("")){
                throw new NullPointerException();
            }
            dibayar = Double.parseDouble(tempBayar);
            kembali = dibayar - totalHarga;
            if (kembali < 0){
                throw new ArithmeticException();
            }
            System.out.println("Kembali   : "+ kembali);
        } catch (NumberFormatException xy){
            System.out.println("ERROR : NOMINAL YANG DIMASUKKAN SALAH !");
        } catch (NullPointerException ab){
            System.out.println("ERROR : NOMINAL HARUS DIISI !");
        } catch (ArithmeticException cd) {
            System.out.println("ERROR : NOMINAL KEMBALIAN TIDAK BOLEH NEGATIF !");
        }
        System.out.println("");
    }
    public void totalAkhirCustomer(double totalHarga) throws IOException{
        try {
            System.out.println("Total Biaya : "+ total);
            if (total < 150000){
                totalBiayaNonMember = total - 10000;
                System.out.println("Dapat potongan harga sebesar 10000");
                System.out.println("Total Biaya : "+totalBiayaNonMember);
                System.out.print("Dibayar      : ");
                tempBayar = member.readLine();
                if (tempBayar.equals("")){
                    throw new NullPointerException();
                }
                dibayar = Double.parseDouble(tempBayar);
                totalHarga = dibayar - totalBiayaNonMember;
                if (totalHarga < 0){
                    throw new ArithmeticException();
                }
                System.out.println("kembali    : "+totalHarga);
            } else {
                System.out.print("Dibayar   : ");
                tempBayar = member.readLine();
                if (tempBayar.equals("")){
                    throw new NullPointerException();
                }
                dibayar = Double.parseDouble(tempBayar);
                totalHarga = dibayar - total;
                if (totalHarga < 0){
                    throw new ArithmeticException();
                }
                System.out.println("Kembali   : "+ totalHarga);
            }
        } catch (NullPointerException cd){
            System.out.println("NOMINAL HARUS DIISI !");
        } catch (NumberFormatException ef){
            System.out.println("NOMINAL YANG DIMASUKKAN SALAH !");
        } catch (ArithmeticException gh){
            System.out.println("ERROR : NOMINAL KEMBALIAN TIDAK BOLEH NEGATIF !");

        }
        System.out.println("");
    }
}
