import java.util.*;

public class CarUtils{
    // получаем общую стоимость расходов на ГСМ по всем авто
    public static void printCost(Collection<Car> cars) {
        double allCost = 0;
        for (Car car: cars)
            allCost += car.getCost();
        System.out.println("Общие затраты на ГСМ: " + allCost);
    }

    //вывод
    public static void printCost(Collection<Car> cars, String[] types){
//        double[] typeCost = new double[types.length];
        Map<String, Double> costMap = new HashMap<>();
        for (Car car: cars){
            double oldCost = 0;
            if (costMap.containsKey(car.getType()))
                oldCost = costMap.get(car.getType());
            costMap.put(car.getType(), car.getCost() + oldCost);
        }
        System.out.println("Расход по типам авто: ");
        for (String key: costMap.keySet())
            System.out.println(key + ": " + costMap.get(key));
    }



    //Функция создания машины
    public static Car createCar(DTOCarParams dtoCarParams){
        Car tmpCar = null;
        switch (dtoCarParams.getType()) {
            case ("C100"):
                tmpCar = new LCar(dtoCarParams);
                tmpCar.setFuelCons(12.5);
                tmpCar.setFuelPrice(46.10);
                break;
            case ("C200"):
                tmpCar = new Truck(dtoCarParams);
                tmpCar.setFuelCons(12);
                tmpCar.setFuelPrice(48.90);
                break;
            case ("C300"):
                tmpCar = new Bus(dtoCarParams);
                tmpCar.setFuelCons(11.5);
                tmpCar.setFuelPrice(47.50);
                break;
            case ("C400"):
                tmpCar = new Crane(dtoCarParams);
                tmpCar.setFuelCons(20);
                tmpCar.setFuelPrice(48.90);
                break;
        }
		tmpCar.setAdditionalInfo(dtoCarParams.getAdditionalInfo());
        tmpCar.setType(dtoCarParams.getType());
		return tmpCar;
    }

    //вывод тип авто с минимальными затратами
    public static void  printMinCost(Collection<Car> cars)
    {
        TreeSet<Car> set = new TreeSet<>(cars);
        System.out.println("Тип авто с минимальными затратами: " + set.first().getTypeName() + ": " + set.first().getCost());
    }

    //вывод тип авто с максимальными затратами
    public static void  printMaxCost(Collection<Car> cars)
    {
        TreeSet<Car> set = new TreeSet<>(cars);
        System.out.println("Тип авто с минимальными затратами: " + set.last().getTypeName() + ": " + set.last().getCost());
    }

    //расчет стоимости расходов на ГСМ
    // на входе цена топлива, расход и пробег
    // на выходе стоимость
    public  static double calcCost(double fuelType, double fuelCons, int milage){
        return fuelType * fuelCons * milage;
    }

    //вывод отсортированной информации об авто всех типов
    public static void printCarSorted(Collection<Car> cars){
        printCarSorted(cars, null);
    }

    //вывод отсортированной информации об определенного типа (если null - всех типов)
    public static void printCarSorted(Collection<Car> cars, String type){
        TreeSet<Car> tmpCars = new TreeSet<>(cars);
        printCars(tmpCars, type);
    }


    //вывод информации о машинах определенного типа (если null - выводим все типы)
    public static void printCars(Collection<Car> cars, String type){
        for (Car car: cars){
            if (car.getType().equals(type) || type == null)
                System.out.println(car.toString());
        }
    }
}