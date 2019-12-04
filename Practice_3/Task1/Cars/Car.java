public abstract class Car{
	//гос номер
	private int gosNumber;
	//пробег
	private int milage;
	//дополнительная информация
	private int additionalInfo;
	//стоимость расходов
	private double cost;
	//тип авто
	private String type;

	//стоимость топлива и расход !для типа авто
	private static double fuelType, fuelCons;

	//статические геттеры и сеттеры
	public static double getFuelType() {return fuelType;}
	public static void setFuelType(double fuelType) {Car.fuelType = fuelType;}
	public static double getFuelCons() {return fuelCons;}
	public static void setFuelCons(double fuelCons) {Car.fuelCons = fuelCons;}

	//геттеры  и сеттеры
	public double getCost() {return cost;}
	public void setCost(double cost) {this.cost = cost;}
	public int getGosNumber() {return gosNumber;}
	public void setGosNumber(int gosNumber) {this.gosNumber = gosNumber;}
	public int getMilage() {return milage;}
	public void setMilage(int milage) {this.milage = milage;}
	public int getAdditionalInfo() {return additionalInfo;}
	public void setAdditionalInfo(int additionalInfo) {this.additionalInfo = additionalInfo;}
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}

	//добавление милей
	public void addMilage(int milage){
		this.milage += milage;
	}
	public void addAdditionalInfo(int additionalInfo){
		this.additionalInfo += additionalInfo;
	}

	// конструктор, принимающий временный объект со структурированной информацией о машине
	public Car (TempCarParams tempCarParams){
		gosNumber = tempCarParams.getGosNumber();
		milage = tempCarParams.getMilage();
		additionalInfo = tempCarParams.getAdditionalInfo();
	}

	//конструктор по умолчанию
	public Car() {	}

	@Override
	public String toString() {
		StringBuilder tmpReturn = new StringBuilder("гос. номер:" + getGosNumber() + ", пробег:" + getMilage());
		if (getAdditionalInfo() != 0)
			tmpReturn.append(", доп. инфо: " + getAdditionalInfo());
		return  tmpReturn.toString();
	}

	public String getTypeName() {
		return  "Авто";
	}
}