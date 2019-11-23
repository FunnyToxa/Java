public  class  CarUtils{
    // получаем общую стоимость расходов на ГСМ по всем авто
    public static void printCost(Car[] cars) {
        double allCost = 0;
        for (Car car: cars)
            allCost += car.getCost();
        System.out.println("Общие затраты на ГСМ: " + allCost);
    }

    public static void printCost(Car[] cars, String[] types){
        double[] typeCost = new double[types.length];
        for (Car car: cars)
            for(int i=0; i< types.length; i++)
                if(types[i].equals(car.getType()))
                    typeCost[i] += car.getCost();
        System.out.println("Расход по типам авто: ");
        for (int i=0; i<typeCost.length; i++)
            System.out.println(types[i] + ": " + typeCost[i]);

    }



    //Функция создания машины
    public static Car createCar(TempCarParams tempCarParams){
        Car tmpCar;
        switch (tempCarParams.getType()) {
            case ("C100"):
                tmpCar = new LCar(tempCarParams);
                tmpCar.setCost(CarUtils.calcCost(LCar.getFuelType(), LCar.getFuelCons(), tempCarParams.getMilage()));
                break;
            case ("C200"):
                tmpCar = new Truck(tempCarParams);
                tmpCar.setCost(CarUtils.calcCost(Truck.getFuelType(), Truck.getFuelCons(), tempCarParams.getMilage()));
                break;
            case ("C300"):
                tmpCar = new Bus(tempCarParams);
                tmpCar.setCost(CarUtils.calcCost(Bus.getFuelType(), Bus.getFuelCons(), tempCarParams.getMilage()));
                break;
            case ("C400"):
                tmpCar = new Crane(tempCarParams);
                tmpCar.setCost(CarUtils.calcCost(Crane.getFuelType(), Crane.getFuelCons(), tempCarParams.getMilage()));
                break;
            default:
                tmpCar = new Car();
        }
		tmpCar.setAdditionalInfo(tempCarParams.getAdditionalInfo());
        tmpCar.setType(tempCarParams.getType());
		return tmpCar;
    }

    //вывод тип авто с минимальными затратами
    public static void  printMinCost(Car[] cars)
    {
        Car minCar = cars[0];
        for (Car car: cars) {
            if (car.getCost() < minCar.getCost())
                minCar = car;
        }
        System.out.println("Тип авто с минимальными затратами: " + minCar.getTypeName() + ": " + minCar.getCost());
    }

    //вывод тип авто с максимальными затратами
    public static void  printMaxCost(Car[] cars)
    {
        Car maxCar = cars[0];
        for (Car car: cars) {
            if (car.getCost() > maxCar.getCost())
                maxCar = car;
        }
        System.out.println("Тип авто с минимальными затратами: " + maxCar.getTypeName() + ": " + maxCar.getCost());
    }

    //расчет стоимости расходов на ГСМ
    // на входе цена топлива, расход и пробег
    // на выходе стоимость
    public  static double calcCost(double fuelType, double fuelCons, int milage){
        return fuelType * fuelCons * milage;
    }

    public static void printCarSorted(Car[] cars){
        Car[] tmpCars = cars.clone();
        quickSort(tmpCars,0,tmpCars.length-1);
        printCars(tmpCars, null);
    }

    public static void printCarSorted(Car[] cars, String type){
        Car[] tmpCars = cars.clone();
        quickSort(tmpCars,0,tmpCars.length-1);
        printCars(tmpCars, type);
    }

    //выводит массив машин
//    public static void printCars(Car[] cars){
//        for (Car car: cars){
//            System.out.println(car.toString());
//        }
//    }

    public static int getPosInArr(Car[] cars, Car car){
        for(int i = 0; i < cars.length; i++){
            if (cars[i] != null && car.getType().equals(cars[i].getType()) && car.getGosNumber() == cars[i].getGosNumber())
                return i;
        }
        return -1;
    }

    public static void printCars(Car[] cars, String type){
        for (Car car: cars){
            if (car.getType().equals(type) || type == null)
                System.out.println(car.toString());
        }
    }

    //быстрая сортировка
    private static void quickSort(Car[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot-1);
        quickSort(array, pivot+1, end);
    }
    private static int partition(Car[] array, int begin, int end) {
        int pivot = end;

        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (compare(array[i], array[pivot])<0) /*array[i] < array[pivot])*/ {
                Car temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        Car temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;

        return counter;
    }

    //метод сравнения машин
    //выводит: -1 если Car1, 0 если равны, 1 если Car2
    public static int compare(Car car1, Car car2){
        if (car1.getTypeName().equals(car2.getTypeName()))
        {
            if (car1.getMilage() == car2.getMilage()) {
                return Integer.compare(car1.getAdditionalInfo(), car2.getAdditionalInfo());
            } else {
                return Integer.compare(car1.getMilage(), car2.getMilage());
            }
        } else {
            return car1.getTypeName().compareTo(car2.getTypeName());
        }
    }
}