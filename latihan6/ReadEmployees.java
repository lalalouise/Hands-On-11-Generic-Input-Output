import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReadEmployees {
    public static void main(String[] args) {
        Path path = Paths.get("employees.txt");

        if (Files.notExists(path)) {
            System.out.println("File tidak ditemukan: " + path.toAbsolutePath());
            return;
        }

        List<String> employees = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            employees = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Gagal membaca file: " + e.getMessage());
            return;
        }

        System.out.println("=== Isi employees.txt ===");
        employees.forEach(System.out::println);
        System.out.println("Jumlah baris dibaca: " + employees.size());

        Path copyPath = Paths.get("copy_employees.txt");
        try {
            Files.write(copyPath, employees);
            System.out.println("Berhasil ditulis ke " + copyPath);
        } catch (IOException e) {
            System.out.println("Gagal menulis file: " + e.getMessage());
        }
    }
}