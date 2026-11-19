enum AccountType {
    SAVINGS("SA", 2.5),
    CREDIT("CR", 5.0);

    private String code;
    private double interestRate; 

    private AccountType(String code, double interestRate) {
        this.code = code;
        this.interestRate = interestRate;
    }

    public String getCode() {
        return code;
    }

    public double getInterestRate() {
        return interestRate;
    }
}

public class Main {
    public static void main(String[] args) {
        AccountType t = AccountType.SAVINGS;
        System.out.println("===== Detail satu tipe =====");
        System.out.println("Nama       : " + t.name());
        System.out.println("Kode       : " + t.getCode());
        System.out.println("Suku bunga : " + t.getInterestRate() + "%");

        System.out.println("\n===== Semua tipe akun =====");
        for (AccountType type : AccountType.values()) {
            System.out.println(type.name()
                    + " -> kode: " + type.getCode()
                    + ", bunga: " + type.getInterestRate() + "%");
        }
    }
}