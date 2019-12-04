// Класс легкового авто
public class LCar extends Car{

    @Override
    public String toString() {
        return getTypeName() + ", " + super.toString();
    }

    public LCar(TempCarParams tempCarParams) {
        super(tempCarParams);
    }

    @Override
    public String getTypeName() {
        return "Легковой авто";
    }
}
