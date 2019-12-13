public class Task5 {
	public static void main(String[] args){
		try {
			Integer[] arr = {3, 2, 6, 4, 1, 2, 1, 8, 9};

			ArrayList arrayList = new ArrayList(arr);

			//выводин первоначальный массив
			System.out.println("Первоначальный массив");
			arrayList.print();

			//выводим кол-во элементов в массиве
			System.out.println("Кол-во элементов");
			System.out.println(arrayList.getSize());

			//добавляем элемент в середину массива
			System.out.println("добавляем элмент '44' в позицию 7:");
			arrayList.safeAdd(7, 44);


			//добавляем элемент в конец массива
			System.out.println("Добавляем элемент '13' в конец");
			arrayList.add(13);

			arrayList.print();

			//удаляем элемент массива
			System.out.println("Удаляем элемент в позиции 3:");
			arrayList.safeRemove(3);

			//изменяем элемент массива
			System.out.println("Изменяем элемент в позиции 4 на '11':");
			arrayList.modify(4, 11);

			arrayList.print();

			//поиск минимального и максимального элемента
			System.out.println("Минимальынй элемент: " + arrayList.getMin());
			System.out.println("Максимальный элемент: " + arrayList.getMax());

			//сортировка
			System.out.println("Сортировка массива");
			arrayList.printSorted(false);
			arrayList.printSorted(true);


			//проверка что наш исходный массив не изменен
			System.out.println("Проверка на неизменность исходного массива после сортировок: ");
			arrayList.print();

			//ошибки
			//ListOutOfRangeException
//			arrayList.add(123123, 123);

			//ListNullException
			ArrayList<Integer> arrNull = new ArrayList(new Integer[]{1});
			arrNull.remove(0);
			arrNull.getMax();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
}