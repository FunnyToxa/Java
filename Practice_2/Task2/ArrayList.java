public class ArrayList {
	//массив элементов
	private Integer[] array;

	//конструктор, принимающий массив
	public ArrayList(Integer[] arr){
		array = arr.clone();
	}

	//вывод значения элемента по его позиции
	public Integer get(int pos){
		return array[pos];
	}

	//добавление элемента в конец
	public void add(int val){
		Integer[] tmpArr = new Integer[array.length + 1];
		for (int i = 0; i < array.length; i++){
			tmpArr[i] = array[i];
		}
		tmpArr[tmpArr.length-1] = val;
		array = tmpArr;
	}
	
	//добавление элемента по индексу
	public boolean add(int pos, int val){
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
	public int getSize(){
		return array.length;
	}
	
	//изменение элемента
	public void modify(int pos, int newVal){
		array[pos] = newVal;
	}
	
	//заполнение массива одинаковыми элементами
	public void generate(int val){
		for(int i = 0; i < array.length; i++){
			array[i] = val;
		}
	}

	//метод проерки вхождения в
	public boolean contains(Integer value){
		for (Integer i: array)
			if (i.equals(value))
				return true;
		return  false;
	}

	//поиск минимальной позиции элемента
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
	public void printSorted(boolean isDesc){
		System.out.println("Вывод отсортированного массива, сортировка по " + (isDesc ? "убыванию" : "возростанию"));
		Integer[] tmpArr = array.clone();
		quickSort(tmpArr, 0, tmpArr.length-1, isDesc);
		print(tmpArr);
	}

	//быстрая сортировка
	private static void quickSort(Integer[] inArray, int begin, int end, boolean isDesc) {
		if (end <= begin)
			return;
		int pivot = partition(inArray, begin, end, isDesc);
		quickSort(inArray, begin, pivot-1, isDesc);
		quickSort(inArray, pivot+1, end, isDesc);
	}
	private static int partition(Integer[] inArray, int begin, int end, boolean isDesc) {
		int pivot = end;

		int counter = begin;
		for (int i = begin; i < end; i++) {
			if (inArray[i].intValue() < inArray[pivot].intValue() && !isDesc) {
				Integer temp = inArray[counter];
				inArray[counter] = inArray[i];
				inArray[i] = temp;
				counter++;
			}
			if (inArray[i].intValue() > inArray[pivot].intValue() && isDesc) {
				Integer temp = inArray[counter];
				inArray[counter] = inArray[i];
				inArray[i] = temp;
				counter++;
			}
		}
		Integer temp = inArray[pivot];
		inArray[pivot] = inArray[counter];
		inArray[counter] = temp;

		return counter;
	}

	//преобразование листа в массив
	public Integer[] toArray(){
		return array.clone();
	}

	//вывод массива
	public void print(){
		print(array);
	}

	//вывод определенного массива
	private void print(Integer[] tmpArray) {
		System.out.println("Вывод массива: ");
		for (Integer i: tmpArray)
			System.out.print(i + " ");
		System.out.println();
	}
}