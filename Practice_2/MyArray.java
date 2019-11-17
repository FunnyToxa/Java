import java.util.Arrays;
public class MyArray {
	private int[] array;
	//конструктор, принимающий массив
	public MyArray(int[] arr){
		array = new int[arr.length];
		System.arraycopy(arr, 0, array, 0, arr.length);
	}
	
	//добавление элемента в конец
	public void add(int val){
		int tmp[] = new int[array.length + 1];
		System.arraycopy(array, 0, tmp, 0, array.length);
		tmp[array.length] = val;
		array = tmp;
	}
	
	//добавление элемента по индексу
	public void add(int pos, int val){
		if (pos >= array.length){
			add(val);
			return;
		}
		int tmp[] = new int[array.length + 1];
		if (pos > 0) 
			System.arraycopy(array, 0, tmp, 0, pos); // если pos = 0 то ничего не скопируется
		tmp[pos] = val;
		System.arraycopy(array, pos, tmp, pos+1, Math.abs(pos - array.length)); 
		array = tmp;
	}
	
	//удаление елемента
	public void delete(int pos){
		if (pos < 0 || pos >= array.length)
		{
			System.out.println("Possision " + pos + " can't be deleted: out of array range 0 .. " + (array.length-1));
			return;
		}
		int tmp[] = new int[array.length -1];
		if (pos > 0)
			System.arraycopy(array, 0, tmp, 0, pos);
		if (pos < array.length){
			System.arraycopy(array, pos+1, tmp, pos, Math.abs(pos - array.length)-1);
		}
		array = tmp;
	}
	
	//вывод кол-ва элементов 
	public void printCount(){
		System.out.println("Array count: " + array.length);
	}
	
	//изменение элемента
	public void edit(int pos, int newVal){
		array[pos] = newVal;
	}
	
	//вывод элементов 
	public void printValues(){
		printValues(array);
	}
	
	public void printValues(int[] arr){
		// System.out.println("Print elements of array:");
		for(int i = 0; i < arr.length-1; i++){
			System.out.print(arr[i] + ", ");
		}
		System.out.println(arr[arr.length-1]);
		// System.out.println(Arrays.toString(arr)); Через java.util.Arrays
	}
	
	//заполнение массива одинаковыми элементами
	public void generate(int val){
		for(int i = 0; i < array.length; i++){
			array[i] = val;
		}
		// Arrays.fill(array, val); Через java.util.Arrays
	}
	
	public void getMinMax(){
		int indMax = 0;
		int indMin = 0;
		for (int i = 1; i < array.length; i++)
		{
			if (array[i] > array[indMax])
			{
				indMax = i;
			}
			else if (array[i] < array[indMin])
			{
				indMin = i;
			}
		}
		
		System.out.println("Min element: " + array[indMin]);
		System.out.println("Max element: " + array[indMax]);
	}
	
	//вывод отсортированного массива в порядке возрастания и убывания без изменения исходного
	public void sort(boolean isDesc){
		// int[] tmp = new int[array.length];
		// System.arraycopy(array, 0, tmp, 0, array.length);
		// System.out.println("Print Sorted:");
		Arrays.sort(array);
		// printValues(tmp);
		// Arrays.sort(tmp, Collections.reverseOrder()); //что-то не пошла сортировка в обратную сторону, сделал через реверс :)
		if (isDesc)
			reverseArray(array);
		// printValues(tmp);
		// array = tmp;
	}
	
	private void reverseArray(int[] arr){
		for(int i = 0; i < arr.length / 2; i++){
			int temp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;
		}
	}
}