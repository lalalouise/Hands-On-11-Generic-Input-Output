public class CompareUtil {

    public static <T extends Comparable<T>> boolean isEqual(T a, T b) {
        return a.compareTo(b) == 0;
    }

    public static void main(String[] args) {
        System.out.println("Integer   : isEqual(5, 5)            = " + isEqual(5, 5));
        System.out.println("String    : isEqual(\"Hello\", \"World\") = " + isEqual("Hello", "World"));
        System.out.println("Double    : isEqual(3.14, 3.14)      = " + isEqual(3.14, 3.14));
        System.out.println("Double    : isEqual(2.5, 7.8)        = " + isEqual(2.5, 7.8));
        System.out.println("Character : isEqual('A', 'A')        = " + isEqual('A', 'A'));
        System.out.println("Character : isEqual('a', 'B')        = " + isEqual('a', 'B'));
    }
}