import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FileCopyNew {
    public static void main(String[] args) {
        Path source = Paths.get("report.txt");
        Path backup = Paths.get("backup/report.txt");
        Path logPath = Paths.get("log.txt");

        List<String> log = new ArrayList<>();

        try {
            Files.write(source, List.of("Report Generated", "Status: OK"));
            log.add(LocalDateTime.now() + " | OK    | report.txt berhasil ditulis");

            if (Files.exists(source)) {
                if (Files.notExists(backup.getParent())) {
                    Files.createDirectories(backup.getParent());
                    log.add(LocalDateTime.now() + " | OK    | folder backup dibuat");
                }

                Files.copy(source, backup, StandardCopyOption.REPLACE_EXISTING);
                log.add(LocalDateTime.now() + " | OK    | report.txt disalin ke " + backup);
                System.out.println("Backup created successfully!");
            } else {
                log.add(LocalDateTime.now() + " | ERROR | file sumber tidak ditemukan, backup dibatalkan");
                System.out.println("File sumber tidak ditemukan, backup dibatalkan.");
            }
        } catch (IOException e) {
            log.add(LocalDateTime.now() + " | ERROR | " + e.getMessage());
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }

        try {
            Files.write(logPath, log, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("Log ditulis ke " + logPath);
        } catch (IOException e) {
            System.out.println("Gagal menulis log: " + e.getMessage());
        }
    }
}