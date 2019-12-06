// Класс легкового авто
public class LCar extends Car{

    @Override
    public String toString() {
        return getTypeName() + ", " + super.toString();
    }

    @Override
    public String getTypeName() {
        return "Легковой авто";
    }

    public LCar(ICarParams dtoCarParams) {
        super(dtoCarParams);
    }
}
