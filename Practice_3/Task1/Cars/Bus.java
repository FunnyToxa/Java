// Класс  Пассажирский транспорт
public class Bus extends Car{

    @Override
    public String toString() {
        return getTypeName() + ", " + super.toString();
    }

    public Bus(TempCarParams tempCarParams) {
        super(tempCarParams);
    }

    @Override
    public String getTypeName() {
        return "Пассажирский транспорт";
    }
}
