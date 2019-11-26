public class Task2 {
	public static void main(String[] args){
		Integer[] arr = {3,2,6,4,1,2,1,8,9};
		
		ArrayList myArr = new ArrayList(arr);

		//выводин первоначальный массив
		System.out.println("Первоначальный массив");
		myArr.print();
		
		//выводим кол-во элементов в массиве
		System.out.println("Кол-во элементов");
		System.out.println(myArr.getSize());
		
		//добавляем элемент в середину массива
		System.out.println("добавляем элмент '44' в позицию 7:");
		myArr.add(7, 44);

		//добавляем элемент в конец массива
		System.out.println("Добавляем элемент '13' в конец");
		myArr.add(13);

		myArr.print();

		//удаляем элемент массива
		System.out.println("Удаляем элемент в позиции 3:");
		myArr.remove(3);

		//изменяем элемент массива
		System.out.println("Изменяем элемент в позиции 4 на '11':");
		myArr.modify(4, 11);

		myArr.print();
		
		//поиск минимального и максимального элемента
		System.out.println("Минимальынй элемент: " + myArr.getMin());
		System.out.println("Максимальный элемент: " + myArr.getMax());
		
		//сортировка

		System.out.println("Сортировка массива");
		myArr.printSorted(false);
		myArr.printSorted(true);


		//проверка что наш исходный массив не изменен
		System.out.println("Проверка на неизменность исходного массива после сортировок: ");
		myArr.print();
		
		
		//заполнение массива одинаковыми элементами
		System.out.println("Заполнение одинаковыми элементами '7':");
		myArr.generate(7);

		myArr.print();

	}
}