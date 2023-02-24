package homework4;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit> {

    // Нужно реализовать хранение фруктов в коробке Box
    List<T> fruitBox = new ArrayList<T> ();
    private int sumWeigth;

    public void add(T fruit) {
        fruitBox.add(fruit);
    }

    public double getWeight() {
        sumWeigth = 0;
        fruitBox.forEach(fruit -> {
            sumWeigth += fruit.getWeight();
        });
        return sumWeigth;
    }

    public void moveTo(Box<? super T> anotherBox) {
        while(fruitBox.size() > 0) {
            anotherBox.add(fruitBox.get(0));
            fruitBox.remove(0);
        }
    }

}
