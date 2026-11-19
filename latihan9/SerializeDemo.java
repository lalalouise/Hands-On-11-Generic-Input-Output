import java.io.*;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    String name;
    int age;

    Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{name=" + name + ", age=" + age + "}";
    }
}

public class SerializeDemo {

    static void serialize(Employee e, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(fileName))) {
            oos.writeObject(e);
            System.out.println("Serialized successfully: " + fileName);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    static Employee deserialize(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(fileName))) {
            return (Employee) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Ray", 18);
        Employee e2 = new Employee("Rangga", 18);
        Employee e3 = new Employee("Bimansyah", 18);

        serialize(e1, "emp1.ser");
        serialize(e2, "emp2.ser");
        serialize(e3, "emp3.ser");

        System.out.println("===== Deserialize =====");
        String[] files = {"emp1.ser", "emp2.ser", "emp3.ser"};
        for (String f : files) {
            Employee restored = deserialize(f);
            if (restored != null) {
                System.out.println("Deserialized: " + restored);
            }
        }
    }
}