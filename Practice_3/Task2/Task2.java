public class Task2 {
	public static void main(String[] args){
		Integer[] arr = {3,2,6,4,1,2,1,8,9};
		
		ArrayList arrayList = new ArrayList(arr);
		LinkedList linkedList = new LinkedList(arr);

		//выводин первоначальный массив
		System.out.println("Первоначальный массив");
		arrayList.print();
		System.out.println("LinkedList:");
		linkedList.print();
		
		//выводим кол-во элементов в массиве
		System.out.println("Кол-во элементов");
		System.out.println(arrayList.getSize());
		System.out.println("LinkedList:");
		System.out.println(linkedList.getSize());
		
		//добавляем элемент в середину массива
		System.out.println("добавляем элмент '44' в позицию 7:");
		arrayList.add(7, 44);
		linkedList.add(7,44);

		//добавляем элемент в конец массива
		System.out.println("Добавляем элемент '13' в конец");
		arrayList.add(13);
		linkedList.add(13);

		arrayList.print();
		System.out.println("LinkedList:");
		linkedList.print();

		//удаляем элемент массива
		System.out.println("Удаляем элемент в позиции 3:");
		arrayList.remove(3);
		linkedList.remove(3);

		//изменяем элемент массива
		System.out.println("Изменяем элемент в позиции 4 на '11':");
		arrayList.modify(4, 11);
		linkedList.modify(4,11);

		arrayList.print();
		System.out.println("LinkedList:");
		linkedList.print();
		
		//поиск минимального и максимального элемента
		System.out.println("Минимальынй элемент: " + arrayList.getMin());
		System.out.println("Максимальный элемент: " + arrayList.getMax());
		System.out.println("LinkedList:");
		System.out.println("Минимальынй элемент: " + linkedList.getMin());
		System.out.println("Максимальный элемент: " + linkedList.getMax());

		//сортировка

		System.out.println("Сортировка массива");
		arrayList.printSorted(false);
		arrayList.printSorted(true);
		System.out.println("LinkedList:");
		linkedList.printSorted(false);
		linkedList.printSorted(true);


		//проверка что наш исходный массив не изменен
		System.out.println("Проверка на неизменность исходного массива после сортировок: ");
		arrayList.print();
		System.out.println("LinkedList:");
		linkedList.print();


	}
}