enum AccountType {
    SAVINGS, CREDIT, DEPOSIT;

    @Override
    public String toString() {
        switch (this) {
            case SAVINGS:
                return "Savings: rekening tabungan";
            case CREDIT:
                return "Credit: rekening kredit";
            case DEPOSIT:
                return "Deposit: rekening deposito berjangka";
            default:
                return name();
        }
    }
}

class Account {
    private AccountType type;

    public Account(AccountType type) {
        this.type = type;
    }

    public AccountType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Account bertipe -> " + type;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("===== Semua tipe akun =====");
        for (AccountType t : AccountType.values()) {
            System.out.println(t.ordinal() + ". " + t.name() + " -> " + t);
        }

        System.out.println("\n===== Contoh Account =====");
        Account a1 = new Account(AccountType.SAVINGS);
        Account a2 = new Account(AccountType.CREDIT);
        Account a3 = new Account(AccountType.DEPOSIT);

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
    }
}