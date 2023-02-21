package homework3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* Создать класс Notebook с полями (price(double), ram(int))
1. Сгенерировать список объектов типа Notebook с разными значениям price и ram
2. Релизовать 3 сортировки: 1 - по цене, 2 - по памяти, 3 - сначала по памяти, потом по цене
3. Отсортировать тремя способами стандартными средствами (Collections#sort или List#sort)

Повторить про Iterator и Iterable */

public class ProgMain {
    public static void main(String[] args) {
        List<Notebook> laptops = new ArrayList<Notebook>();
        laptops.add(new Notebook(0, "Asus A55",20999, 2));
        laptops.add(new Notebook(1, "Acer X3", 17999, 4));
        laptops.add(new Notebook(2, "Lenovo Z1", 23999, 4));
        laptops.add(new Notebook(3, "Dexp R1", 22999, 2));
        laptops.add(new Notebook(4, "HP X17", 27999, 8));
        laptops.add(new Notebook(5, "MacBook Air", 149999, 16));
        laptops.add(new Notebook(6, "Asus K60", 17999, 2));
        laptops.add(new Notebook(7, "Acer Z8", 15999, 2));
        laptops.add(new Notebook(8, "HP XML8", 22999, 4));
        laptops.add(new Notebook(9, "MSI WW1", 27999, 4));

        Comparator<Notebook> priceComparator = (o1, o2) -> (int)(o1.getPrice() - o2.getPrice());
        Comparator<Notebook> ramComparator = (o1, o2) -> o1.getRam() - o2.getRam();
        Comparator<Notebook> ramPriceComparator = (o1, o2) -> {
            if (o1.getRam() - o2.getRam() == 0) {
                return (int)(o1.getPrice() - o2.getPrice());
            }
            return o1.getRam() - o2.getRam();
        };

        Collections.sort(laptops, ramComparator);
        System.out.println("Фильтр по объему RAM: ");
        System.out.println(laptops);
        
        Collections.sort(laptops, priceComparator);
        System.out.println("Фильтр по цене: ");
        System.out.println(laptops);

        Collections.sort(laptops, ramPriceComparator);
        System.out.println("Фильтр по объему RAM, если RAM одинаковые дополнительная сортировка по цене: ");
        System.out.println(laptops);
    }

    public static class Notebook {
        private final int id;
        private final String name;
        private final double price;
        private final int ram;

        public Notebook (int id, String name, double price, int ram) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.ram = ram;
        }

        public double getPrice() {
            return this.price;            
        }

        public int getRam() {
            return this.ram;            
        }

        @Override
        public String toString() {
            return String.format("ID: %d, price: %.2f, ram: %d, name: %s\n", this.id, this.price, this.ram, this.name);
        }
    } 
}
