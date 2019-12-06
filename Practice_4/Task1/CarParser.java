public class CarParser{
	public static DTOCarParams ParseFromString(String carInStr){
		//разбиение строки на массив строковых параметров
		String[] carInfoArr = carInStr.replace('_', '-').split("-");
		
		//создаем объект промежуточного класса для информации о машине
		//через конструктор класса сразу заполняем инфо о типе авто, гос номере, пробеге
		DTOCarParams tmp = new DTOCarParams(carInfoArr[0], Integer.valueOf(carInfoArr[1]), Integer.valueOf(carInfoArr[2]));
		
		//проверяем через длину массива есть ли параметр доп. информации.
		if (carInfoArr.length == 4)
			tmp.setAdditionalInfo(Integer.valueOf(carInfoArr[3]));

		//возвращаяем объект класса TempCarParams
		return tmp;
	}
}