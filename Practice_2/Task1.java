import java.util.Arrays;
public class Task1 {
	public static void main(String[] args){
		String[] strCars = {"C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50", "C200_2-40-1000", "C300_2-200-45", "C400_2-10-20", 
			"C100_3-10", "C200_3-170-1100", "C300_3-150-29", "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15"};
		
		//создаем и заполняем массив машин
		Car[] cars = new Car[strCars.length];
		for(int i = 0; i<strCars.length; i++){
			cars[i] = new Car(strCars[i]);
		}
		
		//выводим расходы по всех типам авто
		Car.printAllCost();
		//выводим расходы конкретного типа авто
		Car.printCost("C300");
		//выводим тип машины с минимальным и максимальным расходом
		Car.printMin();
		Car.printMax();

		
		// в разрезе каждого типа авто выводят информацию 
			// о каждом авто (тип, номер, пробег, доп. параметр)
			// , с сортировкой по пробегу и доп параметру. 
		//Сортировка массива
		Arrays.sort(cars);
		System.out.println();
		System.out.println("Sorted info:");
		for(Car car: cars){
			car.printInfo();
		}
	}
}