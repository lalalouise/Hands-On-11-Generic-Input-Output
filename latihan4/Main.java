class Pair<T1, T2> {
    private T1 first;
    private T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    public void showTypes() {
        System.out.println(first.getClass().getName() + " & "
                + second.getClass().getName());
    }

    public Pair<T2, T1> swap() {
        return new Pair<T2, T1>(second, first);
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

public class Main {
    public static void main(String[] args) {
        Pair<Integer, String> p1 = new Pair<Integer, String>(101, "Budi");
        System.out.println("===== Pair<Integer, String> =====");
        System.out.println("Isi              : " + p1);
        System.out.print("Tipe             : ");
        p1.showTypes();

        Pair<String, Integer> s1 = p1.swap();
        System.out.println("Setelah swap     : " + s1);
        System.out.print("Tipe setelah swap: ");
        s1.showTypes();

        Pair<Double, Boolean> p2 = new Pair<Double, Boolean>(3.14, true);
        System.out.println("\n===== Pair<Double, Boolean> =====");
        System.out.println("Isi              : " + p2);
        System.out.print("Tipe             : ");
        p2.showTypes();

        Pair<Boolean, Double> s2 = p2.swap();
        System.out.println("Setelah swap     : " + s2);
        System.out.print("Tipe setelah swap: ");
        s2.showTypes();
    }
}