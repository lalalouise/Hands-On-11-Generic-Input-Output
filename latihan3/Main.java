class Cell<T> {
    private T data;

    public void setValue(T data) {
        this.data = data;
    }

    public T getValue() {
        return data;
    }

    public void displayType() {
        if (data == null) {
            System.out.println("Tipe data     : (belum ada nilai)");
        } else {
            System.out.println("Tipe data     : " + data.getClass().getName());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Cell<Integer> intCell = new Cell<Integer>();
        intCell.setValue(100);
        int num = intCell.getValue();          
        System.out.println("Nilai Integer : " + num);
        intCell.displayType();

        Cell<String> strCell = new Cell<String>();
        strCell.setValue("Halo Java");
        String str = strCell.getValue();       
        System.out.println("Nilai String  : " + str);
        strCell.displayType();
    }
}