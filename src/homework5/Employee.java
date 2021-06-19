package homework5;

public class Employee {

    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee (String name, String position, String email, String phone, int salary, int age) {

        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;


    }

    public void getInfo () {
        System.out.printf("---------------\nИмя: %s\nДолжность: %s\nE-Mail: %s\nТелефон: %s\nДоход: %d\nВозраст: %d\n---------------\n", name, position, email, phone, salary, age);
    }

    public void getInfo (int maxage) {
        if (age > maxage)
            System.out.printf("---------------\nИмя: %s\nДолжность: %s\nE-Mail: %s\nТелефон: %s\nДоход: %d\nВозраст: %d\n---------------\n", name, position, email, phone, salary, age);
    }

    public static void main(String[] args) {
        Employee[] empArray = new Employee[5];
        empArray[0] = new Employee("Ivanov", "boss", "boss@rt.ru", "777887761", 50000, 41);
        empArray[1] = new Employee("Petrov", "deputy", "dep@rt.ru", "777887762", 30000, 39);
        empArray[2] = new Employee("Sodorov", "Engeneer", "eng@rt.ru", "777887763", 20000, 42);
        empArray[3] = new Employee("Borov", "Bukh", "bu@rt.ru", "777887764", 10000, 35);
        empArray[4] = new Employee("Pavlov", "Dvornik", "dvor@rt.ru", "777887765", 5000, 44);

        for (int i = 0; i < empArray.length; i++) {
            empArray[i].getInfo(40);
        }
    }

}
