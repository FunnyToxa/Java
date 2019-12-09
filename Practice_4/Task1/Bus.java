// Класс  Пассажирский транспорт
public class Bus extends Car{

    @Override
    public String toString() {
        return getTypeName() + ", " + super.toString();
    }

    @Override
    public String getTypeName() {
        return "Пассажирский транспорт";
    }

    public Bus(DTOCarParams dtoCarParams) {
        super(dtoCarParams);
    }
}
