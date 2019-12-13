public interface IList<T> {
    //вывод значения элемента по его позиции
    T get(int pos) throws ListOutOfRangeException;

    //добавление элемента в конец
    void add(T val);

    //добавление элемента по индексу
    void add(int pos, T val) throws ListOutOfRangeException;

    //удаление елемента по позиции
    void remove(int pos) throws ListOutOfRangeException;

    //вывод кол-ва элементов
    int getSize();

    //изменение элемента
    void modify(int pos, T newVal) throws ListOutOfRangeException;

    //метод проерки вхождения в лист
    boolean contains(T value);

    //получение позиции минимального элемента
    T getMin() throws ListNullException;

    //получение позиции максимального элемента
    T getMax() throws ListNullException;

    //преобразование листа в массив
    T[] toArray();

    //вывод массива
    void print();
}
