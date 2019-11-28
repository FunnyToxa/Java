public class ArrayList extends List {
	//массив элементов
	private Integer[] array;

	//конструктор, принимающий массив
	public ArrayList(Integer[] arr){
		array = arr.clone();
	}

	//вывод значения элемента по его позиции
	@Override
	public Integer get(int pos){
		return array[pos];
	}

	//добавление элемента в конец
	@Override
	public void add(Integer val){
		Integer[] tmpArr = new Integer[array.length + 1];
		for (int i = 0; i < array.length; i++){
			tmpArr[i] = array[i];
		}
		tmpArr[tmpArr.length-1] = val;
		array = tmpArr;
	}
	
	//добавление элемента по индексу
	@Override
	public boolean add(int pos, Integer val){
		//проверяем, выходит ли позиция за диапазон массива
		if (pos > array.length)
			return false;
		//добавляем
		Integer[] tmpArr = new Integer[array.length + 1];
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
	
	//удаление елемента
	@Override
	public boolean remove(int pos){
		//проверяем - выходит ли позиция за размер массива
		if (pos>=array.length)
			return false;
		Integer[] tmpArr = new Integer[array.length-1];
		for (int i = 0, j = 0; i< tmpArr.length; i++, j++){
			if(pos == j){
				j++;
			}
			tmpArr[i] = array[j];
		}
		array = tmpArr;
		return true;
	}
	
	//вывод кол-ва элементов 
	@Override
	public int getSize(){
		return array.length;
	}
	
	//изменение элемента
	@Override
	public void modify(int pos, Integer newVal){
		array[pos] = newVal;
	}
	
	//заполнение массива одинаковыми элементами
	public void generate(int val){
		for(int i = 0; i < array.length; i++){
			array[i] = val;
		}
	}

	//метод проерки вхождения в
	@Override
	public boolean contains(Integer value){
		for (Integer i: array)
			if (i.equals(value))
				return true;
		return  false;
	}

	//поиск минимальной позиции элемента
	@Override
	public int getMin(){
		int min = array[0];
		int minPos = 0; // добавил на всякий случай, если вдруг нужна будет позиция элемента
		for (int i = 1; i < array.length; i++)
			if (array[i] < min){
				min = array[i];
				minPos = i;
			}
		return min;
	}

	@Override
	public int getMax(){
		int max = array[0];
		int maxPos = 0; // добавил на всякий случай, если вдруг нужна будет позиция элемента
		for (int i = 1; i <array.length; i++)
			if (array[i] > max){
				max = array[i];
				maxPos = i;
			}
		return max;
	}
	
	//вывод отсортированного массива в порядке возрастания и убывания без изменения исходного
	@Override
	public void printSorted(boolean isDesc){
		System.out.println("Вывод отсортированного массива, сортировка по " + (isDesc ? "убыванию" : "возростанию"));
		Integer[] tmpArr = array.clone();
		quickSort(tmpArr, 0, tmpArr.length-1, isDesc);
		print(tmpArr);
	}

	//преобразование листа в массив
	@Override
	public Integer[] toArray(){
		return array.clone();
	}

	//вывод массива
	@Override
	public void print(){
		print(array);
	}
}