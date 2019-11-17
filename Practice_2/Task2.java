public class Task2 {
	public static void main(String[] args){
		int[] arr = {3,2,6,4,1,2,1,8,9};
		
		MyArray myArr = new MyArray(arr);

		//выводин первоначальный массив
		myArr.printValues();
		
		//выводим кол-во элементов в массиве
		myArr.printCount();
		
		//добавляем элемент в середину массива
		System.out.println("Add element:");
		myArr.add(7, 13);
		myArr.printValues();
		
		//добавляем элемент в конец массива
		System.out.println("Add element to end:");
		myArr.add(44);
		myArr.printValues();
		
		//удаляем элемент массива
		System.out.println("delete element:");
		myArr.delete(10);
		myArr.printValues();
		
		//изменяем элемент массива
		System.out.println("Edit element:");
		myArr.edit(4, 11);
		myArr.printValues();
		
		//поиск минимального и максимального элемента
		myArr.getMinMax();
		
		//сортировка
		myArr.sort(true);
		System.out.println("Print Sorted:");
		myArr.printValues();
		
		myArr.sort(false);
		System.out.println("Print Sorted desc:");
		myArr.printValues();
		
		
		//заполнение массива одинаковыми элементами
		System.out.println("Generate:");
		myArr.generate(7);
		myArr.printValues();
		
		
		//проверка что наш исходный массив не изменен
		System.out.println("Check, print initial array: ");
		MyArray checkArr = new MyArray(arr);
		checkArr.printValues();
	}
}