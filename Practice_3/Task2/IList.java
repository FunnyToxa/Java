public interface IList {
    //вывод значения элемента по его позиции
    Integer get(int pos);

    //добавление элемента в конец
    void add(Integer val);

    //добавление элемента по индексу
    boolean add(int pos, Integer val);

    //удаление елемента по позиции
    boolean remove(int pos);

    //вывод кол-ва элементов
    int getSize();

    //изменение элемента
    void modify(int pos, Integer newVal);

    //метод проерки вхождения в
    boolean contains(Integer value);

    //поиск минимальной позиции элемента
    int getMin();

    int getMax();

    //вывод отсортированного массива в порядке возрастания и убывания без изменения исходного
    void printSorted(boolean isDesc);

    //преобразование листа в массив
    Integer[] toArray();

    //вывод массива
    void print();


}
