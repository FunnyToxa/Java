import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        Integer[] intArr = {1,3,5,7,2,4,6,8};
        System.out.println("Исходный массив: " + Arrays.toString(intArr));

        //создаем итератор по нашему массиву
        Iterator iter = new Iterator(intArr);

        //перебираем массив через наш итератор
        System.out.println("Перебор массива через итератор:");
        while (iter.hasNext())
            System.out.println(iter.next());
        System.out.println("пробуем еще раз next():");
        System.out.println(iter.next());
        System.out.println("вызываем prev():");
        System.out.println(iter.prev());
    }
}
