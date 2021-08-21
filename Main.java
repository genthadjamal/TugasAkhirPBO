package com.prak;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	    Menu data = new Menu();
	    data.tambahLayanan("1","Potong Rambut", 15000);
	    data.tambahLayanan("2","Cuci Rambut", 10000);
	    data.tambahLayanan("3","Mewarnai Rambut", 15000);
	    data.tambahLayanan("4","Potong Rambut + Vitamin", 25000);
	    data.tambahLayanan("5","Potong Rambut + Pijet",25000);
	    data.tambahLayanan("6","Membeli Pomade",15000);
	    data.tambahLayanan("7","Hanya Keramas",8000);
	    data.menuUtama();
    }
}
