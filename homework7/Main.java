package homework7;

public class Main {
// Создать класс Сотрудник (Employee) с полями:
// Имя, Фамилия (String)
// Название отдела (String)
// Зарплата (double)
// Реализовать equals и hashCode, который работает только с именем и фамилией
    public static void main(String[] args) {
        Employee employee1 = new Employee("Иван Каспаров", "приборостроение", 30000);
        Employee employee2 = new Employee("Иван Каспаров", "бухгалтерия", 30000);
        Employee employee3 = new Employee("Карэн Алиев", "приборостроение", 40000);
        Employee employee4 = new Employee("Иван Каспаров", "приборостроение", 50000);
        Employee employee5 = new Employee("Геннадий Фролов", "приборостроение", 30000);
        Employee employee6 = new Employee("Екатерина Сергеева", "приборостроение", 30000);

        System.out.println(employee1.equals(employee1));
        System.out.println(employee1.equals(employee2));
        System.out.println(employee1.equals(employee3));
        System.out.println(employee1.equals(employee4));
        System.out.println(employee1.equals(employee5));
        System.out.println(employee1.equals(employee6));

        System.out.println("------------------------");

        System.out.println(employee1.hashCode());
        System.out.println(employee2.hashCode());
        System.out.println(employee3.hashCode());
        System.out.println(employee4.hashCode());
        System.out.println(employee5.hashCode());
        System.out.println(employee6.hashCode());
    }
}
