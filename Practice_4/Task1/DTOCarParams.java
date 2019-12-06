public class DTOCarParams implements ICarParams {
	//тип авто
	private String type;
	//гос номер
	private int gosNumber;
	//пробег
	private int milage;
	//дополнительная информация
	private int additionalInfo;

	//Конструктор для создания объекта
	public DTOCarParams(String type, int gosNumber, int milage) {
		this.type = type;
		this.gosNumber = gosNumber;
		this.milage = milage;
	}

	//геттеры и сеттеры по полям
	@Override
	public String getType() {return type;}
	@Override
	public void setType(String type) {this.type = type;}
	@Override
	public int getGosNumber() {return gosNumber;}
	@Override
	public void setGosNumber(int gosNumber) {this.gosNumber = gosNumber;}
	@Override
	public int getMilage() {return milage;}
	@Override
	public void setMilage(int milage) {this.milage = milage;}
	@Override
	public int getAdditionalInfo() {return additionalInfo;}
	@Override
	public void setAdditionalInfo(int additionalInfo) {this.additionalInfo = additionalInfo;}
}