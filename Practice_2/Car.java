public class Car implements Comparable<Car> {
	private int type, gNum, milage; //тип авто, гос номер, пробег
	private String dopInfo; //доп инфо
	//массив с суммарной стоимостью по каждому типу авто, в порядке соответственно: 0 = C100, 1 = C200 и т.д.
	private static double[] cost = new double[4]; 
	// тип авто с минимальной и максимальной стоимостью , -1 означает, что тип авто не определен
	private static int minType = -1; 
	private static int maxType = -1;
	// общая, минимальная и максимальная стоимость 
	private static double allCost, minCost, maxCost;
	
	
	
	//конструктор, принимающий инфо о машине в виде строки
	public Car(String carInfoStr){
		String[] carInfoArr = carInfoStr.replace('_', '-').split("-");
		getInfo(carInfoArr);
	}

	//получаем информацию по строке
	private void getInfo(String[] arrInfo){
		// Определяем пробег, гос номер и доп инфо.
		gNum = Integer.valueOf(arrInfo[1]);
		milage = Integer.valueOf(arrInfo[2]);
		if (arrInfo.length == 4)
			dopInfo = arrInfo[3];
		
		// Определяем тип, расход, и стоимость 
		double fuelType, fuelCons;
		switch(arrInfo[0]){
			case("C100"):
				type = 0; fuelType = 46.10; fuelCons = 12.5;
				break;
			case("C200"):
				type = 1; fuelType = 48.90; fuelCons = 12;
				break;
			case("C300"):
				type = 2; fuelType = 47.50; fuelCons = 11.5;
				break;
			case("C400"):
				type = 3; fuelType = 48.90; fuelCons = 20;
				break;
			default:
				fuelType = 0; fuelCons = 0;
		}
		//расчет общих расходов и расходов по типу авто
		double oneCost =  milage * fuelType * fuelCons;
		cost[type] += oneCost;
		allCost += oneCost;
		
		// определение мин и макс
		if (minType == -1 || oneCost < minCost){
			minType = type; minCost = oneCost;
		}
		if (maxType == -1 || maxCost < oneCost) {
			maxType = type; maxCost = oneCost;
		}
	}
	
	public static void printAllCost(){
		System.out.println("All Cost: " + allCost);
	}
	
	public static void printCost(){
		for(int i = 0; i<cost.length; i++){
			System.out.println("C" + (i + 1) + "00 cost: " + cost[i]);
		}
	}
	
	public static void printCost(String concreteType){
		System.out.println("Concrete type " + concreteType + " cost: " + cost[Integer.valueOf(concreteType.substring(1,2))-1]);
	}

	public static void printMin(){
		System.out.println("Min Car is C" + (minType + 1) + "00 with consumption " + minCost);
	}
	
	public static void printMax(){
		System.out.println("Max Car is C" + (maxType + 1) + "00 with consumption " + maxCost);
	}
	
	//вывод информации о машине
	public void printInfo(){
		System.out.println("Car type: C" + (type + 1) * 100);
		System.out.println("Gos Number: " + gNum);
		System.out.println("Milage: " + milage);
		if (dopInfo != null)
			System.out.println("dop info: " + dopInfo);
	}
	
	//для сортировки
	@Override
	public int compareTo(Car car){
		if (car.type == type) 
		{
			if (milage == car.milage) {
				if (dopInfo == null)
					return -1;
				else
					return Integer.compare(Integer.valueOf(dopInfo), Integer.valueOf(car.dopInfo));
			} else {
				return Integer.compare(milage, car.milage);
			}
		} else {
			return Integer.compare(type, car.type);
		}
	}
}