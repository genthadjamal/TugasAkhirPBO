package com.prak;

public class StructMember {
    public String kode;
    private String nama;
    private String jenisKelamin;
    private String alamat;
    private String noTelepon;

    public void setNama(String namaMember){
        nama = namaMember;
    }
    public String getNama(){
        return nama;
    }
    public void setJenisKelamin(String jenisKel){
        jenisKelamin = jenisKel;
    }
    public String getJenisKelamin(){
        return jenisKelamin;
    }

    public void setAlamat(String alamatMember) {
        alamat = alamatMember;
    }
    public String getAlamat(){
        return alamat;
    }
    public void setNoTelepon(String noTelpMember){
        noTelepon = noTelpMember;
    }
    public String getNoTelepon(){
        return noTelepon;
    }
}
