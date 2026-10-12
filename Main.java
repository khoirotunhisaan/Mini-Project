import java.util.ArrayList;
import java.util.Scanner;

class Mahasiswa {
    String nama;
    String nim;
    double nilai;

    public Mahasiswa(String nama, String nim, double nilai) {
        this.nama = nama;
        this.nim = nim;
        this.nilai = nilai;
    }

    public void tampilkanData() {
        System.out.println("NIM   : " + nim);
        System.out.println("Nama  : " + nama);
        System.out.println("Nilai : " + nilai);
    }

    public String cekKelulusan() {
        if (this.nilai >= 75) {
            return "LULUS";
        } else {
            return "TIDAK LULUS";
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
        

        boolean isRunning = true;
        int pilihan;

        System.out.println("=== PROGRAM DATA MAHASISWA ===");

        while (isRunning) {
            System.out.println("\nMenu:");
            System.out.println("1. Input Data Mahasiswa");
            System.out.println("2. Tampilkan Semua Data");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3): ");
            
            pilihan = input.nextInt();
            input.nextLine(); // Consume newline

            if (pilihan == 1) {
                System.out.print("Masukkan Nama : ");
                String nama = input.nextLine();
                
                System.out.print("Masukkan NIM  : ");
                String nim = input.nextLine();
                
                System.out.print("Masukkan Nilai: ");
                double nilai = input.nextDouble();
                input.nextLine(); // Consume newline

                Mahasiswa mhs = new Mahasiswa(nama, nim, nilai);
                daftarMahasiswa.add(mhs);
                
                System.out.println(">> Data berhasil ditambahkan!");

            } else if (pilihan == 2) {
                if (daftarMahasiswa.isEmpty()) {
                    System.out.println(">> Belum ada data mahasiswa.");
                } else {
                    System.out.println("\n=== DAFTAR NILAI MAHASISWA ===");

                    for (int i = 0; i < daftarMahasiswa.size(); i++) {
                        Mahasiswa m = daftarMahasiswa.get(i);
                        System.out.println("\nMahasiswa ke-" + (i + 1));
                        m.tampilkanData(); // Panggil method
                        System.out.println("Status: " + m.cekKelulusan()); // Panggil method
                        System.out.println("-----------------------------");
                    }
                }
            } else if (pilihan == 3) {
                isRunning = false;
                System.out.println(">> Program selesai. Makasih!");
            } else {
                System.out.println(">> Pilihan tidak valid, coba lagi.");
            }
        }
        
        input.close();
    }
}

