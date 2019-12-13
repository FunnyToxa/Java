import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class ArrayList<T> implements IList<T> {
	//массив элементов
	private T[] array;

	//конструктор, принимающий массив
	public ArrayList(T[] arr){
		array = arr.clone();
	}

	//вывод значения элемента по его позиции
	@Override
	public T get(int pos) throws ListOutOfRangeException {
		if (pos >= array.length)
			throw new ListOutOfRangeException("Позиция элемента " + pos + " выходит за рамки диапазона!");
		return array[pos];
	}

	//добавление элемента в конец
	@Override
	public void add(T val){
		T[] tmpArr = (T[]) new Object[array.length + 1];
		for (int i = 0; i < array.length; i++){
			tmpArr[i] = array[i];
		}
		tmpArr[tmpArr.length-1] = val;
		array = tmpArr;
	}
	
	//безопасное добавление добавление элемента по индексу
	public boolean safeAdd(int pos, T val){
		//проверяем, выходит ли позиция за диапазон массива
		if (pos > array.length)
			return false;
		//добавляем
		T[] tmpArr = (T[])new Object[array.length + 1];
		for (int i = 0, j = 0; i < array.length; i++, j++){
			if (i == pos){
				j++;
			}
			tmpArr[j] = array[i];
		}
		tmpArr[pos] = val;
		array = tmpArr;
		return  true;
	}

	@Override
	public void add(int pos, T val) throws ListOutOfRangeException {
		if (safeAdd(pos, val) == false)
			throw new ListOutOfRangeException("Позиция элемента " + pos + " выходит за рамки диапазона!");
	}

	//удаление елемента
	public boolean safeRemove(int pos){
		//проверяем - выходит ли позиция за размер массива
		if (pos>=array.length)
			return false;
		T[] tmpArr = (T[])new Object[array.length-1];
		for (int i = 0, j = 0; i< tmpArr.length; i++, j++){
			if(pos == j){
				j++;
			}
			tmpArr[i] = array[j];
		}
		array = tmpArr;
		return true;
	}

	@Override
	public void remove(int pos) throws ListOutOfRangeException {
		if (safeRemove(pos) == false)
			throw new ListOutOfRangeException("Позиция элемента " + pos + " выходит за рамки диапазона!");
	}

	//вывод кол-ва элементов
	@Override
	public int getSize(){
		return array.length;
	}
	
	//изменение элемента
	@Override
	public void modify(int pos, T newVal) throws ListOutOfRangeException{
		if (pos >= array.length)
			throw new ListOutOfRangeException("Позиция элемента " + pos + " выходит за рамки диапазона!");
		array[pos] = newVal;
	}
	
	//метод проерки вхождения в
	@Override
	public boolean contains(T value){
		for (T i: array)
			if (i.equals(value))
				return true;
		return  false;
	}

	//поиск минимальной позиции элемента
	@Override
	public T getMin() throws ListNullException{
		if (getSize() == 0)
			throw new ListNullException("Массив эелементов пуст!");
		T[] tmpArr = array.clone();
		Arrays.sort(tmpArr);
		return tmpArr[0];
	}

	@Override
	//поиск максимальной позиции элемента
	public T getMax() throws ListNullException{
		if (getSize() == 0)
			throw new ListNullException("Массив эелементов пуст!");
        T[] tmpArr = array.clone();
        Arrays.sort(tmpArr);
        return tmpArr[tmpArr.length-1];
	}
	
	//вывод отсортированного массива в порядке возрастания и убывания без изменения исходного
	public void printSorted(boolean isDesc){
		System.out.println("Вывод отсортированного массива, сортировка по " + (isDesc ? "убыванию" : "возростанию"));
		T[] tmpArr = array.clone();
		//если нужно сортировать в обратно порядке то передаем в качестве обратного компоратора Collections.reverseOrder()
		//! не работает с примитивными типами! но по условиям задачи - у нас и не должно быть приминивных типов
		if (isDesc)
			Arrays.sort(tmpArr, Collections.reverseOrder());
		else
        	Arrays.sort(tmpArr);
		print(tmpArr);
	}

	//преобразование листа в массив
	@Override
	public T[] toArray(){
		return array.clone();
	}

	//вывод массива
	@Override
	public void print(){
		print(array);
	}

    private void print(T[] tmpArray) {
        System.out.println("Вывод массива: ");
        for (T t: tmpArray)
            System.out.print(t.toString() + " ");
        System.out.println();
    }
}