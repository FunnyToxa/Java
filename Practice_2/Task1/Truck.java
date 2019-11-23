// Класс грузовой авто
public class Truck extends Car{

    @Override
    public String toString() {
        return getTypeName() + ", " + super.toString();
    }

    public Truck(TempCarParams tempCarParams) {
        super(tempCarParams);
    }

    @Override
    public String getTypeName() {
        return "Грузовой авто";
    }
}
