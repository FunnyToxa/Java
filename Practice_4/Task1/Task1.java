import java.util.ArrayList;

public class Task1 {
	public static void main(String[] args){
		//входной массив информации о машинах в виде строки
		String[] strCars = {"C100_1-100_200", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-10_60", "C200_2-40-1000", "C300_2-200-45", "C400_2-10-20",
			"C100_3-10", "C200_3-170-1100", "C300_3-150-29", "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15"};
		
		ArrayList<Car> cars = new ArrayList<>();
		int newLength = 0;
		for(int i = 0; i<strCars.length; i++){
			DTOCarParams dtoCarParams = CarParser.ParseFromString(strCars[i]);
			Car tmpCar = CarUtils.createCar(dtoCarParams);
			if (cars.contains(tmpCar)){
				cars.get(cars.indexOf(tmpCar)).addMilage(tmpCar.getMilage());
				cars.get(cars.indexOf(tmpCar)).addAdditionalInfo(tmpCar.getAdditionalInfo());
			} else {
				cars.add(tmpCar);
			}
		}

		//выводим расходы по всех типам авто
		CarUtils.printCost(cars);
		//выводим расходы в разрезе авто с сортировкой
		System.out.println("вывод в разрезе С100 с сортировкой по пробегу и доп. параметру:");
		CarUtils.printCarSorted(cars, "C100");
		System.out.println();
		//выводим тип машины с минимальным и максимальным расходом
		CarUtils.printMinCost(cars);
		CarUtils.printMaxCost(cars);

		//вывод расходов на ГСМ в разрезе типов
		CarUtils.printCost(cars, new String[]{"C100", "C200", "C300", "C400"});
	}
}