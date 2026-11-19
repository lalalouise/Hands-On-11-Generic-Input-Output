import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

class Item<T, U, V> {
    private T nama;
    private U nilai;
    private V jumlah;

    public Item(T nama, U nilai, V jumlah) {
        this.nama = nama;
        this.nilai = nilai;
        this.jumlah = jumlah;
    }

    @Override
    public String toString() {
        return nama + "," + nilai + "," + jumlah;
    }
}

public class ItemWriter {

    static <T, U, V> void simpanDanBaca(List<Item<T, U, V>> items, String fileName) {
        Path filePath = Paths.get(fileName);

        try {
            List<String> lines = new ArrayList<>();
            for (Item<T, U, V> item : items) {
                lines.add(item.toString());
            }
            Files.write(filePath, lines);
            System.out.println("Data berhasil disimpan ke " + fileName);

            if (Files.notExists(filePath)) {
                System.out.println("File tidak ditemukan: " + filePath.toAbsolutePath());
                return;
            }

            List<String> hasil = Files.readAllLines(filePath);
            System.out.println("Isi " + fileName + ":");
            hasil.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        List<Item<String, Double, Integer>> produkList = new ArrayList<>();
        produkList.add(new Item<>("Laptop", 15000000.0, 5));
        produkList.add(new Item<>("Mouse", 150000.0, 40));
        produkList.add(new Item<>("Keyboard", 350000.0, 25));
        simpanDanBaca(produkList, "produk_output.txt");

        System.out.println();

        List<Item<String, String, Integer>> pelangganList = new ArrayList<>();
        pelangganList.add(new Item<>("Ray", "Jayapura", 28));
        pelangganList.add(new Item<>("Rangga", "Gowa", 35));
        simpanDanBaca(pelangganList, "pelanggan_output.txt");

        System.out.println();

        List<Item<String, Double, Integer>> transaksiList = new ArrayList<>();
        transaksiList.add(new Item<>("TRX001", 15150000.0, 2));
        transaksiList.add(new Item<>("TRX002", 350000.0, 1));
        simpanDanBaca(transaksiList, "transaksi_output.txt");
    }
}