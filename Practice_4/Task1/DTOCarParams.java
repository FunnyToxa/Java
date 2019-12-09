public class DTOCarParams {
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
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}
	public int getGosNumber() {return gosNumber;}
	public void setGosNumber(int gosNumber) {this.gosNumber = gosNumber;}
	public int getMilage() {return milage;}
	public void setMilage(int milage) {this.milage = milage;}
	public int getAdditionalInfo() {return additionalInfo;}
	public void setAdditionalInfo(int additionalInfo) {this.additionalInfo = additionalInfo;}
}