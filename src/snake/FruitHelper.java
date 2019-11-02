package snake;

import snake.entity.Fruit;

import java.util.ArrayList;

public class FruitHelper {

    public static ArrayList<Fruit> getArray(Fruit fruit, int size) {
        ArrayList<Fruit> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Fruit copy = new Fruit(fruit);
            arrayList.add(copy);
        }
        return arrayList;
    }
}
